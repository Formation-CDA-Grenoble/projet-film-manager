//léo

package com.tpmil.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.tpmil.demo.entity.*;

@Entity
@Table(name = "comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "moovie_id", nullable = false)
    private long moovie_id;

    @Column(name = "user_id", nullable = true)
    private long user_id;


    public String getContent() {
    	return this.content;
    }
    public void setContent(String content) {
    	this.content = content;
    }


    public String getMoovie_id() {
    	return this.moovie_id;
    }
    public void setMoovie_id(String moovie_id) {
    	this.moovie_id = moovie_id;
    }

    
    public String getUser_id() {
    	return this.user_id;
    }
    public void setUser_id(String user_id) {
    	this.user_id = user_id;
    }


    @OneToMany(mappedBy = "Comment")
    @JsonIgnoreProperties("Comment")
    private Set<moovie> moovie;

    
    @OneToMany(mappedBy = "Comment")
    @JsonIgnoreProperties("Comment")
    private Set<user> user;

