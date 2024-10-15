package models;

import java.util.ArrayList;
import java.util.List;

public class Cours {
    private String code;
    private String nom;
    private String professeur;
    private List<Etudiant> etudiantsInscrits;

    public Cours(String code, String nom, String professeur) {
        this.code = code;
        this.nom = nom;
        this.professeur = professeur;
        this.etudiantsInscrits = new ArrayList<>();
    }

    public void inscrireEtudiant(Etudiant etudiant) {
        etudiantsInscrits.add(etudiant);
    }
}
