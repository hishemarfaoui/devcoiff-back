package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Créneaux;
import com.example.devcoiff.Entities.Message;

import java.util.List;

public interface ICréneau {
    public Créneaux ajoutCreneau(Créneaux créneaux,Long id_fournisseur);
    public void modifierCreneau(Créneaux créneaux);
    public void supprimerCreneau(Integer id);
    public Créneaux getCreneau(Integer id);
    public List<Créneaux> getAllCreneau();
}
