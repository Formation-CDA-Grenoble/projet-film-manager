//mouctar 

package com.tpmil.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.tpmil.demo.entity.Genre;
import com.tpmil.demo.repository.GenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


// Ce contrôleur fonctionne sur le modèle d'une API REST
@RestController
// Ce contrôleur répond à toutes les requêtes sur les endpoints /api/Genre
@RequestMapping("/api/genres")
// Ce contrôleur accepte les requêtes venant d'un serveur différent
@CrossOrigin
public class GenreController {

    // Injection de dépendance
    // Une instance de ProductRepository est automatiquement créée
    // et rangée dans cette propriété à la construction du contrôleur
    @Autowired
    private GenreRepository GenreRepository;
    
    
    // Renvoie tous les produits de la base de données

    @GetMapping("")
    public List<Genre> getAllGenre() {
        return GenreRepository.findAll();
    }

    // Crée un nouveau produit

    @PostMapping("")
    // En cas de succès, renvoie un code HTTP 201 au lieu du code 200 par défaut
    
    @ResponseStatus(value = HttpStatus.CREATED)
    public Genre createGenre(@Valid @RequestBody Genre Genre) {
        // Sauvegarde le produit en BDD et renvoie une copie 
        return GenreRepository.save(Genre);
    }

    // Met à jour les propriétés d'un produit déjà existant
    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable(value = "id") Long GenreId, @Valid @RequestBody Genre newGenre) {
        // Récupère le produit tel qu'il existe actuellement dans la BDD
        Genre Genre = this.fetchGenre(GenreId);
        // Remplace toutes ses propriétés par celles de l'objet entrant
        
        
       
        
        // Sauvegarde le produit en BDD et renvoie une copie
        return GenreRepository.save(Genre);
    }

    private Genre fetchGenre(Long GenreId) {
        return null;
    }

    // Renvoie un produit particulier de la base de données (en fonction de son id)
    @GetMapping("/{id}")
    public Genre getProductById(@PathVariable(value = "id") Long GenreId) {
        return this.fetchProduct(GenreId);
    }

  
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGenreById(@PathVariable(value = "id") Long id) {
        GenreRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found")
        );
        GenreRepository.deleteById(id);
    }
//
//
    // Méthode réutilisable permettant d'aller chercher un produit dans la BDD en fonction de son id
    // Renvoie automatiquement une erreur 404 si le produit n'existe pas
    public Genre fetchProduct(Long GenreId) {
        Genre Genre = GenreRepository.findById(GenreId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found")
        );
        return Genre;
    }
}
