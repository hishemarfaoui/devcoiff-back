package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Rendez_vous;
import com.example.devcoiff.Entities.Utilisateur;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IRendez_vous {
    public Rendez_vous ajoutRV(Rendez_vous rendez_vous, Integer idcoif, Integer idcl);
    public void modifierRV(Rendez_vous rendez_vous);
    public void supprimerRV(Integer id);
    public Rendez_vous getRV(Integer id);
    public List<Rendez_vous> getAllRV();
    public void accepterRV(Rendez_vous rendez_vous);
    public void reffuserRV(Rendez_vous rendez_vous);
}
