package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Utilisateur;

import java.util.List;

public interface IUtilisateur {
    public Utilisateur ajoutUtilisateur(Utilisateur utilisateur, int id);
    public void modifierUtlisateur(Utilisateur utilisateur);
    public void supprimerUtlisateur(Integer id);
    public Utilisateur getUtilisateur(Integer id);
    public List<Utilisateur> getAllUtilisateur();

    public List<com.example.devcoiff.Entities.Service> getServicesByUser(Integer idCoiff);
}
