package com.rstarschampionship.RstarsF1.entity;

public class addClassement {



    private  String nom_pilote;
    private String nom_ecurie;
    private Integer place;
    private String circuit;
    private  String modificateur;

    public String getCircuit()
    {
        return circuit;
    }

    public void setCircuit(String circuit)
    {
        this.circuit = circuit;
    }

    public String getNom_ecurie() {
        return nom_ecurie;
    }

    public void setNom_ecurie(String nom_ecurie) {
        this.nom_ecurie = nom_ecurie;
    }

    public String getNom_pilote() {
        return nom_pilote;
    }

    public void setNom_pilote(String nom_pilote) {
        this.nom_pilote = nom_pilote;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getModificateur() {
        return modificateur;
    }

    public void setModificateur(String modificateur) {
        this.modificateur = modificateur;
    }
}
