package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private List<Cours> coursSuivis;

    public Etudiant(String id, String nom, String prenom, LocalDate dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.coursSuivis = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public List<Cours> getCoursSuivis() { return coursSuivis; }

    public void ajouterCours(Cours cours) {
        coursSuivis.add(cours);
    }
}
