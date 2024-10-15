package services;

import models.Resultat;
import java.util.ArrayList;
import java.util.List;

public class ResultatService {
    private final List<Resultat> resultats = new ArrayList<>();

    public void ajouterResultat(Resultat resultat) {
        resultats.add(resultat);
    }

    public List<Resultat> afficherResultatsParEtudiant(String etudiantId) {
        List<Resultat> resultatsEtudiant = new ArrayList<>();
        for (Resultat resultat : resultats) {
            if (resultat.getEtudiantId().equals(etudiantId)) {
                resultatsEtudiant.add(resultat);
            }
        }
        return resultatsEtudiant;
    }
}
