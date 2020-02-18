//léo

package com.tpmil.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.tpmil.demo.entity.History;
import com.tpmil.demo.repository.HistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


// Ce contrôleur fonctionne sur le modèle d'une API REST
@RestController
// Ce contrôleur répond à toutes les requêtes sur les endpoints /api/History
@RequestMapping("/api/history")
// Ce contrôleur accepte les requêtes venant d'un serveur différent
@CrossOrigin
public class HistoryController {

    // Injection de dépendance
    // Une instance de ProductRepository est automatiquement créée
    // et rangée dans cette propriété à la construction du contrôleur
    @Autowired
    private HistoryRepository historyRepository;
    
    
    // Renvoie tous les produits de la base de données
    @GetMapping("")
    public List<History> getAllhistory() {
        return historyRepository.findAll();
    }

    // Crée un nouveau produit
    @PostMapping("")
    // En cas de succès, renvoie un code HTTP 201 au lieu du code 200 par défaut
    @ResponseStatus(value = HttpStatus.CREATED)
    public History createHistory(@Valid @RequestBody History history) {
        // Sauvegarde le produit en BDD et renvoie une copie 
        return historyRepository.save(history);
    }

    // Met à jour les propriétés d'un produit déjà existant
    @PutMapping("/{id}")
    public History updateHistory(@PathVariable(value = "id") Long historyId, @Valid @RequestBody History newhistory) {
        // Récupère le produit tel qu'il existe actuellement dans la BDD
        History history = this.fetchHistory(historyId);
        // Remplace toutes ses propriétés par celles de l'objet entrant
        history.setDate(newhistory.getDate());
        history.setUser_id(newhistory.getUser_id());
        history.setMovie_id(newhistory.getMovie_id());
        
     
        // Sauvegarde le produit en BDD et renvoie une copie
        return historyRepository.save(history);
    }
 
     private History fetchHistory(Long historyId) {
        return null;
    }

    // Renvoie un produit particulier de la base de données (en fonction de son id)
    @GetMapping("/{id}")
    public History getProductById(@PathVariable(value = "id") Long historyId) {
        return this.fetchProduct(historyId);
    }

  
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable(value = "id") Long id) {
        historyRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "history not found")
        );
        historyRepository.deleteById(id);
    }
//
//
    // Méthode réutilisable permettant d'aller chercher un produit dans la BDD en fonction de son id
    // Renvoie automatiquement une erreur 404 si le produit n'existe pas
    public History fetchProduct(Long historyId) {
        History history = historyRepository.findById(historyId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "history not found")
        );
        return history;
    }
}
