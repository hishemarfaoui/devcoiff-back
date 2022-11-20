package com.example.devcoiff.Repositories;

import com.example.devcoiff.Entities.Rendez_vous;
import com.example.devcoiff.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RvRepository extends JpaRepository<Rendez_vous,Integer> {
}
