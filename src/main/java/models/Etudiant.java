package models;

import java.time.LocalDate;

public class Etudiant {
    private String id;
    private String nom;
    private String email;
    private String motDePasse;
    private LocalDate dateNaissance;
    private String adresse;
    private String telephone;

    // Constructeur avec tous les paramètres
    public Etudiant(String id, String nom, String email, String motDePasse,
                    LocalDate dateNaissance, String adresse, String telephone) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }
}
