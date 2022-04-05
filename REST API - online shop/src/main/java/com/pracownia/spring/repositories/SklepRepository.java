package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Sklep;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface SklepRepository extends CrudRepository<Sklep, Integer>, PagingAndSortingRepository<Sklep, Integer> {

    @Query("SELECT count(a.Sklep.id) from Asortyment a left join Sklep s on a.Sklep.id=s.id where s.id=?1")
    Integer howManyProducts(Integer id);

    @Query("select count(s) from Sklep s where s.id = ?1")
    Integer checkIfExists(Integer id);
}
