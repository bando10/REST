package models;

import java.time.LocalDate;

public class InOff {
    //attributs

    String ville;
    String pays;
    private LocalDate deb;
    private LocalDate fin;
    private int nbPersonnes;
    private int prixM;
    private int etoiles;
    //methodes


    public InOff() {
    }

    public InOff(String ville, String pays, LocalDate deb, LocalDate fin, int nbPersonnes, int prixM, int etoiles) {
        this.ville = ville;
        this.pays = pays;
        this.deb = deb;
        this.fin = fin;
        this.nbPersonnes = nbPersonnes;
        this.prixM = prixM;
        this.etoiles = etoiles;
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

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public double getPrixM() {
        return prixM;
    }

    public void setPrixM(int prixM) {
        this.prixM = prixM;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }
}
