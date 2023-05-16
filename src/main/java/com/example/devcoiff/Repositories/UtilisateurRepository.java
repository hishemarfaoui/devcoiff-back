package com.example.devcoiff.Repositories;

import com.example.devcoiff.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

  Optional<Utilisateur> findByUsername(String username);
  Boolean existsByUsername(String username);
  @Query("SELECT COUNT(u) FROM Utilisateur u WHERE u.fonction.id_fonction <> 1")
  long count();

}
