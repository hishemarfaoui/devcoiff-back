package com.example.devcoiff.Repositories;

import com.example.devcoiff.Entities.Date_de_travail;
import com.example.devcoiff.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateDeTravailRepository extends JpaRepository<Date_de_travail,Integer> {
}
