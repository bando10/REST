package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    //attributs
    private long id;

    private long idRservation;

    private Chambre chambre;

    private Hotel hotel;

    private LocalDate deb;

    private LocalDate fin;

    private String prenom;

    private String nom;

    //methodes
    public Reservation() {
    }

    public Reservation(long id, long idRservation, Chambre chambre, Hotel hotel, LocalDate deb, LocalDate fin, String prenom, String nom) {
        this.id = id;
        this.idRservation = idRservation;
        this.chambre = chambre;
        this.hotel = hotel;
        this.deb = deb;
        this.fin = fin;
        this.prenom = prenom;
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdRservation() {
        return idRservation;
    }

    public void setIdRservation(long idRservation) {
        this.idRservation = idRservation;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", idRservation=" + idRservation +
                ", chambre=" + chambre +
                ", hotel=" + hotel +
                ", deb=" + deb +
                ", fin=" + fin +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
