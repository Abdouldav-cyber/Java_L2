package models;

public class Resultat {
    private int note;
    private String cours;
    private boolean valide;

    public Resultat(int note, String cours) {
        this.note = note;
        this.cours = cours;
        this.valide = note >= 10;
    }

    public int getNote() { return note; }
    public String getCours() { return cours; }
    public boolean isValide() { return valide; }
}
