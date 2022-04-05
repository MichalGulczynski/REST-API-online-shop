package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name="Lokalizacja")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Asortyment.class)
public class Lokalizacja {
        @Id
        @Column(name="id_lokalizacji")
        private Integer idLokalizacji;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="id_sklepu", nullable = true)
        private Sklep Sklep;

        @Column(name = "miasto")
        private String miasto;

        @Column(name = "ulica")
        private String ulica;

        @Column(name="godzina_otwarcia")
        private Time godzinaOtwarcia;

        @Column(name="godzina_zamkniecia")
        private Time godzinaZamkniecia;


       public Lokalizacja(){

       }

    public Lokalizacja(Integer idLokalizacji, Sklep sklep, String miasto, String ulica, Time godzinaOtwarcia, Time godzinaZamkniecia) {
           this.idLokalizacji=idLokalizacji;
           this.Sklep = sklep;
           this.miasto = miasto;
           this.ulica = ulica;
           this.godzinaOtwarcia=godzinaOtwarcia;
           this.godzinaZamkniecia=godzinaZamkniecia;
    }

    public Integer getIdLokalizacji() {
        return idLokalizacji;
    }

    public void setIdLokalizacji(Integer idLokalizacji) {
        this.idLokalizacji = idLokalizacji;
    }

    public com.pracownia.spring.entities.Sklep getSklep() {
        return Sklep;
    }

    public void setSklep(com.pracownia.spring.entities.Sklep sklep) {
        Sklep = sklep;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public Time getGodzinaOtwarcia() {
        return godzinaOtwarcia;
    }

    public void setGodzinaOtwarcia(Time godzinaOtwarcia) {
        this.godzinaOtwarcia = godzinaOtwarcia;
    }

    public Time getGodzinaZamkniecia() {
        return godzinaZamkniecia;
    }

    public void setGodzinaZamkniecia(Time godzinaZamkniecia) {
        this.godzinaZamkniecia = godzinaZamkniecia;
    }
}
