package com.example.devcoiff.Repositories;

import com.example.devcoiff.Entities.Message;
import com.example.devcoiff.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    public List<Message> findAllByUtilisateurAndUtilisateurs(Utilisateur utilisateur, Utilisateur utilisateurs);
}
