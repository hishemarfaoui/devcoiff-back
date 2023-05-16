package com.example.devcoiff.Services;

import com.example.devcoiff.DTO.FonctionRendezVousDTO;
import com.example.devcoiff.Entities.Message;
import com.example.devcoiff.Entities.Rendez_vous;
import com.example.devcoiff.Entities.Utilisateur;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IRendez_vous {
    public Rendez_vous ajoutRV(Rendez_vous rendez_vous, Long idcoif, Long idcl);
    public void modifierRV(Rendez_vous rendez_vous);
    public void supprimerRV(Integer id);
    public Rendez_vous getRV(Integer id);
    public List<Rendez_vous> getAllRV();
    Rendez_vous accepterRV(Integer idRdv);

    Rendez_vous reffuserRV(Integer idRdv);

    public List<Rendez_vous> findDispo(Integer idCoiff);
    public List<FonctionRendezVousDTO> countRendezVousByFonction();


}
