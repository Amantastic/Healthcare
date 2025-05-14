package com.medislot.appointment.Service;

import com.medislot.appointment.Entity.Contact;

import java.util.List;

public interface ContactService {
    Contact submitContact(Contact contact);
    List<Contact> getAllContacts();
    void deleteContact(Long id);
}
