package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Fonction;
import com.example.devcoiff.Entities.Image;

import java.util.List;

public interface IFonction {
    public Fonction ajoutFonction(Fonction fonction);
    public void modifierFonction(Fonction fonction);
    public void supprimerFonction(Integer id);
    public Fonction getFonction(Integer id);
    public List<Fonction> getAllFonction();
}
