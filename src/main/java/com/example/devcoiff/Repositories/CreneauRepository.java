package com.example.devcoiff.Repositories;

import com.example.devcoiff.Entities.Créneaux;
import com.example.devcoiff.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreneauRepository extends JpaRepository<Créneaux,Integer> {
}
