package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Fonction;
import com.example.devcoiff.Repositories.FonctionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class FonctionServiceImpl implements IFonction{
    FonctionRepository fonctionRepository ;
    @Override
    public Fonction ajoutFonction(Fonction fonction) {
        return fonctionRepository.save(fonction) ;
    }

    @Override
    public void modifierFonction(Fonction fonction) {
        fonctionRepository.save(fonction);

    }

    @Override
    public void supprimerFonction(Integer id) {
        fonctionRepository.deleteById(id);

    }

    @Override
    public Fonction getFonction(Integer id) {
        return fonctionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Fonction> getAllFonction() {
        return fonctionRepository.findAll();
    }
}
