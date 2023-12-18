package com.example.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation {

    //attributs
    @Id
    @GeneratedValue
    private long id;

    /*Lorsque vous utilisez @OneToOne pour définir une relation entre deux entités, cela signifie qu'une instance d'une entité est associée à une seule instance d'une autre entité, et vice versa.

Par exemple, si vous avez deux entités telles que EntitéA et EntitéB, vous pouvez utiliser @OneToOne pour spécifier qu'une instance de EntitéA est associée à une seule instance de EntitéB, ou inversement.*/
    @OneToOne
    private Client client;
    @OneToOne
    private Agence agence;
    @OneToOne
    private Chambre chambre;

    @Column(name="deb")
    private LocalDate deb;

    @Column(name="fin")
    private LocalDate fin;

    //methodes
    public Reservation() {
    }

    public Reservation(Client client, Agence agence, Chambre chambre, LocalDate deb, LocalDate fin) {
        this.client = client;
        this.agence = agence;
        this.chambre = chambre;
        this.deb = deb;
        this.fin = fin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", client=" + client +
                ", agence=" + agence +
                ", chambre=" + chambre +
                ", deb=" + deb +
                ", fin=" + fin +
                '}';
    }
}
