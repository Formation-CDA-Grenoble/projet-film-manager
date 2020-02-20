//léo
package com.tpmil.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "genre")
@EntityListeners(AuditingEntityListener.class)
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    @Column(name = "id", unique = true, nullable = false)
    private long id ; 
    @Column(name = "name", nullable = false)
    private String name ; 

    @OneToMany(mappedBy = "genre")
    @JsonIgnoreProperties("genre")
    @JsonBackReference
    private List<Movie> movies;


     public List<Movie> getMovies() {
     	return this.movies;
     }
     public void set(List<Movie> movies) {
     	this.movies = movies;
}

 public long getId() {
 	return this.id;
 }
 public void setId(long id) {
 	this.id = id;
 }


    public String getName() {
    	return this.name;
    }
    public void setName(String name) {
    	this.name = name;
    }
}