//léo

package com.tpmil.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "to_watch")
@EntityListeners(AuditingEntityListener.class)
public class To_watch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)

    private long id ; 
    // Cette command , c'estait juste pour tester les liaisons dans 
    // la base de donnée il faut le commanté quand on fait les relation
    // dans java
    //@Column(name = "movie_id", nullable = false)
    //private long movie_id ; 
    @Column(name = "user_id", nullable = true)
    private long user_id ; 

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("to_watchs")
    @JsonManagedReference
    private Movie movie;

    public Movie getMovie() {
        return this.movie;
    }
    public void setMovie(Movie movie ) {
        this.movie = movie;
    } 

 public long getId() {
 	return this.id;
 }
 public void setId(long id) {
 	this.id = id;
 }


    public long getUser_id() {
    	return this.user_id;
    }
    public void setUser_id(long user_id) {
    	this.user_id = user_id;
    }


   //  public long getMovie_id() {
   //  	return this.movie_id;
   //  }
   //  public void setMovie_id(long movie_id) {
   //  	this.movie_id = movie_id;
   //  }
   }
