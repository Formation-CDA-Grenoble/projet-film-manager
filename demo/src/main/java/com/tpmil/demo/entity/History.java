//léo

package com.tpmil.demo.entity;

import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "history")
@EntityListeners(AuditingEntityListener.class)
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)

    private long id ; 
    @Column(name = "date", nullable = false)
    private Date date ; 
   // @Column(name = "movie_id", nullable = false)
  //  private long movie_id ; 
  //  @Column(name = "user_id", nullable = true)
  //  private long user_id ; 

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("history")
    @JsonManagedReference
    private Movie movie;

    public Movie getMovie() {
        return this.movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("history")
    private User user;

    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
      return this.date;
    }
    public void setDate(Date date) {
      this.date = date;
    }


   // public long getMovie_id() {
   //   return this.movie_id;
   // }
  //  public void setMovie_id(long movie_id) {
   //   this.movie_id = movie_id;
  //  }


   // public long getUser_id() {
    //  return this.user_id;
  //  }
  //  public void setUser_id(long user_id) {
   //   this.user_id = user_id;
   // }

  }

        

    