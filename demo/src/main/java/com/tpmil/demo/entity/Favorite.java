//léo

package com.tpmil.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "favorite")
@EntityListeners(AuditingEntityListener.class)
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id ;

  //  @Column(name = "movie_id", nullable = false)
   // private long movie_id ; 
  //  @Column(name = "user_id", nullable = true)
   // private  int user ; 
 // un film peut étre dans plusieurs favoris
    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("favorites")
    @JsonManagedReference
    private Movie movie;

    public Movie getMovie() {
        return this.movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
//un utilisateur peut avoir plusieurs films en favoris
    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("favorites")
    private User user;

    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
    	return this.id;
    }
    public void setId(long id) {
    	this.id = id;
    }
}


 //   public int getUser_id() {
   // 	return this.user_id;
 //   }
 //   public void setUser_id(int user_id) {
    	//this.user = user_id;
 //   }
//}


   // public long getMovie_id() {
    //	return this.movie_id;
    //}
  //  public void setMovie_id(long movie_id) {
    //	this.movie_id = movie_id;
 //   }

