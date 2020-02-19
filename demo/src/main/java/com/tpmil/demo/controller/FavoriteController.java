//mouctar 

package com.tpmil.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.tpmil.demo.entity.Favorite;
import com.tpmil.demo.repository.FavoriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


// Ce contrôleur fonctionne sur le modèle d'une API REST
@RestController
// Ce contrôleur répond à toutes les requêtes sur les endpoints /api/Favorite
@RequestMapping("/api/favorites")
// Ce contrôleur accepte les requêtes venant d'un serveur différent
@CrossOrigin
public class FavoriteController {

    // Injection de dépendance
    // Une instance de ProductRepository est automatiquement créée
    // et rangée dans cette propriété à la construction du contrôleur
    @Autowired
    private FavoriteRepository FavoriteRepository;
    
    
    // Renvoie tous les produits de la base de données
    @GetMapping("")
    public List<Favorite> getAllFavorite() {
        return FavoriteRepository.findAll();
    }

    // Crée un nouveau produit
    @PostMapping("")
    // En cas de succès, renvoie un code HTTP 201 au lieu du code 200 par défaut
    @ResponseStatus(value = HttpStatus.CREATED)
    public Favorite createFavorite(@Valid @RequestBody Favorite Favorite) {
        // Sauvegarde le produit en BDD et renvoie une copie 
        return FavoriteRepository.save(Favorite);
    }

    // Met à jour les propriétés d'un produit déjà existant
    @PutMapping("/{id}")
    public Favorite updateFavorite(@PathVariable(value = "id") Long FavoriteId, @Valid @RequestBody Favorite newFavorite) {
        // Récupère le produit tel qu'il existe actuellement dans la BDD
        Favorite Favorite = this.fetchFavorite(FavoriteId);
        // Remplace toutes ses propriétés par celles de l'objet entrant
        Favorite.setUser(newFavorite.getUser());
        Favorite.setMovie(newFavorite.getMovie());
        
       
        
        // Sauvegarde le produit en BDD et renvoie une copie
        return FavoriteRepository.save(Favorite);
    }

    private Favorite fetchFavorite(Long FavoriteId) {
        return null;
    }

    // Renvoie un produit particulier de la base de données (en fonction de son id)
    @GetMapping("/{id}")
    public Favorite getProductById(@PathVariable(value = "id") Long FavoriteId) {
        return this.fetchProduct(FavoriteId);
    }

  
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable(value = "id") Long id) {
        FavoriteRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorite not found")
        );
        FavoriteRepository.deleteById(id);
    }
//
//
    // Méthode réutilisable permettant d'aller chercher un produit dans la BDD en fonction de son id
    // Renvoie automatiquement une erreur 404 si le produit n'existe pas
    public Favorite fetchProduct(Long FavoriteId) {
        Favorite Favorite = FavoriteRepository.findById(FavoriteId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorite not found")
        );
        return Favorite;
    }
}
