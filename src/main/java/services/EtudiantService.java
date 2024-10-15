package services;

import models.Etudiant;
import java.util.ArrayList;
import java.util.List;

public class EtudiantService {
    private List<Etudiant> etudiants = new ArrayList<>();

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public List<Etudiant> listerEtudiants() {
        return etudiants;
    }
}
