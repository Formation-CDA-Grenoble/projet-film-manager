//léo

package com.tpmil.demo.repository ; 

import java.util.List;

import com.tpmil.demo.entity.History ; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    public List<History> findAll();
}
