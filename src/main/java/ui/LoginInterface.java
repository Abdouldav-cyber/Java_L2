package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.UserService;

public class LoginInterface extends Application {
    private UserService userService = new UserService();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connexion - Gestion des Étudiants");

        VBox layout = new VBox(10);
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Mot de passe");

        Label messageLabel = new Label();  // Label pour afficher les erreurs

        Button loginButton = new Button("Se connecter");
        loginButton.setOnAction(e -> {
            String email = emailField.getText().trim();  // Suppression des espaces inutiles
            String password = passwordField.getText().trim();

            if (email.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Veuillez remplir tous les champs.");
                return;
            }

            boolean success = userService.authenticate(email, password);
            if (success) {
                // Ouvrir la page principale de l'application
                MainInterface mainInterface = new MainInterface();
                try {
                    mainInterface.start(new Stage());
                    primaryStage.close();  // Fermer la fenêtre de connexion
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                messageLabel.setText("Identifiants incorrects.");
            }
        });

        layout.getChildren().addAll(emailField, passwordField, loginButton, messageLabel);
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
