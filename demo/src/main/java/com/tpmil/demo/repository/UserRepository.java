//léo

package com.tpmil.demo.repository ; 

import java.util.List;

import com.tpmil.demo.entity.User ; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAll();
    public User findByUsername(String username);
}
