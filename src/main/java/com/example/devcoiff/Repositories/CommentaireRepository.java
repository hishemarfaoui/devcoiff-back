package com.example.devcoiff.Repositories;

import com.example.devcoiff.Entities.Commentaire;
import com.example.devcoiff.Entities.Créneaux;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {
}
