package services;

import models.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class EtudiantService {
    private List<Etudiant> etudiants; // Déclaration de la liste d'étudiants

    // Constructeur
    public EtudiantService() {
        this.etudiants = new ArrayList<>(); // Initialisation de la liste
    }

    // Méthode pour ajouter un étudiant
    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant); // Ajout de l'étudiant à la liste
    }

    // Méthode pour rechercher un étudiant par nom ou ID
    public List<Etudiant> rechercherEtudiant(String keyword) {
        List<Etudiant> resultats = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNom().contains(keyword) || etudiant.getId().equals(keyword)) {
                resultats.add(etudiant);
            }
        }
        return resultats; // Retourne la liste des résultats
    }

    // Méthode pour vérifier la connexion
    public boolean verifierConnexion(String email, String motDePasse) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getEmail().equals(email) && etudiant.getMotDePasse().equals(motDePasse)) {
                return true; // Connexion réussie
            }
        }
        return false; // Connexion échouée
    }
}
