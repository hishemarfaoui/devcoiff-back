package com.example.devcoiff.Services;

import com.example.devcoiff.DTO.NumberFonction;
import com.example.devcoiff.Entities.Fonction;

import java.util.List;
import java.util.Map;

public interface IFonction {
    public Fonction ajoutFonction(Fonction fonction);
    public void modifierFonction(Fonction fonction);
    public void supprimerFonction(Integer id);
    public Fonction getFonction(Integer id);
    public List<Fonction> getAllFonction();
    public  List<Map<String,Object>>  getAllNumbersByFunctionType();
}