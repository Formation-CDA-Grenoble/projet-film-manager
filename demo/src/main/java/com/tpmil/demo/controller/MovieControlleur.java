package com.tpmil.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.tpmil.demo.entity.Movie;
import com.tpmil.demo.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


// Ce contrôleur fonctionne sur le modèle d'une API REST
@RestController
// Ce contrôleur répond à toutes les requêtes sur les endpoints /api/movie
@RequestMapping("/api/movies")
// Ce contrôleur accepte les requêtes venant d'un serveur différent
@CrossOrigin
public class MovieController {

    // Injection de dépendance
    // Une instance de ProductRepository est automatiquement créée
    // et rangée dans cette propriété à la construction du contrôleur
    @Autowired
    private MovieRepository productRepository;
    
    // Renvoie tous les produits de la base de données
    @GetMapping("")
    public List<Movie> getAllmovie() {
        return movieRepository.findAll();
    }

    // Crée un nouveau produit
    @PostMapping("")
    // En cas de succès, renvoie un code HTTP 201 au lieu du code 200 par défaut
    @ResponseStatus(value = HttpStatus.CREATED)
    public Movie createMovie(@Valid @RequestBody Movie movie) {
        // Sauvegarde le produit en BDD et renvoie une copie 
        return movieRepository.save(movie);
    }

    // Met à jour les propriétés d'un produit déjà existant
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable(value = "id") Long movieId, @Valid @RequestBody Movie newMovie) {
        // Récupère le produit tel qu'il existe actuellement dans la BDD
        Movie movie = this.fetchMovie(movieId);
        // Remplace toutes ses propriétés par celles de l'objet entrant
        movie.setOriginalTitle(newMovie.getOriginalTitle());
        movie.setOverview(newMovie.getOverview());
        movie.setPosterPath(newMovie.getPosterPath());
        movie.setReleaseDate(newMovie.getReleaseDate());
        movie.setOriginalLanguage(newMovie.getOriginalLanguage());
        movie.setPopularity(newMovie.getPopularity());
        movie.setGenre(newMovie.getGenre());
        
        // Sauvegarde le produit en BDD et renvoie une copie
        return movieRepository.save(movie);
    }

    // Renvoie un produit particulier de la base de données (en fonction de son id)
    @GetMapping("/{id}")
    public Movie getProductById(@PathVariable(value = "id") Long movieId) {
        return this.fetchProduct(movieId);
    }

    // Supprimer un produit existant
    @DeleteMapping("/{id}")
    // En cas de succès, renvoie un code HTTP 204 au lieu du code 200 par défaut
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable(value = "id") Long productId) {
        Movie movie = this.fetchMovie(movieId);
        movieRepository.delete(movie);
    }

    // Méthode réutilisable permettant d'aller chercher un produit dans la BDD en fonction de son id
    // Renvoie automatiquement une erreur 404 si le produit n'existe pas
    public Movie fetchProduct(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found")
        );
        return movie;
    }
}
