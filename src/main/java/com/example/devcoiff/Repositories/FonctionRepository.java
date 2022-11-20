package com.example.devcoiff.Repositories;

import com.example.devcoiff.Entities.Fonction;
import com.example.devcoiff.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonctionRepository extends JpaRepository<Fonction,Integer> {
}
