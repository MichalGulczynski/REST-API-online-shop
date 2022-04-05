package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Kierownik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KierownikRepository extends CrudRepository<Kierownik, Integer>, PagingAndSortingRepository<Kierownik, Integer> {
    @Query("select count(k) from Kierownik k where k.idKierownika = ?1")
    Integer checkIfKierownikExists(Integer id);
}
