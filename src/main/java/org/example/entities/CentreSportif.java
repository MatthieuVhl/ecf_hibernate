package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public  class CentreSportif {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "centreSportif")
    private List<Adherent> adherents = new ArrayList<>();

    public  CentreSportif ( ) {

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




    @Override
    public String toString ( ) {
        return "CentreSportif{" +
                "id=" + id +
                '}';
    }
}
