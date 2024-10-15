package services;

import models.Cours;
import java.util.ArrayList;
import java.util.List;

public class CoursService {
    private final List<Cours> coursList = new ArrayList<>();

    public void ajouterCours(Cours cours) {
        coursList.add(cours);
    }

    public List<Cours> afficherTousLesCours() {
        return new ArrayList<>(coursList);
    }

    public boolean supprimerCours(String id) {
        return coursList.removeIf(c -> c.getId().equals(id));
    }
}
