package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name="Kierownik")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Asortyment.class)
public class Kierownik {
    @Id
    @Column(name="id_kierownika")
    private Integer idKierownika;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_lokalizacji_sklepu", referencedColumnName ="id_lokalizacji")
    private Lokalizacja Lokalizacja;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    public Kierownik(){

    }

    public Kierownik(Integer idKierownika, Lokalizacja lokalizacja, String imie, String nazwisko) {
        this.idKierownika = idKierownika;
        this.Lokalizacja = lokalizacja;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Integer getIdKierownika() {
        return idKierownika;
    }

    public void setIdKierownika(Integer idKierownika) {
        this.idKierownika = idKierownika;
    }

    public com.pracownia.spring.entities.Lokalizacja getLokalizacja() {
        return Lokalizacja;
    }

    public void setLokalizacja(com.pracownia.spring.entities.Lokalizacja lokalizacja) {
        Lokalizacja = lokalizacja;
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
