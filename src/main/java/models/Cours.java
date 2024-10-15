package models;

public class Cours {
    private String id;
    private String nom;

    public Cours(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
