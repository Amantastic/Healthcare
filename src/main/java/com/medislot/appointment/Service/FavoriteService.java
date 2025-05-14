package com.medislot.appointment.Service;

import com.medislot.appointment.Entity.Favorite;

import java.util.List;

public interface FavoriteService {
    Favorite addFavorite(Favorite favorite);
    List<Favorite> getFavoritesByUserId(Long userId);
    void deleteFavorite(Long id);
}
