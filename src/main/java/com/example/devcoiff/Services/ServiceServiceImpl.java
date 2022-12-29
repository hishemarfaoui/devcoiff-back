package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Service;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Repositories.ServiceRepository;
import com.example.devcoiff.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IService{
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    UtilisateurRepository userRepo;
    @Override
    public Service ajoutService(Service service, Long idCoiff) {

        Utilisateur user = userRepo.findById(idCoiff).orElse(null);
        assert user != null;
//        List<Service> listService = new ArrayList<>();
//        listService.add(service);
//        user.setServices(listService);
        user.getServices().add(service);
        return serviceRepository.save(service);
    }

    @Override
    public void modifierService(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void supprimerService(Integer id) {
     serviceRepository.deleteById(id);
    }

    @Override
    public Service getService(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }
}
