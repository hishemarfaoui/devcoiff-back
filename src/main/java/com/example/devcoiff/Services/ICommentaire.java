package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Commentaire;
import com.example.devcoiff.Entities.Créneaux;

import java.util.List;

public interface ICommentaire {
    public Commentaire ajoutCommentaire(Commentaire commentaire, Long id_fournisseur);
    public void modifierCommentaire(Commentaire commentaire);
    public void supprimerCommentaire(Long id);
    public Commentaire getCommentaire(Long id);
    public List<Commentaire> getAllCommentaire();
}
