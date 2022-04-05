package com.pracownia.spring.repositories;


import com.pracownia.spring.entities.Wlasciciel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WlascicielRepository extends CrudRepository<Wlasciciel, Integer>, PagingAndSortingRepository<Wlasciciel, Integer> {
    @Query("select count(w) from Wlasciciel w where w.idWlasciciela = ?1")
    Integer checkIfWlascicielExists(Integer id);
}
