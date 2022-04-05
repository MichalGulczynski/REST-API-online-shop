package com.pracownia.spring.services;

import com.pracownia.spring.entities.Lokalizacja;
import io.swagger.models.auth.In;
import org.joda.time.LocalTime;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.Optional;


public interface LokalizacjaService {
    Iterable<Lokalizacja> listAllLokalizacja();

    Optional<Lokalizacja> getLokalizacjaById(Integer id);

    Lokalizacja saveLokalizacja(Lokalizacja lokalizacja);

    void deleteLokalizacja(Integer id);

    Boolean checkIfLokalizacjaExist(Integer id);

    Iterable<Lokalizacja> listAllLokalizacjaPaging(Integer pageNr, Integer howManyOnPage);

    Boolean checkIfOpen(Date now, Integer id);

}
