package services;

import models.Resultat;
import java.util.ArrayList;
import java.util.List;

public class ResultatService {
    private List<Resultat> resultats = new ArrayList<>();

    public void ajouterResultat(Resultat resultat) {
        resultats.add(resultat);
    }

    public List<Resultat> listerResultats() {
        return resultats;
    }
}
