package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Image;
import com.example.devcoiff.Entities.Service;

import java.util.List;

public interface IService {
    public Service ajoutService(Service service, Long idCoiff);
    public void modifierService(Service service);
    public void supprimerService(Integer id);
    public Service getService(Integer id);
    public List<Service> getAllServices();
}
