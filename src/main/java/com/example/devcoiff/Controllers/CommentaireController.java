package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Commentaire;
import com.example.devcoiff.Entities.Créneaux;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Repositories.CommentaireRepository;
import com.example.devcoiff.Repositories.CreneauRepository;
import com.example.devcoiff.Services.ICommentaire;
import com.example.devcoiff.Services.ICréneau;
import com.example.devcoiff.Services.IUtilisateur;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/commentaires")

public class CommentaireController {
    @Autowired
    CommentaireRepository commentaireRepository;
    @Autowired
    IUtilisateur iUtilisateur;
    @Autowired
    ICommentaire iCommentaire;

    @PostMapping("/add/{idCoiff}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public Commentaire add_New_Commentaire(@RequestBody Commentaire commentaire , @PathVariable Long idCoiff) {
        Utilisateur user =iUtilisateur.getUtilisateur(idCoiff);
        commentaire.setUtilisateur(user);
        commentaireRepository.save(commentaire);

        return commentaire ;


    }
    @GetMapping("/all")
    @ResponseBody
    public List<Commentaire> all_Commentaire(){
        return commentaireRepository.findAll();
    }


    @GetMapping("/id/{id}")
    @ResponseBody
    public Commentaire GetCommentaire(@PathVariable("id") Long id){
        return iCommentaire.getCommentaire(id);
    }

    @PutMapping("/update")
    @ResponseBody
    public String Mise_A_jours_Commentaire(@RequestBody Commentaire commentaire){iCommentaire.modifierCommentaire(commentaire);
        return "updated";}
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String supp_Commentaire(@PathVariable("id") Long id){iCommentaire.supprimerCommentaire(id);
        return "removed";}
}
