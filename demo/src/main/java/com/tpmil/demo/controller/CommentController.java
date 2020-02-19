//mouctar 

package com.tpmil.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.tpmil.demo.entity.Comment;
import com.tpmil.demo.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


// Ce contrôleur fonctionne sur le modèle d'une API REST
@RestController
// Ce contrôleur répond à toutes les requêtes sur les endpoints /api/Comment
@RequestMapping("/api/comments")
// Ce contrôleur accepte les requêtes venant d'un serveur différent
@CrossOrigin
public class CommentController {

    // Injection de dépendance
    // Une instance de ProductRepository est automatiquement créée
    // et rangée dans cette propriété à la construction du contrôleur
    @Autowired
    private CommentRepository CommentRepository;
    
    
    // Renvoie tous les produits de la base de données
    @GetMapping("")
    public List<Comment> getAllComment() {
        return CommentRepository.findAll();
    }

    // Crée un nouveau produit
    @PostMapping("")
    // En cas de succès, renvoie un code HTTP 201 au lieu du code 200 par défaut
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment createComment(@Valid @RequestBody Comment Comment) {
        // Sauvegarde le produit en BDD et renvoie une copie 
        return CommentRepository.save(Comment);
    }

    // Met à jour les propriétés d'un produit déjà existant
    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable(value = "id") Long CommentId, @Valid @RequestBody Comment newComment) {
        // Récupère le produit tel qu'il existe actuellement dans la BDD
        Comment Comment = this.fetchComment(CommentId);
        // Remplace toutes ses propriétés par celles de l'objet entrant
        Comment.setContent(newComment.getContent());
        Comment.setMovie(newComment.getMovie());
        Comment.setUser_id(newComment.getUser_id());
       
        
        // Sauvegarde le produit en BDD et renvoie une copie
        return CommentRepository.save(Comment);
    }

    private Comment fetchComment(Long CommentId) {
        return null;
    }

    // Renvoie un produit particulier de la base de données (en fonction de son id)
    @GetMapping("/{id}")
    public Comment getProductById(@PathVariable(value = "id") Long CommentId) {
        return this.fetchProduct(CommentId);
    }

  
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable(value = "id") Long id) {
        CommentRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found")
        );
        CommentRepository.deleteById(id);
    }
//
//
    // Méthode réutilisable permettant d'aller chercher un produit dans la BDD en fonction de son id
    // Renvoie automatiquement une erreur 404 si le produit n'existe pas
    public Comment fetchProduct(Long CommentId) {
        Comment Comment = CommentRepository.findById(CommentId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found")
        );
        return Comment;
    }
}
