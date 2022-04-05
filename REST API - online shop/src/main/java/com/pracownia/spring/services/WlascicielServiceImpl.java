package com.pracownia.spring.services;

import com.pracownia.spring.entities.Sklep;
import com.pracownia.spring.entities.Wlasciciel;
import com.pracownia.spring.repositories.SklepRepository;
import com.pracownia.spring.repositories.WlascicielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class WlascicielServiceImpl implements WlascicielService {
    @Autowired
    private WlascicielRepository wlascicielRepository;

    @Override
    public Iterable<Wlasciciel> listAllWlasciciels() {
        return wlascicielRepository.findAll();
    }

    @Override
    public Optional<Wlasciciel> getWlascicielById(Integer id) {
        return wlascicielRepository.findById(id);
    }

    @Override
    public Wlasciciel saveWlasciciel(Wlasciciel wlasciciel) {
        return wlascicielRepository.save(wlasciciel);
    }

    @Override
    public void deleteWlasciciel(Integer id) {
        wlascicielRepository.deleteById(id);
    }

    @Override
    public Iterable<Wlasciciel> listAllWlascicielsPaging(Integer pageNr, Integer howManyOnPage) {
        return wlascicielRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }

    @Override
    @Transactional
    public Boolean checkIfWlascicielExists(Integer id) {
        if (wlascicielRepository.checkIfWlascicielExists(id) > 0)
            return true;
        else
            return false;
    }
}
