package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Commentaire;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Repositories.CommentaireRepository;
import com.example.devcoiff.Repositories.CreneauRepository;
import com.example.devcoiff.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CommentaireServiceImpl implements ICommentaire {
    @Autowired
    CommentaireRepository commentaireRepository;
    @Autowired
    UtilisateurRepository userRepo;
    @Override
    public Commentaire ajoutCommentaire(Commentaire commentaire, Long id_fournisseur) {
        Utilisateur user = userRepo.findById(id_fournisseur).orElse(null);
        assert user != null;
//        List<Service> listService = new ArrayList<>();
//        listService.add(service);
//        user.setServices(listService);
        user.getCommentaires().add(commentaire);
        return commentaireRepository.save(commentaire);
    }

    @Override
    public void modifierCommentaire(Commentaire commentaire) {
        commentaireRepository.save(commentaire);

    }

    @Override
    public void supprimerCommentaire(Long id) {
        commentaireRepository.deleteById(id);

    }

    @Override
    public Commentaire getCommentaire(Long id) {
        return commentaireRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commentaire> getAllCommentaire() {
        return commentaireRepository.findAll();
    }
}
