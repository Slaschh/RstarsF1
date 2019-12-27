package com.rstarschampionship.RstarsF1.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Long idPilote;
    @Column(name = "nom_pilote")
    private String nomPilote;
    @Column(name = "nom_ecurie")
    private String nomEcurie;
    @Column(name = "integration")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date integration;
    @Column(name = "createdat")
    @CreationTimestamp
    private Date createdAt;
    @Column(name = "updateat")
    @UpdateTimestamp
    private Date uptadeAt;

    public Pilote() {
    }

    public Pilote(String nomPilote, String nomEcurie, Date integration) {
        this.nomPilote = nomPilote;
        this.nomEcurie = nomEcurie;
        this.integration = integration;
    }

    public Long getIdPilote() {
        return idPilote;
    }

    public void setIdPilote(Long idPilote) {
        this.idPilote = idPilote;
    }

    public Date getIntegration() {
        return integration;
    }

    public void setIntegration(Date integration) {
        this.integration = integration;
    }

    public String getNomPilote() {
        return nomPilote;
    }

    public void setNomPilote(String nomPilote) {
        this.nomPilote = nomPilote;
    }

    public String getNomEcurie() {
        return nomEcurie;
    }

    public void setNomEcurie(String nomEcurie) {
        this.nomEcurie = nomEcurie;
    }

    @Override
    public String toString() {
        return "Pilote{" +
                "idPilote=" + idPilote +
                ", nomPilote='" + nomPilote + '\'' +
                ", nomEcurie='" + nomEcurie + '\'' +
                ", integration=" + integration +
                '}';
    }

}