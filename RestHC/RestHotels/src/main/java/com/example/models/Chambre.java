package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Chambre {

    //attributs
    @Id
    @GeneratedValue
    private long id;
    private int nbPersonnes;
    private double prix;
    private String urlImg;

    //methodes

    public Chambre() {
    }

    public Chambre(int nbPersonness, double prix, String urlImg) {
        this.nbPersonnes = nbPersonness;
        this.prix = prix;
        this.urlImg = urlImg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNbPersonness() {
        return nbPersonnes;
    }

    public void setNbPersonness(int nbPersonness) {
        this.nbPersonnes = nbPersonness;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "Chambre{" +
                "id=" + id +
                ", nbPersonness=" + nbPersonnes +
                ", prix=" + prix +
                ", urlImg='" + urlImg + '\'' +
                '}';
    }
}
