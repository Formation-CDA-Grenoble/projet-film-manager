//mouctar 

package com.tpmil.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.tpmil.demo.entity.To_watch;
import com.tpmil.demo.repository.To_watchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


// Ce contrôleur fonctionne sur le modèle d'une API REST
@RestController
// Ce contrôleur répond à toutes les requêtes sur les endpoints /api/To_watch
@RequestMapping("/api/to_watchs")
// Ce contrôleur accepte les requêtes venant d'un serveur différent
@CrossOrigin
public class To_watchController {

    // Injection de dépendance
    // Une instance de ProductRepository est automatiquement créée
    // et rangée dans cette propriété à la construction du contrôleur
    @Autowired
    private To_watchRepository To_watchRepository;
    
    
    // Renvoie tous les produits de la base de données
    @GetMapping("")
    public List<To_watch> getAllTo_watch() {
        return To_watchRepository.findAll();
    }

    // Crée un nouveau produit
    @PostMapping("")
    // En cas de succès, renvoie un code HTTP 201 au lieu du code 200 par défaut
    @ResponseStatus(value = HttpStatus.CREATED)
    public To_watch createTo_watch(@Valid @RequestBody To_watch To_watch) {
        // Sauvegarde le produit en BDD et renvoie une copie 
        return To_watchRepository.save(To_watch);
    }

    // Met à jour les propriétés d'un produit déjà existant
    @PutMapping("/{id}")
    public To_watch updateTo_watch(@PathVariable(value = "id") Long To_watchId, @Valid @RequestBody To_watch newTo_watch) {
        // Récupère le produit tel qu'il existe actuellement dans la BDD
        To_watch To_watch = this.fetchTo_watch(To_watchId);
        // Remplace toutes ses propriétés par celles de l'objet entrant
        To_watch.setUser_id(newTo_watch.getUser_id());
        To_watch.setMovie(newTo_watch.getMovie());
        
       
        
        // Sauvegarde le produit en BDD et renvoie une copie
        return To_watchRepository.save(To_watch);
    }

    // Renvoie un produit particulier de la base de données (en fonction de son id)
    @GetMapping("/{id}")
    public To_watch getTo_wacthtById(@PathVariable(value = "id") Long To_watchId) {
        return this.fetchTo_watch(To_watchId);
    }

  
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable(value = "id") Long id) {
        To_watchRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "To_watch not found")
        );
        To_watchRepository.deleteById(id);
    }
//
//
    // Méthode réutilisable permettant d'aller chercher un produit dans la BDD en fonction de son id
    // Renvoie automatiquement une erreur 404 si le produit n'existe pas
    public To_watch fetchTo_watch(Long To_watchId) {
        To_watch To_watch = To_watchRepository.findById(To_watchId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "To_watch not found")
        );
        return To_watch;
    }
}
