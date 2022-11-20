package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Date_de_travail;
import com.example.devcoiff.Repositories.DateDeTravailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Date_de_travailServiseImpl implements IDate_de_travail{
    @Autowired
    DateDeTravailRepository dateDeTravailRepository;
    @Override
    public Date_de_travail ajoutDate_travail(Date_de_travail date_de_travail) {
        return dateDeTravailRepository.save(date_de_travail) ;
    }

    @Override
    public void modifierDate_travail(Date_de_travail date_de_travail) {
     dateDeTravailRepository.save(date_de_travail);
    }

    @Override
    public void supprimerDate_travail(Integer id) {
dateDeTravailRepository.deleteById(id);
    }

    @Override
    public Date_de_travail getDate_travail(Integer id) {
        return dateDeTravailRepository.findById(id).orElse(null);
    }

    @Override
    public List<Date_de_travail> getAllDate_travail() {
        return dateDeTravailRepository.findAll();
    }
}
