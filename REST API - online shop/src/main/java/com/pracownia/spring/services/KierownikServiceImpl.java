package com.pracownia.spring.services;

import com.pracownia.spring.entities.Kierownik;
import com.pracownia.spring.entities.Wlasciciel;
import com.pracownia.spring.repositories.KierownikRepository;
import com.pracownia.spring.repositories.WlascicielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class KierownikServiceImpl implements KierownikService {
    @Autowired
    private KierownikRepository kierownikRepository;

    @Override
    public Iterable<Kierownik> listAllKierownik() {
        return kierownikRepository.findAll();
    }

    @Override
    public Optional<Kierownik> getKierownikById(Integer id) {
        return kierownikRepository.findById(id);
    }

    @Override
    public Kierownik saveKierownik(Kierownik kierownik) {
        return kierownikRepository.save(kierownik);
    }

    @Override
    public void deleteKierownik(Integer id) {
        kierownikRepository.deleteById(id);
    }

    @Override
    public Iterable<Kierownik> listAllKierownikPaging(Integer pageNr, Integer howManyOnPage) {
        return kierownikRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }

    @Override
    @Transactional
    public Boolean checkIfKierownikExists(Integer id) {
        if (kierownikRepository.checkIfKierownikExists(id) > 0)
            return true;
        else
            return false;
    }
}
