package com.example.devcoiff.Services;

import com.example.devcoiff.DTO.NumberFonction;
import com.example.devcoiff.Entities.Fonction;
import com.example.devcoiff.Repositories.FonctionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class FonctionServiceImpl implements IFonction{
    FonctionRepository fonctionRepository ;
    @Override
    public Fonction ajoutFonction(Fonction fonction) {
        return fonctionRepository.save(fonction) ;
    }

    @Override
    public Fonction modifierFonction(Fonction fonction) {
       return fonctionRepository.save(fonction);

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

    @Override
    public List<Map<String,Object>>  getAllNumbersByFunctionType() {
        return fonctionRepository.countByFonctionNom();
    }
}
