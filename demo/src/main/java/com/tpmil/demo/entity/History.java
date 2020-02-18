//léo

package com.tpmil.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.tpmil.demo.entity.*;

@Entity
@Table(name = "history")
@EntityListeners(AuditingEntityListener.class)
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)

    private long id ; 
    private Date date ; 
    private long user_id ; 
    private long movie_id ; 

  public long getId() {
  	return this.id;
  }
  public void setId(long id) {
  	this.id = id;
  }


    public Date getDate() {
    	return this.date;
    }
    public void setDate(Date date) {
    	this.date = date;
    }


    public long getUser_id() {
    	return this.user_id;
    }
    public void setUser_id(long user_id) {
    	this.user_id = user_id;
    }


    public long getMovie_id() {
    	return this.movie_id;
    }
    public void setMovie_id(long movie_id) {
    	this.movie_id = movie_id;
    }
