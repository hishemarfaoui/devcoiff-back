package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Créneaux;
import com.example.devcoiff.Entities.Fonction;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Repositories.UtilisateurRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class UtilisateurServiceImpl implements IUtilisateur{
    private IFonction iFonction;
     private UtilisateurRepository utilisateurRepository;
    private PasswordEncoder bcryptPasswordEncoder;





    public Utilisateur ajoutUtilisateur(Utilisateur utilisateur, int id) {
        utilisateur.setPassword(bcryptPasswordEncoder.encode(utilisateur.getPassword()));
        utilisateur.setRole(Utilisateur.Roles.ROLE_USER);
        Fonction fonction = iFonction.getFonction(id);
        utilisateur.setFonction(fonction);


        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur modifierUtlisateur(Utilisateur utilisateur) {
                    Utilisateur utilisateurDB = getUtilisateur(utilisateur.getId_utilis());
        assert utilisateurDB != null;
        if (bcryptPasswordEncoder.matches(utilisateur.getPassword(), utilisateurDB.getPassword())){
            utilisateur.setPassword(utilisateurDB.getPassword());
        }else {
            utilisateur.setPassword(bcryptPasswordEncoder.encode(utilisateur.getPassword()));
        }
          return utilisateurRepository.save(utilisateur);
    }






    public void supprimerUtlisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public Utilisateur getUtilisateur(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public List<com.example.devcoiff.Entities.Service> getServicesByUser(Long idCoiff){
                 Utilisateur user = utilisateurRepository.findById(idCoiff).orElse(null);
        assert user != null;
        return user.getServices();
    }

    @Override
    public List<Créneaux> getCreneauxByUser(Long idCoiff) {
        Utilisateur user = utilisateurRepository.findById(idCoiff).orElse(null);

        return user.getCréneaux();
    }
}
