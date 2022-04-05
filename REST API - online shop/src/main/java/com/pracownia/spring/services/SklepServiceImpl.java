package com.pracownia.spring.services;


import com.pracownia.spring.entities.Sklep;
import com.pracownia.spring.repositories.SklepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SklepServiceImpl implements SklepService{
    @Autowired
    private SklepRepository sklepRepository;

    @Override
    public Iterable<Sklep> listAllSkleps() {
        return sklepRepository.findAll();
    }

    @Override
    public Optional<Sklep> getSklepById(Integer id) {
        return sklepRepository.findById(id);
    }

    @Override
    public Sklep saveSklep(Sklep sklep) {
        return sklepRepository.save(sklep);
    }

    @Override
    public void deleteSklep(Integer id) {
        sklepRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean checkIfSklepExist(Integer id) {
        if (sklepRepository.checkIfExists(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    @Transactional
    public Integer howManyProducts(Integer id){
        return sklepRepository.howManyProducts(id);
    }



    @Override
    public Iterable<Sklep> listAllSklepsPaging(Integer pageNr, Integer howManyOnPage) {
        return sklepRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }
}
