//léo

package com.tpmil.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.tpmil.demo.entity.Movie;
import com.tpmil.demo.entity.User;
import com.tpmil.demo.repository.UserRepository;
import com.tpmil.demo.repository.MovieRepository;
import com.tpmil.demo.repository.FavoriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


// Ce contrôleur fonctionne sur le modèle d'une API REST
@RestController
// Ce contrôleur répond à toutes les requêtes sur les endpoints /api/User
@RequestMapping("/api/users")
// Ce contrôleur accepte les requêtes venant d'un serveur différent
@CrossOrigin
public class UserController{
    // Injection de dépendance
    // Une instance de ProductRepository est automatiquement créée
    // et rangée dans cette propriété à la construction du contrôleur
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private MovieRepository MovieRepository;
    @Autowired
    private FavoriteRepository FavoriteRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    // Renvoie tous les produits de la base de données
    @GetMapping("")
    public List<User> getAllUser() {
        return UserRepository.findAll();
    }

    // Crée un nouveau produit
    @PostMapping("")
    // En cas de succès, renvoie un code HTTP 201 au lieu du code 200 par défaut
    @ResponseStatus(value = HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User User) {
        // Sauvegarde le produit en BDD et renvoie une copie 

        User.setPassword(passwordEncoder.encode(User.getPassword()));
        return UserRepository.save(User);
    }

    // Met à jour les propriétés d'un produit déjà existant
    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") Long UserId, @Valid @RequestBody User newUser) {
        // Récupère le produit tel qu'il existe actuellement dans la BDD
        User User = this.fetchUser(UserId);
        // Remplace toutes ses propriétés par celles de l'objet entrant
        User.setUsername(newUser.getUsername());
       User.setMail(newUser.getMail());
        User.setPassword(passwordEncoder.encode(newUser.getPassword()));
       
        
        // Sauvegarde le produit en BDD et renvoie une copie
        return UserRepository.save(User);
    }

    private User fetchUser(Long UserId) {
        return null;
    }

    // Renvoie un produit particulier de la base de données (en fonction de son id)
    @GetMapping("/{id}")
    public User getProductById(@PathVariable(value = "id") Long UserId) {
        return this.fetchProduct(UserId);
    }

  
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable(value = "id") Long id) {
        UserRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
        UserRepository.deleteById(id);

    }
    @GetMapping("/{userId}/addFavorite/{movieId}")
    public User addFavorite(
        @PathVariable(value = "movieId") Long movieId,
        @PathVariable(value = "userId") Long userId
    ) {
        User user = this.fetchUser(movieId);
      
        Movie movie =MovieRepository.findById(
                userId)
                .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found")
        );

        if (User.getFavorites().contains(movie)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie already present in favorite");
        }

        User.getUser().add(movie);
        return UserRepository.save(user);
    }
//
//
    // Méthode réutilisable permettant d'aller chercher un produit dans la BDD en fonction de son id
    // Renvoie automatiquement une erreur 404 si le produit n'existe pas
    public User fetchProduct(Long UserId) {
        User User = UserRepository.findById(UserId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
        return User;
    }
}
