//léo

package com.tpmil.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.tpmil.demo.entity.*;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)

    private long id ; 
    private String username ; 
    private String mail ; 
    private String password ; 

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
