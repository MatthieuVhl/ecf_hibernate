package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "activites")
@PrimaryKeyJoinColumn(name = "centreSportif_id")
public class Activites extends CentreSportif{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cours;
    private String activites;

@ManyToOne
@JoinColumn(name = "centre_sportif_id")
private  CentreSportif centreSportif;

@ManyToMany(mappedBy = "CentreSportif")
private List<Adherent> adherents = new ArrayList<>();


    public Activites ( ) {
        super();

    }

    public Activites (String cours, String activites) {
        this.cours = cours;
        this.activites = activites;
    }

    public int getId ( ) {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getCours ( ) {
        return cours;
    }

    public void setCours (String cours) {
        this.cours = cours;
    }



    public void setActivites (String activites) {
        this.activites = activites;
    }

    public CentreSportif getCentreSportif (){
        return centreSportif;
    }

    public void setCentreSportif(CentreSportif centreSportif){
        this.centreSportif  = centreSportif;
    }

    public List<Adherent> getAdherents ( ) {
        return adherents;
    }

    public void setAdherents (List<Adherent> adherents) {
        this.adherents = adherents;
    }


    @Override
    public String toString ( ) {
        return "Activites{" +
                "id=" + id +
                ", cours='" + cours + '\'' +
                ", activites='" + activites + '\'' +
                '}';
    }


}
