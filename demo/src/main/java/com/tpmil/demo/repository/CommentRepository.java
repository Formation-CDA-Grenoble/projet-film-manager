//léo

package com.tpmil.demo.repository ; 

import java.util.List;

import com.tpmil.demo.entity.Comment ; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findAllByOrderByPublishedAtDesc();
}
