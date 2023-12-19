package com.example.agence;

public class OutRes {
    /* attributs */
    private String login;
    private String password;
    private long idOffre;
    private String prenom;
    private String nom;
    private String carte;
    private String cvv;
    private String exp;

    // methodes


    public OutRes() {
    }

    public OutRes(String login, String password, long idOffre, String prenom, String nom, String carte, String cvv, String exp) {
        this.login = login;
        this.password = password;
        this.idOffre = idOffre;
        this.prenom = prenom;
        this.nom = nom;
        this.carte = carte;
        this.cvv = cvv;
        this.exp = exp;
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

    public long getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(long idOffre) {
        this.idOffre = idOffre;
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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
