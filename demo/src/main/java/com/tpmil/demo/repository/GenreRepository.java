//léo

package com.tpmil.demo.repository ; 

import java.util.List;

import com.tpmil.demo.entity.Genre ; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    public List<Genre> findAllByOrderByPublishedAtDesc();
}
