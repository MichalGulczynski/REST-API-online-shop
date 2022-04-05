package com.pracownia.spring.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="Wlasciciel")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Asortyment.class)
public class Wlasciciel {
    @Id
    @Column(name="id_wlasciciela")
    private Integer idWlasciciela;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_sklepu", referencedColumnName ="id")
    private Sklep Sklep;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    public Wlasciciel(){

    }

    public Wlasciciel(Integer idWlasciciela, Sklep sklep, String imie, String nazwisko) {
        this.idWlasciciela = idWlasciciela;
        this.Sklep = sklep;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Integer getIdWlasciciela() {
        return idWlasciciela;
    }

    public void setIdWlasciciela(Integer idWlasciciela) {
        this.idWlasciciela = idWlasciciela;
    }

    public com.pracownia.spring.entities.Sklep getSklep() {
        return Sklep;
    }

    public void setSklep(com.pracownia.spring.entities.Sklep sklep) {
        Sklep = sklep;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
