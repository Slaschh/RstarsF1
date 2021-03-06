package com.rstarschampionship.RstarsF1.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resultat_course" )
@EntityListeners(AuditingEntityListener.class)
public class ResultatCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id_resultat;
    @Column(name="circuit")
    private String circuit;
    @Column(name = "place")
    private int place;
    @Column(name = "id_pilote")
    private long id_pilote;
    @Column(name = "createdat")
    @CreationTimestamp
    private Date createdAt;
    @Column(name = "updateat")
    @UpdateTimestamp
    private Date uptadeAt;


    public ResultatCourse ()
    {
    super();
    }

    public ResultatCourse(long id_pilote, String circuit, int place, long id_resultat) {
        super();
        this.circuit = circuit;
        this.id_resultat = id_resultat;
        this.id_pilote = id_pilote;
        this.place = place;
    }

    public long getId_pilote() {
        return id_pilote;
    }

    public void setId_pilote(long id_pilote) {
        this.id_pilote = id_pilote;
    }
    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }



    public Long getId_resultat() {
        return id_resultat;
    }

    public void setId_resultat(Long id_resultat) {
        this.id_resultat = id_resultat;
    }

    @Override
    public String toString() {
        return "ResultatCourse{" +
                "id_resultat=" + id_resultat +
                ", circuit='" + circuit + '\'' +
                ", place=" + place +
                ", id_pilote=" + id_pilote +
                '}';
    }
}
