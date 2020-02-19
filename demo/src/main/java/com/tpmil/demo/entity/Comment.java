//léo


package com.tpmil.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name = "id", unique = true, nullable = false)
    private long id ;
    @Column(name = "content", nullable = false)
    private String content;
  // @Column(name = "movie_id", nullable = false)
   // private long movie_id ; 
    @Column(name = "user_id", nullable = false)
    private long user_id ;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("comments")
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


    public String getContent() {
    	return this.content;
    }
    public void setContent(String content) {
    	this.content = content;
    }
  //  public void setMovie(Movie movie) {
   //	this.movie = movie;
    //}


    public long getUser_id() {
    	return this.user_id;
    }
    public void setUser_id(long user_id) {
    	this.user_id = user_id;
    }
}


    

