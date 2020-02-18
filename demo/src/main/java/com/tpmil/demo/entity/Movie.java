// mouctar entity movie
package com.tpmil.demo.entity;

import java.util.Date;


import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


// Cette classe est une entité de la BDD
@Entity
// Elle correspond à la table `product`
@Table(name = "movie")
@EntityListeners(AuditingEntityListener.class)
public class Movie {

    // Cette propriété est la clé primaire de l'entité
    @Id
    // Cette propriété s'auto-incrémente
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Cette propriété correspond à la colonne `id` en BDD
    // Elle est unique et ne peut pas être nulle
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    private String Original_title;
    private String Overview;
    private String Poster_path;
    private Date Release_date;
    private String Original_language;
    private Float Popularity;
    private int genre;

 public long getId() {
 	return this.id;
 }
 public void setId(long id) {
 	this.id = id;
 }


    public String getOriginal_title() {
    	return this.Original_title;
    }
    public void setOriginal_title(String Original_title) {
    	this.Original_title = Original_title;
    }


    public String getOverview() {
    	return this.Overview;
    }
    public void setOverview(String Overview) {
    	this.Overview = Overview;
    }


    public String getPoster_path() {
    	return this.Poster_path;
    }
    public void setPoster_path(String Poster_path) {
    	this.Poster_path = Poster_path;
    }


    public Date getRelease_date() {
    	return this.Release_date;
    }
    public void setRelease_date(Date Release_date) {
    	this.Release_date = Release_date;
    }


    public String getOriginal_language() {
    	return this.Original_language;
    }
    public void setOriginal_language(String Original_language) {
    	this.Original_language = Original_language;
    }


    public Float getPopularity() {
    	return this.Popularity;
    }
    public void setPopularity(Float Popularity) {
    	this.Popularity = Popularity;
    }


    public int getGenre() {
    	return this.genre;
    }
    public void setGenre(int genre) {
    	this.genre = genre;
    }

}