package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Offre {
    //attributs

    private long id;
    private long idOffre;
    private LocalDate deb;
    private LocalDate fin;
    private double remise;
    private Hotel hotel;
    private Agence agence;
    private Chambre chambre;

    //methodes
    public Offre() {
    }

    public Offre(long id, long idOffre, LocalDate deb, LocalDate fin, double remise, Hotel hotel, Agence agence, Chambre chambre) {
        this.id = id;
        this.idOffre = idOffre;
        this.deb = deb;
        this.fin = fin;
        this.remise = remise;
        this.hotel = hotel;
        this.agence = agence;
        this.chambre = chambre;
    }

    public long getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(long idOffre) {
        this.idOffre = idOffre;
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
    @Override
    public String toString() {

        double gaps = Math.abs(ChronoUnit.DAYS.between(deb, fin));
        double totalPrice = chambre.getPrix() * gaps * (1 - remise);
        if (this.agence == null) {
            return " -Hotel " + hotel.getNom() + " " + hotel.getEtoiles() + " étoiles, situé au " + hotel.getAdresse()
                    + " " + hotel.getVille() + " " + hotel.getPays() + ". Chambre n° " + chambre.getId()
                    + ". Prix total du sejour : " + totalPrice + "$. Pour visualiser la chambre cliquez sur ce lien: "
                    + chambre.getUrlImg();
        } else {
            return " Offre proposée par l'agence " + agence.getNom() + ". Hotel " + hotel.getNom() + " "
                    + hotel.getEtoiles() + " étoiles, situé au " + hotel.getAdresse() + " " + hotel.getVille() + " "
                    + hotel.getPays() + ". Chambre n° " + chambre.getId() + ". Prix total du sejour : " + totalPrice
                    + "$. Pour visualiser la chambre cliquez sur ce lien: " + chambre.getUrlImg();
        }
    }
}
