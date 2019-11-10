package com.rstarschampionship.RstarsF1.entity;

import java.util.ArrayList;
import java.util.List;

public class Classement {

    private  String nom_pilote;
    private String nom_ecurie;
    private Integer place;
    private String modificateur;


    private String circuit;

    public static List<Classement> classement = new ArrayList<Classement>();

    static {
        classement.add(new Classement("Bill", "Ferrari", 2, "Australie", "nouveau"));
        classement.add(new Classement("Steve", "Mercedes" ,23,"Espagne", "nouveau"));
    }


    public Classement ( String nom_pilote ,String nom_ecurie, Integer place, String circuit, String modificateur)
    {

        this.nom_pilote=nom_pilote;
        this.nom_ecurie=nom_ecurie;
        this.place=place;
        this.circuit=circuit;
        this.modificateur=modificateur;


    }

    public String getModificateur() {
        return modificateur;
    }

    public void setModificateur(String modificateur) {
        this.modificateur = modificateur;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
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

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }
}
