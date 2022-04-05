package com.pracownia.spring.services;


import com.pracownia.spring.entities.Sklep;
import java.util.Optional;

public interface SklepService {
    Iterable<Sklep> listAllSkleps();

    Optional<Sklep> getSklepById(Integer id);

    Sklep saveSklep(Sklep sklep);

    void deleteSklep(Integer id);

    Boolean checkIfSklepExist(Integer id);

    Integer howManyProducts(Integer id);

    Iterable<Sklep> listAllSklepsPaging(Integer pageNr, Integer howManyOnPage);
}
