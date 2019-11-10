package com.rstarschampionship.RstarsF1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Pilote {

    @Id
    @GeneratedValue
    private String nom_pilote;
    private String nom_ecurie;
    private Date date_integration;
    private Long id_pilote;

    public Pilote () {super();}

    public Pilote (String nom_pilote, String nom_ecurie, Date date_integration)
    {
        super();
        this.nom_ecurie=nom_ecurie;
        this.nom_pilote=nom_pilote;
        this.date_integration=date_integration;
    }

    public String getNom_pilote() {
        return nom_pilote;
    }

    public void setNom_pilote(String nom_pilote) {
        this.nom_pilote = nom_pilote;
    }

    public String getNom_ecurie() {
        return nom_ecurie;
    }

    public void setNom_ecurie(String nom_ecurie) {
        this.nom_ecurie = nom_ecurie;
    }

    public Long getId_pilote() {
        return id_pilote;
    }

    public void setId_pilote(Long id_pilote) {
        this.id_pilote = id_pilote;
    }

    public Date getDate_integration() {
        return date_integration;
    }

    public void setDate_integration(Date date_integration) {
        this.date_integration = date_integration;
    }
}
