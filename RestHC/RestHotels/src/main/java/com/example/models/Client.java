package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {
    //attributs
    @Id
    @GeneratedValue
    private long id;
    private String prenom;
    private String nom;
    private String carte;
    private String exp;
    private String cvv;

    //methodes
    public Client() {
    }

    public Client(String prenom, String nom, String carte, String exp, String cvv) {
        this.prenom = prenom;
        this.nom = nom;
        this.carte = carte;
        this.exp = exp;
        this.cvv = cvv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCarte() {
        return carte;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", carte='" + carte + '\'' +
                ", exp='" + exp + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
