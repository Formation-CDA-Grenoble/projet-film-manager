//léo

package com.tpmil.demo.entity;
import javax.persistence.*;
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

    


    // public Set<Movie> getMovies() {
    // 	return this.movies;
    // }
    // public void sets(Set<Movie> movies) {
    // 	this.movies = movies;
    // }

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