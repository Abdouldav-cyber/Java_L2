package services;

import models.Etudiant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EtudiantService {
    private List<Etudiant> etudiants = new ArrayList<>();

    // Ajout de la fonctionnalité de recherche
    public List<Etudiant> rechercherEtudiant(String keyword) {
        return etudiants.stream()
                .filter(e -> e.getNom().toLowerCase().contains(keyword.toLowerCase())
                        || String.valueOf(e.getId()).equals(keyword))
                .collect(Collectors.toList());
    }

    // Autres méthodes : ajouter, modifier, supprimer des étudiants
    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }
}
