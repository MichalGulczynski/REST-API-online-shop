package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Asortyment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

public interface AsortymentRepository extends CrudRepository<Asortyment, Integer>, PagingAndSortingRepository<Asortyment, Integer> {

    @Query("select count(a) from Asortyment a where a.id = ?1")
    Integer checkIfExists(Integer id);
    @Query("select a from Asortyment a where a.Sklep.id=?1")
    Iterable<Asortyment> listAsortymentByShopIdPaging(Integer id, PageRequest pageRequest);

    @Query ("Select a from Asortyment a where a.cena_jednostkowa=(SELECT max(a.cena_jednostkowa) FROM Asortyment a)")
    Iterable<Asortyment> selectMostExpensiveAsortyment();

}
