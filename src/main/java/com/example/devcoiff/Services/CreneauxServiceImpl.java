package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Créneaux;
import com.example.devcoiff.Repositories.CreneauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreneauxServiceImpl implements ICréneau{
    @Autowired
    CreneauRepository creneauRepository;
    @Override
    public Créneaux ajoutCreneau(Créneaux créneaux) {
        return creneauRepository.save(créneaux);
    }

    @Override
    public void modifierCreneau(Créneaux créneaux) {
        creneauRepository.save(créneaux);
    }

    @Override
    public void supprimerCreneau(Integer id) {
creneauRepository.deleteById(id);
    }

    @Override
    public Créneaux getCreneau(Integer id) {
        return creneauRepository.findById(id).orElse(null);
    }

    @Override
    public List<Créneaux> getAllCreneau() {
        return creneauRepository.findAll();
    }
}
