//léo


package com.tpmil.demo.entity;
/*

import inutiles pour l'instant

import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tpmil.demo.entity.*;
*/


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
    @Column(name = "moovie_id", nullable = false)
    private long movie_id ; 
    @Column(name = "user_id", nullable = false)
    private long user_id ; 


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


    public long getMovie_id() {
    	return this.movie_id;
    }
    public void setMovie_id(long movie_id) {
    	this.movie_id = movie_id;
    }


    public long getUser_id() {
    	return this.user_id;
    }
    public void setUser_id(long user_id) {
    	this.user_id = user_id;
    }
}


    

