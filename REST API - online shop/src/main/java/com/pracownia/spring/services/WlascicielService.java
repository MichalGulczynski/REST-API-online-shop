package com.pracownia.spring.services;

import com.pracownia.spring.entities.Sklep;
import com.pracownia.spring.entities.Wlasciciel;

import java.util.Optional;

public interface WlascicielService {
    Iterable<Wlasciciel> listAllWlasciciels();

    Optional<Wlasciciel> getWlascicielById(Integer id);

    Wlasciciel saveWlasciciel(Wlasciciel wlasciciel);

    void deleteWlasciciel(Integer id);

    Boolean checkIfWlascicielExists(Integer id);

    Iterable<Wlasciciel> listAllWlascicielsPaging(Integer pageNr, Integer howManyOnPage);
}
