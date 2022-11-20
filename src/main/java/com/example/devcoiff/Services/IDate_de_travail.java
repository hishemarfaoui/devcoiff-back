package com.example.devcoiff.Services;


import com.example.devcoiff.Entities.Date_de_travail;
import com.example.devcoiff.Entities.Utilisateur;

import java.util.List;

public interface IDate_de_travail {
    public Date_de_travail ajoutDate_travail(Date_de_travail date_de_travail);
    public void modifierDate_travail(Date_de_travail date_de_travail);
    public void supprimerDate_travail(Integer id);
    public Date_de_travail getDate_travail(Integer id);
    public List<Date_de_travail> getAllDate_travail();

}
