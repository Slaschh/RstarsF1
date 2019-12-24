package com.rstarschampionship.RstarsF1.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "point")
@EntityListeners(AuditingEntityListener.class)

public class Point implements Serializable {

    @Id
    @Column(name = "id_point", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPoint;
    @Column(name = "point")
    private int point;
    @Column(name = "id_resultat")
    private int idResultat;
    @Column(name = "id_pilote")
    private int idPilote;
    @Column(name = "createdat")
    @CreationTimestamp
    private Date createdAt;
    @Column(name = "updateat")
    @UpdateTimestamp
    private Date uptadeAt;

    public Point() {
    }

    public int getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(int idPoint) {
        this.idPoint = idPoint;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getIdResultat() {
        return idResultat;
    }

    public void setIdResultat(int idResultat) {
        this.idResultat = idResultat;
    }

    public int getIdPilote() {
        return idPilote;
    }

    public void setIdPilote(int idPilote) {
        this.idPilote = idPilote;
    }

    @Override
    public String toString() {
        return "Point{" +
                "idPoint=" + idPoint +
                ", point=" + point +
                ", idResultat=" + idResultat +
                ", idPilote=" + idPilote +
                '}';
    }
}
