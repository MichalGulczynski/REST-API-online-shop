package com.pracownia.spring.services;

import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.pracownia.spring.entities.Lokalizacja;
import com.pracownia.spring.repositories.LokalizacjaRepository;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.Date;
import java.util.Optional;

@Service
public class LokalizacjaServiceImpl implements LokalizacjaService{
    @Autowired
    private LokalizacjaRepository lokalizacjaRepository;

    @Override
    public Iterable<Lokalizacja> listAllLokalizacja() {
        return lokalizacjaRepository.findAll();
    }

    @Override
    public Optional<Lokalizacja> getLokalizacjaById(Integer id) {
        return lokalizacjaRepository.findById(id);
    }

    @Override
    public Lokalizacja saveLokalizacja(Lokalizacja lokalizacja) {
        return lokalizacjaRepository.save(lokalizacja);
    }

    @Override
    public void deleteLokalizacja(Integer id) {
        lokalizacjaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean checkIfLokalizacjaExist(Integer id) {
        if (lokalizacjaRepository.checkIfLokalizacjaExists(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterable<Lokalizacja> listAllLokalizacjaPaging(Integer pageNr, Integer howManyOnPage) {
        return lokalizacjaRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }

    @Override
    public Boolean checkIfOpen(Date now, Integer id) {
        if(lokalizacjaRepository.checkIfOpen(now,id)>0)
            return true;
        else
            return false;

    }
}
