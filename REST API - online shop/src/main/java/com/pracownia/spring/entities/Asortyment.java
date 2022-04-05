package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pracownia.spring.entities.Sklep;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="asortyment")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Asortyment.class)
public class Asortyment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produktu")
    private int id;

    @Column(name = "nazwa_asortymentu")
    private String nazwaAsortymentu;

    @Column(name = "cena_jednostkowa")
    private int cena_jednostkowa;

    //@Column(name ="id_sklepu")
   // private int idSklepu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_sklepu", nullable = true)
    private Sklep Sklep;

    public Asortyment(String nazwaAsortymentu, int cena_jednostkowa, Sklep sklep) {
        this.nazwaAsortymentu = nazwaAsortymentu;
        this.cena_jednostkowa = cena_jednostkowa;
        this.Sklep=sklep;
    }

    public Asortyment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwaAsortymentu() {
        return nazwaAsortymentu;
    }

    public void setNazwaAsortymentu(String nazwaAsortymentu) {
        this.nazwaAsortymentu = nazwaAsortymentu;
    }

    public int getCena_jednostkowa() {
        return cena_jednostkowa;
    }

    public void setCena_jednostkowa(int cena_jednostkowa) {
        this.cena_jednostkowa = cena_jednostkowa;
    }

    public Sklep getSklep() {
        return Sklep;
    }

    public void setSklep(Sklep sklep) {
        this.Sklep = sklep;
    }
}
