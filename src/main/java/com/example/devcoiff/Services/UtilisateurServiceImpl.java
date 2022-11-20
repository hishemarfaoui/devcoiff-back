package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Fonction;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Repositories.UtilisateurRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UtilisateurServiceImpl implements IUtilisateur{
    private IFonction iFonction;
     private UtilisateurRepository utilisateurRepository;


             public UtilisateurServiceImpl( UtilisateurRepository utilisateurRepository, IFonction iFonction) {
//                this.passwordEncoder = new BCryptPasswordEncoder();
                this.utilisateurRepository = utilisateurRepository;
                this.iFonction = iFonction;
    }

    public Utilisateur ajoutUtilisateur(Utilisateur utilisateur, int id) {
//        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        utilisateur.setRole(Utilisateur.Roles.ROLE_USER);
        Fonction fonction = iFonction.getFonction(id);
        utilisateur.setFonction(fonction);


        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void modifierUtlisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);

    }


    public void supprimerUtlisateur(Integer id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public Utilisateur getUtilisateur(Integer id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public List<com.example.devcoiff.Entities.Service> getServicesByUser(Integer idCoiff){
                 Utilisateur user = utilisateurRepository.findById(idCoiff).orElse(null);
        assert user != null;
        return user.getServices();
    }
}
