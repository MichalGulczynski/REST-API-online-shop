package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Lokalizacja;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.joda.time.LocalTime;

import java.sql.Time;
import java.util.Date;

public interface LokalizacjaRepository extends CrudRepository<Lokalizacja, Integer>, PagingAndSortingRepository<Lokalizacja, Integer> {
    @Query("select count(l) from Lokalizacja l where l.idLokalizacji = ?1")
    Integer checkIfLokalizacjaExists(Integer id);

    @Query("SELECT count(l) FROM Lokalizacja l where l.godzinaOtwarcia<?1 and l.godzinaZamkniecia>?1 and l.idLokalizacji=?2")
    Integer checkIfOpen(Date now, Integer id);
}
