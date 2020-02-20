//mouctar

package com.tpmil.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.tpmil.demo.entity.Favorite;
import com.tpmil.demo.entity.Movie;
import com.tpmil.demo.repository.MovieRepository;
import com.tpmil.demo.repository.FavoriteRepository;

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
    @Autowired
    private FavoriteRepository favoriteRepository;

    // Injection de dépendance
    // Une instance de ProductRepository est automatiquement créée
    // et rangée dans cette propriété à la construction du contrôleur
    @Autowired
    private MovieRepository movieRepository;
    
    
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
        movie.setOriginal_title(newMovie.getOriginal_title());
        movie.setOverview(newMovie.getOverview());
        movie.setPoster_path(newMovie.getPoster_path());
        movie.setRelease_date(newMovie.getRelease_date());
        movie.setOriginal_language(newMovie.getOriginal_language());
        movie.setPopularity(newMovie.getPopularity());
        movie.setGenre(newMovie.getGenre());
        
        // Sauvegarde le produit en BDD et renvoie une copie
        return movieRepository.save(movie);
    }


    // Renvoie un produit particulier de la base de données (en fonction de son id)
    @GetMapping("/{id}")
    public Movie getProductById(@PathVariable(value = "id") Long movieId) {
        return this.fetchMovie(movieId);
    }

  
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable(value = "id") Long id) {
        movieRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "movie not found")
        );
        movieRepository.deleteById(id);
    }
    // @GetMapping("/{movieId}/addFavorite/{favoriteId}")
    // public Movie addFavorite(
    //     @PathVariable(value = "movieId") Long movieId,
    //     @PathVariable(value = "favoriteId") Long favoriteId
    // ) {
    //     Movie movie = this.fetchMovie(movieId);
      
    //     Favorite favorite = favoriteRepository.findById( favoriteId)
    //             .orElseThrow(
    //         () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorite not found")
    //     );

    //     if (Movie.getFavorites().contains(favorite)) {
    //         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie already present in order");
    //     }

    //     Movie.getFavorites().add(favorite);
    //     return movieRepository.save(movie);
    // }
//
    // Méthode réutilisable permettant d'aller chercher un produit dans la BDD en fonction de son id
    // Renvoie automatiquement une erreur 404 si le produit n'existe pas
    public Movie fetchMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found")
        );
        return movie;
    }
}
