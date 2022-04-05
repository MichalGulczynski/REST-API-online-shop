package com.pracownia.spring.services;

import com.pracownia.spring.entities.Kierownik;
import com.pracownia.spring.entities.Wlasciciel;

import java.util.Optional;

public interface KierownikService {
    Iterable<Kierownik> listAllKierownik();

    Optional<Kierownik> getKierownikById(Integer id);

    Kierownik saveKierownik(Kierownik kierownik);

    void deleteKierownik(Integer id);

    Boolean checkIfKierownikExists(Integer id);

    Iterable<Kierownik> listAllKierownikPaging(Integer pageNr, Integer howManyOnPage);
}
