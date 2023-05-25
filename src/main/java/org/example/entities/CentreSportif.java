package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Centre_Sportif")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CentreSportif {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String utilisateur;

    public String getUtilisateur ( ) {
        return utilisateur;
    }

    public void setUtilisateur (String utilisateur) {
        this.utilisateur = utilisateur;
    }



    @OneToMany(mappedBy = "centreSportif")
    private List<Adherent> adherents = new ArrayList<>();

    @OneToMany(mappedBy = "centreSportif")
    private List<Activites> activites  = new ArrayList<>();
    public  CentreSportif ( ) {
        super();
    }

    public int getId ( ) {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }


    public List<Adherent> getAdherents ( ) {
        return adherents;
    }

    public void setAdherents (List<Adherent> adherents) {
        this.adherents = adherents;
    }

    public List<Activites> getActivites ( ) {
        return activites;
    }

    public void setActivites (List<Activites> activites) {
        this.activites = activites;
    }

    @Override
    public String toString ( ) {
        return "CentreSportif{" +
                "id=" + id +
                '}';
    }
}
