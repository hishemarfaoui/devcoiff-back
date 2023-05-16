package com.example.devcoiff.Repositories;

import com.example.devcoiff.DTO.FonctionRendezVousDTO;
import com.example.devcoiff.Entities.Rendez_vous;
import com.example.devcoiff.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RvRepository extends JpaRepository<Rendez_vous,Integer> {

    @Query(
            value = "SELECT COUNT(*) AS nb ,date_rv, status,id_rv,client_id,coiffeur_id FROM `rendez_vous` WHERE coiffeur_id = ?1 GROUP BY date_rv  HAVING nb >= 5 AND status = 1",
            nativeQuery = true)
    List<Rendez_vous> findDispo(Integer coiffId);

        @Query("SELECT new com.example.devcoiff.DTO.FonctionRendezVousDTO(f.nom, COUNT(rv.id_rv)) " +
                "FROM Fonction f " +
                "LEFT JOIN Utilisateur u ON f.id_fonction = u.fonction.id_fonction " +
                "LEFT JOIN Rendez_vous rv ON u.id_utilis = rv.coiffeur.id_utilis " +
                "WHERE f.id_fonction != 1 " +
                "GROUP BY f.id_fonction")
        List<FonctionRendezVousDTO> countRendezVousByFonction();
    }



