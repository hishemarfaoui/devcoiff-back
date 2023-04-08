package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Créneaux;
import com.example.devcoiff.Entities.Utilisateur;

import java.util.List;

public interface IUtilisateur {
    public Utilisateur ajoutUtilisateur(Utilisateur utilisateur, int id);
    public Utilisateur modifierUtlisateur(Utilisateur utilisateur);
    public void supprimerUtlisateur(Long id);
    public Utilisateur getUtilisateur(Long id);
    public List<Utilisateur> getAllUtilisateur();

    public List<com.example.devcoiff.Entities.Service> getServicesByUser(Long idCoiff);
    public List<Créneaux> getCreneauxByUser(Long idCoiff);
}
