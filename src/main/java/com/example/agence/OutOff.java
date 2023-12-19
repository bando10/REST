package com.example.agence;

import java.time.LocalDate;

public class OutOff {
    //attributs
    private String login;
    private String password;
    LocalDate deb;
    LocalDate fin;
    private int nbPersonnes;

    // methodes


    public OutOff() {
    }

    public OutOff(String login, String password, LocalDate deb, LocalDate fin, int nbPersonnes) {
        this.login = login;
        this.password = password;
        this.deb = deb;
        this.fin = fin;
        this.nbPersonnes = nbPersonnes;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
