package models;

public class Resultat {
    private String etudiantId;
    private String coursId;
    private double note;

    public Resultat(String etudiantId, String coursId, double note) {
        this.etudiantId = etudiantId;
        this.coursId = coursId;
        this.note = note;
    }

    public String getEtudiantId() {
        return etudiantId;
    }

    public String getCoursId() {
        return coursId;
    }

    public double getNote() {
        return note;
    }
}
