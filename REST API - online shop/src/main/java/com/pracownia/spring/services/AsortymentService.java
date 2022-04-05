package com.pracownia.spring.services;

import java.awt.print.Pageable;
import java.util.Optional;
import com.pracownia.spring.entities.Asortyment;
import org.springframework.data.domain.PageRequest;

public interface AsortymentService {
    Iterable<Asortyment> listAllAsortyments();

    Optional<Asortyment> getAsortymentById(Integer id);

    Asortyment saveAsortyment(Asortyment asortyment);

    void deleteAsortyment(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Asortyment> listAllAsortymentsPaging(Integer pageNr, Integer howManyOnPage);

    Iterable<Asortyment> listAsortymentByShopIdPaging(Integer id, Integer pageNr,Integer howManyOnPage);

    Iterable<Asortyment> selectMostExpensiveAsortyment();
}





