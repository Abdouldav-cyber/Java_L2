package services;

import models.Cours;
import java.util.ArrayList;
import java.util.List;

public class CoursService {
    private List<Cours> coursList = new ArrayList<>();

    public void ajouterCours(Cours cours) {
        coursList.add(cours);
    }

    public List<Cours> listerCours() {
        return coursList;
    }
}
