package com.example.devcoiff.Repositories;

import com.example.devcoiff.DTO.NumberFonction;
import com.example.devcoiff.Entities.Fonction;
import com.example.devcoiff.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FonctionRepository extends JpaRepository<Fonction,Integer> {
    @Query(value = "SELECT count(utilisateur.id_utilis) as nombre, fonctions.nom as functionType FROM fonctions JOIN utilisateur ON utilisateur.fonction_id_fonction = fonctions.id_fonction GROUP BY fonctions.nom",nativeQuery = true)

   public List<Map<String,Object>> countByFonctionNom();
    public Fonction findByNom(String nom);

}
