package com.example.devcoiff.Repositories;

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

}
