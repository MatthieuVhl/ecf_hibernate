package org.example;

import org.example.entities.Activites;
import org.example.entities.Adherent;
import org.example.services.ActivitesService;
import org.example.services.AdherentService;

import java.util.List;
import java.util.Scanner;

public class IHM {
    private AdherentService adherentService;
    private ActivitesService activitesService;
    private Scanner scanner;

    public IHM(){
        adherentService = new AdherentService();
        activitesService = new ActivitesService();
        scanner = new Scanner(System.in);
    }

    public void start(){
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    addAdherent();
                    break;
                case "2":
                    affAllAdherentById();
                    break;
                case "3":
                    updateAdherent();
                    break;
                case "4":
                    addActivites();
                    break;
                case "5":
                    updateActivites() ;
                    break;
                case "6":
                    affAllActivitesById();
                    break;
                case "7":
                    deleteAdherent();
                    break;
                case "8":
                    addActivites();
                    break;

            }
        }while(!choice.equals("0"));


    }
    private void menu(){
        System.out.println(" ####### Centre Sportif Villeneuve d'ascq ####### ");
        System.out.println("        -----------------------------------         ");
        System.out.println("1 -- Ajouter un adherent");
        System.out.println("2 -- Afficher la liste d'adherents");
        System.out.println("3 -- Mise a jour d'information sur les adherents ");
        System.out.println("4 -- Ajouter une activité et un cour");
        System.out.println("5 -- Mise a jour d'information sur les cours et activités");
        System.out.println("6 -- Afficher la liste des cours et activités");
        System.out.println("7 -- Supprimer un adherent");
        System.out.println("8 -- ajouter une activite a un adherent");
        System.out.println("0 -- Quitter");
    }

    private void addAdherent(){
        System.out.println("Merci de saisir un nom");
        String nom = scanner.nextLine();
        System.out.println("Merci de saisir un prénom");
        String prenom = scanner.nextLine();
        System.out.println("merci de saisir l'age");
        String age = scanner.nextLine();
        try {
            Adherent adherent = new Adherent(nom,prenom,age);
            adherentService.create(adherent);

        }catch (Exception e){
            System.out.println(e.getMessage());
    }
}
private void updateAdherent(){
    System.out.println("Merci de saisir l'id de l'adhérent : ");
    int id = scanner.nextInt();
    scanner.nextLine();
    Adherent a = adherentService.findById(id);
    System.out.println("Merci de saisir le nom");
    String nom = scanner.nextLine();
    a.setNom(nom);
    System.out.println("Merci de saisir le prénom");
    String prenom = scanner.nextLine();
    a.setPrenom(prenom);

    System.out.println("Merci de saisir l'age");
    String age = scanner.nextLine();
    a.setAge(age);


    try {
        adherentService.update(a);

    }catch (Exception e){
        System.out.println(e.getMessage());
}
}
private void deleteAdherent(){
 System.out.println("Merci de saisir l'id : ");
    int id = scanner.nextInt();
        scanner.nextLine();
        Adherent adh = adherentService.findById(id);
        adherentService.delete(adh);

    }

private void affAllAdherentById(){
    List<Adherent>adherents = adherentService.findAll();
    for (Adherent ad: adherents){
        System.out.println(ad);
    }
}
    private void addActivites(){

        System.out.println("Merci de saisir un cour");
        String cours = scanner.nextLine();
        System.out.println("Merci de saisir une activité");
        String activite = scanner.nextLine();
        System.out.println("a qu'elle id souhaiter vous ajouter c'est activite");
        int id =scanner.nextInt();
        scanner.nextLine();

        try {
            Activites act = new Activites(cours,activite);
            activitesService.create(act);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    private void updateActivites(){
        System.out.println("Merci de saisir l'id de l'activité : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Activites ac = activitesService.findById(id);
        System.out.println("Merci de saisir le cour");
        String cours = scanner.nextLine();
        ac.setCours(cours);
        System.out.println("Merci de saisir l'activité");
        String activites = scanner.nextLine();
        ac.setActivites(activites);


        try {
            activitesService.update(ac);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void affAllActivitesById(){
        List<Activites>activites = activitesService.findAll();
        for (Activites act: activites){
            System.out.println(act);
        }
    }


    }


