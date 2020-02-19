//léo

package com.tpmil.demo.entity;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)

    private long id ; 
    @Column(name = "username", nullable = false)
    private String username ;
    @Column(name = "mail", nullable = false) 
    private String mail ;
    @Column(name = "password", nullable = false) 
    private String password ; 

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<Favorite> favorites;


    public Set<Favorite> getFavorites() {
    	return this.favorites;
    }
    public void setFavorites(Set<Favorite> favorites) {
    	this.favorites = favorites;
    }

public long getId() {
	return this.id;
}
public void setId(long id) {
	this.id = id;
}


    public String getUsername() {
    	return this.username;
    }
    public void setUsername(String username) {
    	this.username = username;
    }


    public String getMail() {
    	return this.mail;
    }
    public void setMail(String mail) {
    	this.mail = mail;
    }


    public String getPassword() {
    	return this.password;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
}