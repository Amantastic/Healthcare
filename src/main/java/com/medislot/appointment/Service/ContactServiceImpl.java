package com.medislot.appointment.Service;

import com.medislot.appointment.Entity.Contact;
import com.medislot.appointment.Repository.ContactRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public Contact submitContact(Contact contact) {
        contact.setSubmittedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
