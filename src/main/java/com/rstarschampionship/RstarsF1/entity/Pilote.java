package com.rstarschampionship.RstarsF1.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="pilote")
@EntityListeners(AuditingEntityListener.class)

public class Pilote implements Serializable {

    @Id
    @Column(name = "id_pilote", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_pilote;
    @Column(name = "nom_pilote")
    private String nom_pilote;
    @Column(name = "nom_ecurie")
    private String nom_ecurie;



    public Pilote() {
        super();
    }

    public Pilote(String nom_pilote, String nom_ecurie, Date integration) {
        super();
        this.nom_ecurie = nom_ecurie;
        this.nom_pilote = nom_pilote;
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

    @Override
    public String toString() {
        return "Pilote{" +
                "id_pilote=" + id_pilote +
                ", nom_pilote='" + nom_pilote + '\'' +
                ", nom_ecurie='" + nom_ecurie + '\'' +
                '}';
    }
}

