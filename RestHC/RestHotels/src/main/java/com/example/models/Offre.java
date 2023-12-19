package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Offre {
    //attributs
    @Id
    @GeneratedValue
    private long id;

    @Column(name="deb")
    private LocalDate deb;

    @Column(name="fin")
    private LocalDate fin;
    private double remise;

    @OneToOne
    private Hotel hotel;

    @OneToOne
    @JsonIgnore
    private Agence agence;

    @OneToOne
    private Chambre chambre;

    //methodes
    public Offre() {
    }

    public Offre(LocalDate deb, LocalDate fin, double remise, Hotel hotel, Agence agence, Chambre chambre) {
        this.deb = deb;
        this.fin = fin;
        this.remise = remise;
        this.hotel = hotel;
        this.agence = agence;
        this.chambre = chambre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDeb() {
        return deb;
    }

    public void setDeb(LocalDate deb) {
        this.deb = deb;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }
}
