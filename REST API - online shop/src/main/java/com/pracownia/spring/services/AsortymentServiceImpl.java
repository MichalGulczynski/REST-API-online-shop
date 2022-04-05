package com.pracownia.spring.services;

import com.pracownia.spring.entities.Asortyment;
import com.pracownia.spring.repositories.AsortymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class AsortymentServiceImpl implements AsortymentService {
    @Autowired
    private AsortymentRepository asortymentRepository;

    @Override
    public Iterable<Asortyment> listAllAsortyments() {
        return asortymentRepository.findAll();
    }

    @Override
    public Optional<Asortyment> getAsortymentById(Integer id) {
        return asortymentRepository.findById(id);
    }

    @Override
    public Asortyment saveAsortyment(Asortyment asortyment) {
        return asortymentRepository.save(asortyment);
    }

    @Override
    public void deleteAsortyment(Integer id) {
        asortymentRepository.deleteById(id);
    }


    @Override
    @Transactional
    public Boolean checkIfExist(Integer id) {
        if (asortymentRepository.checkIfExists(id) > 0)
            return true;
        else
            return false;
    }


    @Override
    public Iterable<Asortyment> listAllAsortymentsPaging(Integer pageNr, Integer howManyOnPage) {
        return asortymentRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }

    @Override
    @Transactional
    public Iterable<Asortyment> listAsortymentByShopIdPaging(Integer id, Integer pageNr,Integer howManyOnPage){
        return asortymentRepository.listAsortymentByShopIdPaging(id,PageRequest.of(pageNr,howManyOnPage));
    }

    @Override
    @Transactional
    public Iterable<Asortyment> selectMostExpensiveAsortyment(){
        return asortymentRepository.selectMostExpensiveAsortyment();
    }

}
