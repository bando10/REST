package models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel {
    //attributs
    private long id;
    private String nom;
    private String adresse;
    private String ville;
    private String pays;
    private int etoiles;

    //methodes
    public Hotel() {
    }

    public Hotel(String nom, String adresse, String ville, String pays, int etoiles) {
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.etoiles = etoiles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel hotel)) return false;
        return id == hotel.id && getEtoiles() == hotel.getEtoiles() && Objects.equals(getNom(), hotel.getNom()) && Objects.equals(getAdresse(), hotel.getAdresse()) && Objects.equals(getVille(), hotel.getVille()) && Objects.equals(getPays(), hotel.getPays());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getNom(), getAdresse(), getVille(), getPays(), getEtoiles());
    }
}
