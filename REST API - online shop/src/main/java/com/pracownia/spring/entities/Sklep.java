package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pracownia.spring.entities.Asortyment;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Sklep")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Asortyment.class)
public class Sklep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nazwa")
    private String nazwaSklepu;

    @Column(name = "id_wlasciciela")
    private int idWlasciciela;

    @OneToMany(mappedBy = "Sklep", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Asortyment> asortyment;

    @OneToMany(mappedBy = "Sklep", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Lokalizacja> lokalizacja;

    public Sklep(int id, String nazwaSklepu, List lokalizacja, int idWlasciciela, List asortyment) {
        this.id = id;
        this.nazwaSklepu = nazwaSklepu;
        this.lokalizacja=lokalizacja;
        this.idWlasciciela = idWlasciciela;
        this.asortyment=asortyment;
    }

    public Sklep(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwaSklepu() {
        return nazwaSklepu;
    }

    public void setNazwaSklepu(String nazwaSklepu) {
        this.nazwaSklepu = nazwaSklepu;
    }

    public int getIdWlasciciela() {
        return idWlasciciela;
    }

    public void setIdWlasciciela(int idWlasciciela) {
        this.idWlasciciela = idWlasciciela;
    }

    public List<Asortyment> getAsortyment() {
        return asortyment;
    }

    public void setAsortyment(List<Asortyment> asortyment) {
        this.asortyment = asortyment;
    }

    public List<Lokalizacja> getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(List<Lokalizacja> lokalizacja) {
        this.lokalizacja = lokalizacja;
    }
}
