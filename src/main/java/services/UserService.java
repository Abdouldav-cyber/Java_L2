package services;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        // Ajout d'un utilisateur par défaut pour la démonstration
        users.add(new User("davoudramane89@gmail.com", "davou64598258"));
    }

    // Méthode d'authentification améliorée avec log
    public boolean authenticate(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    System.out.println("Connexion réussie !");
                    return true;
                } else {
                    System.out.println("Mot de passe incorrect.");
                    return false;
                }
            }
        }
        System.out.println("Utilisateur non trouvé.");
        return false;
    }
}
