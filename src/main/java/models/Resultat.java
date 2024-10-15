package models;

public class Resultat {
    private String note;
    private String semestre;
    private boolean valide;

    public Resultat(String note, String semestre, boolean valide) {
        this.note = note;
        this.semestre = semestre;
        this.valide = valide;
    }

    public String getNote() { return note; }
    public String getSemestre() { return semestre; }
    public boolean isValide() { return valide; }
}
