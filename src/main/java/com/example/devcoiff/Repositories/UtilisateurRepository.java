package com.example.devcoiff.Repositories;

import com.example.devcoiff.Entities.Service;
import com.example.devcoiff.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

  Optional<Utilisateur> findByUsername(String username);
  Boolean existsByUsername(String username);

}
