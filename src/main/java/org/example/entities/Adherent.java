package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="adherent")
public class Adherent  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String age;

    @ManyToOne
//    @JoinColumn(name = "centre_sportif_id")
    private CentreSportif centreSportif;

    @ManyToMany
    @JoinTable(name = "adherent_activites", joinColumns = @JoinColumn(name="adherent_id"),
            inverseJoinColumns = @JoinColumn(name = "activites_id"))
    private List<Activites> activites= new ArrayList<>();

    public Adherent ( ) {

    }

    public Adherent (String nom, String prenom, String age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public int getId ( ) {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNom ( ) {
        return nom;
    }

    public void setNom (String nom) {
        this.nom = nom;
    }

    public String getPrenom ( ) {
        return prenom;
    }

    public void setPrenom (String prenom) {
        this.prenom = prenom;
    }

    public String getAge ( ) {
        return age;
    }

    public void setAge (String age) {
        this.age = age;
    }

    public CentreSportif getCentreSportif (){
        return centreSportif;
    }

   public void setCentreSportif(CentreSportif centreSportif){
       this.centreSportif  = centreSportif;
   }

    public List<Activites> getActivites ( ) {
        return activites;
    }

    public void setActivites (List<Activites> activites) {
        this.activites = activites;
    }

    @Override
    public String toString ( ) {
        return "Adherent{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
