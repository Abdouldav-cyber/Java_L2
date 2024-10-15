package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Etudiant;
import models.Resultat;
import services.EtudiantService;

import java.util.List;


public class MainInterface extends Application {

    private final EtudiantService etudiantService = new EtudiantService();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Application de Gestion des Étudiants");

        // Champs de recherche
        TextField searchField = new TextField();
        searchField.setPromptText("Rechercher un étudiant par nom ou ID");

        Button searchButton = new Button("Rechercher");
        ListView<String> resultList = new ListView<>();

        // Action du bouton de recherche
        searchButton.setOnAction(e -> {
            String keyword = searchField.getText();
            resultList.getItems().clear();
            List<Etudiant> results = etudiantService.rechercherEtudiant(keyword);

            if (results.isEmpty()) {
                resultList.getItems().add("Aucun étudiant trouvé.");
            } else {
                results.forEach(etudiant ->
                        resultList.getItems().add(etudiant.getNom() + " - " + etudiant.getId())
                );
            }
        });

        // Champs pour ajouter un résultat académique
        TextField coursField = new TextField();
        coursField.setPromptText("Nom du cours");

        TextField noteField = new TextField();
        noteField.setPromptText("Note");

        Button ajouterResultatBtn = new Button("Ajouter Résultat");
        ajouterResultatBtn.setOnAction(e -> {
            try {
                String cours = coursField.getText();
                int note = Integer.parseInt(noteField.getText());

                Resultat resultat = new Resultat(note, cours);
                System.out.println("Résultat ajouté : " + resultat.getCours() + " - Note : " + resultat.getNote());

                // Efface les champs après l'ajout
                coursField.clear();
                noteField.clear();
            } catch (NumberFormatException ex) {
                showAlert("Erreur", "Veuillez entrer une note valide.");
            }
        });

        // Disposition principale
        VBox layout = new VBox(10, searchField, searchButton, resultList, coursField, noteField, ajouterResultatBtn);
        layout.setPadding(new Insets(20));

        // Chargement du fichier CSS
        Scene scene = new Scene(layout, 400, 500);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Méthode pour afficher une alerte
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
