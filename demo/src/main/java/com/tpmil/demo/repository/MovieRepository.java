// mouctar entity movie
package com.tpmil.demo.repository;

import com.tpmil.demo.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {}
