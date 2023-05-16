package com.example.devcoiff.Services;

import com.example.devcoiff.DTO.FonctionRendezVousDTO;
import com.example.devcoiff.Entities.Rendez_vous;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Repositories.RvRepository;
import com.example.devcoiff.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Rendez_vousServiceImpl implements IRendez_vous{
    @Autowired
    RvRepository rvRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;




    @Override
    public Rendez_vous ajoutRV(Rendez_vous rendez_vous, Long idcoif, Long idcl) {
        Utilisateur client = utilisateurRepository.findById(idcl).orElse(null);
        Utilisateur coiffeur = utilisateurRepository.findById(idcoif).orElse(null);


        rendez_vous.setClient(client);
        rendez_vous.setCoiffeur(coiffeur);
        rendez_vous.setStatus(Rendez_vous.Etat.Pending);

        return rvRepository.save(rendez_vous);
    }

    @Override
    public void modifierRV(Rendez_vous rendez_vous) {
       rvRepository.save(rendez_vous);
    }

    @Override
    public void supprimerRV(Integer id) {
     rvRepository.deleteById(id);
    }

    @Override
    public Rendez_vous getRV(Integer id) {
        return rvRepository.findById(id).orElse(null);
    }

    @Override
    public List<Rendez_vous> getAllRV() {
        return rvRepository.findAll();
    }

    @Override
    public Rendez_vous accepterRV(Integer idRdv) {
        Rendez_vous rdv = rvRepository.findById(idRdv).orElse(null);
        assert rdv != null;
        rdv.setStatus(Rendez_vous.Etat.Accepted);
        return rvRepository.save(rdv);
    }

    @Override
    public Rendez_vous reffuserRV(Integer idRdv) {
        Rendez_vous rdv = rvRepository.findById(idRdv).orElse(null);
        assert rdv != null;
        rdv.setStatus(Rendez_vous.Etat.Refused);
        return rvRepository.save(rdv);

    }
    @Override
    public List<Rendez_vous> findDispo(Integer idCoiff){
        return this.rvRepository.findDispo(idCoiff);
    }

    @Override
    public List<FonctionRendezVousDTO> countRendezVousByFonction() {
        return rvRepository.countRendezVousByFonction();
    }
}
