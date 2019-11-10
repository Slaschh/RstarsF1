package com.rstarschampionship.RstarsF1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ResultatCourse {

    @Id
    @GeneratedValue
    private String circuit;



    private int place;
    private boolean modifcation;
    private long id_pilote;
    private Long id_resultat;

    public ResultatCourse ()
    {
    super();
    }

    public ResultatCourse(long id_pilote, String circuit, int place, boolean modif, long id_resultat )
    {
        super();
        this.circuit=circuit;
        this.id_resultat=id_resultat;
        this.modifcation= modif;
        this.id_pilote=id_pilote;
        this.place=place;
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

    public boolean isModifcation() {
        return modifcation;
    }

    public void setModifcation(boolean modifcation) {
        this.modifcation = modifcation;
    }

    public Long getId_resultat() {
        return id_resultat;
    }

    public void setId_resultat(Long id_resultat) {
        this.id_resultat = id_resultat;
    }
}
