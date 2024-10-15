package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.EtudiantService;
import models.Etudiant;

import java.time.LocalDate;

public class MainInterface extends Application {
    private EtudiantService etudiantService = new EtudiantService();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion des Étudiants - Java_L2");

        VBox layout = new VBox(10);
        ListView<String> etudiantListView = new ListView<>();
        TextField nomField = new TextField();
        nomField.setPromptText("Nom");
        TextField prenomField = new TextField();
        prenomField.setPromptText("Prénom");

        Button ajouterButton = new Button("Ajouter Étudiant");
        ajouterButton.setOnAction(e -> {
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            Etudiant etudiant = new Etudiant(
                    String.valueOf(etudiantService.listerEtudiants().size() + 1),
                    nom, prenom, LocalDate.now()
            );
            etudiantService.ajouterEtudiant(etudiant);
            etudiantListView.getItems().add(nom + " " + prenom);
            nomField.clear();
            prenomField.clear();
        });

        layout.getChildren().addAll(nomField, prenomField, ajouterButton, etudiantListView);
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
