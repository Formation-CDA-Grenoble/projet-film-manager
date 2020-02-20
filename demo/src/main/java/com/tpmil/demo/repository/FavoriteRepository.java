//léo

package com.tpmil.demo.repository ; 

import java.util.List;

import com.tpmil.demo.entity.Favorite ; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    public default List<Favorite> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
}
