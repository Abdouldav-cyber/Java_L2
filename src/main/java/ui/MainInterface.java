package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Cours;
import models.Etudiant;
import models.Resultat;
import services.CoursService;
import services.EtudiantService;
import services.ResultatService;

import java.time.LocalDate;
import java.util.List;

public class MainInterface extends Application {

    private final EtudiantService etudiantService = new EtudiantService();
    private final CoursService coursService = new CoursService();
    private final ResultatService resultatService = new ResultatService();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Application de Gestion des Étudiants");

        TabPane tabPane = new TabPane();

        // **Onglet Étudiants**
        Tab etudiantTab = new Tab("Étudiants", creerEtudiantPane());
        etudiantTab.setClosable(false);

        // **Onglet Cours**
        Tab coursTab = new Tab("Cours", creerCoursPane());
        coursTab.setClosable(false);

        // **Onglet Résultats**
        Tab resultatTab = new Tab("Résultats", creerResultatPane());
        resultatTab.setClosable(false);

        tabPane.getTabs().addAll(etudiantTab, coursTab, resultatTab);

        Scene scene = new Scene(tabPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane creerEtudiantPane() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        TextField nomField = new TextField();
        nomField.setPromptText("Nom");

        TextField prenomField = new TextField();
        prenomField.setPromptText("Prénom");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        DatePicker dateNaissancePicker = new DatePicker();
        dateNaissancePicker.setPromptText("Date de naissance");

        TextField adresseField = new TextField();
        adresseField.setPromptText("Adresse");

        TextField telephoneField = new TextField();
        telephoneField.setPromptText("Téléphone");

        Button ajouterButton = new Button("Ajouter Étudiant");
        ajouterButton.setOnAction(e -> {
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String email = emailField.getText();
            LocalDate dateNaissance = dateNaissancePicker.getValue();
            String adresse = adresseField.getText();
            String telephone = telephoneField.getText();

            // Génération d'un ID unique
            String id = "ID-" + nom.hashCode();

            // Création de l'étudiant
            Etudiant etudiant = new Etudiant(id, nom, prenom, email, dateNaissance, adresse, telephone);

            etudiantService.ajouterEtudiant(etudiant);
            showAlert("Succès", "Étudiant ajouté !");
            // Réinitialiser les champs
            nomField.clear();
            prenomField.clear();
            emailField.clear();
            dateNaissancePicker.setValue(null);
            adresseField.clear();
            telephoneField.clear();
        });

        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nomField, 1, 0);
        grid.add(new Label("Prénom:"), 0, 1);
        grid.add(prenomField, 1, 1);
        grid.add(new Label("Email:"), 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(new Label("Date de Naissance:"), 0, 3);
        grid.add(dateNaissancePicker, 1, 3);
        grid.add(new Label("Adresse:"), 0, 4);
        grid.add(adresseField, 1, 4);
        grid.add(new Label("Téléphone:"), 0, 5);
        grid.add(telephoneField, 1, 5);
        grid.add(ajouterButton, 1, 6);

        return grid;
    }

    private GridPane creerCoursPane() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        TextField nomCoursField = new TextField();
        nomCoursField.setPromptText("Nom du cours");

        Button ajouterCoursButton = new Button("Ajouter Cours");
        ajouterCoursButton.setOnAction(e -> {
            String nom = nomCoursField.getText();
            Cours cours = new Cours("ID-" + nom.hashCode(), nom);
            coursService.ajouterCours(cours);
            showAlert("Succès", "Cours ajouté !");
            // Réinitialiser le champ
            nomCoursField.clear();
        });

        grid.add(new Label("Nom du Cours:"), 0, 0);
        grid.add(nomCoursField, 1, 0);
        grid.add(ajouterCoursButton, 1, 1);

        return grid;
    }

    private GridPane creerResultatPane() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        TextField etudiantIdField = new TextField();
        etudiantIdField.setPromptText("ID Étudiant");

        TextField coursIdField = new TextField();
        coursIdField.setPromptText("ID Cours");

        TextField noteField = new TextField();
        noteField.setPromptText("Note");

        Button ajouterResultatButton = new Button("Ajouter Résultat");
        ajouterResultatButton.setOnAction(e -> {
            String etudiantId = etudiantIdField.getText();
            String coursId = coursIdField.getText();
            try {
                double note = Double.parseDouble(noteField.getText());
                Resultat resultat = new Resultat(etudiantId, coursId, note);
                resultatService.ajouterResultat(resultat);
                showAlert("Succès", "Résultat ajouté !");
                // Réinitialiser les champs
                etudiantIdField.clear();
                coursIdField.clear();
                noteField.clear();
            } catch (NumberFormatException ex) {
                showAlert("Erreur", "Veuillez entrer une note valide !");
            }
        });

        grid.add(new Label("ID Étudiant:"), 0, 0);
        grid.add(etudiantIdField, 1, 0);
        grid.add(new Label("ID Cours:"), 0, 1);
        grid.add(coursIdField, 1, 1);
        grid.add(new Label("Note:"), 0, 2);
        grid.add(noteField, 1, 2);
        grid.add(ajouterResultatButton, 1, 3);

        return grid;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
