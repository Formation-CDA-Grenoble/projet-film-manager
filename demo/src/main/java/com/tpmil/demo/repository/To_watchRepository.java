//léo

package com.tpmil.demo.repository ; 

import java.util.List;

import com.tpmil.demo.entity.To_watch ; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface To_watchRepository extends JpaRepository<To_watch, Long> {
    public List<To_watch> findAll();
}
