// mouctar entity movie
package com.tpmil.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @Column(name = "original_title", nullable = false)
    private String original_title;
    @Column(name = "overview", nullable = false)
    private String overview;
    @Column(name = "poster_path", nullable = false)
    private String poster_path;
    @Column(name = "release_date", nullable = false)
    private Date release_date;
    @Column(name = "original_language", nullable = false)
    private String original_language;
    @Column(name = "popularity", nullable = false)
    private Float popularity;
    // @Column(name = "genre_id", nullable = false)
    // private int genre_id;

    @OneToMany(mappedBy = "movie")
    @JsonBackReference
     private List<Comment> comments;

    public List<Comment> getComments() {
        return this.comments;
    }

    public void set(List<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private List<Favorite> favorites;


    public List<Favorite> getFavorites() {
    	return this.favorites;
    }
    public void List(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private List<To_watch> to_watchs;


    public List<To_watch> getTo_watchs() {
    	return this.to_watchs;
    }
    public void setTo_watch(List<To_watch> to_watchs) {
    	this.to_watchs = to_watchs;
    }
    @ManyToOne
    @JoinColumn
    @JsonManagedReference
    private Genre genre;

    public Genre getGenre() {
        return this.genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private List<History> history;


    public List<History> getHistory() {
    	return this.history;
    }
    public void setHistory(List<History> historys) {
        this.history = historys;
        
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getOriginal_title() {
        return this.original_title;
    }
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }


    public String getOverview() {
        return this.overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }


    public String getPoster_path() {
        return this.poster_path;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }


    public Date getRelease_date() {
        return this.release_date;
    }
    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }


    public String getOriginal_language() {
        return this.original_language;
    }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }


    public Float getPopularity() {
        return this.popularity;
    }
    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }


    //public int getGenre_id() {
    //    return this.genre_id;
   // }
  //  public void setGenre_id(int genre_id) {
       // this.genre_id = genre_id;
  //  }
}


    