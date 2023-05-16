package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Date_de_travail;
import com.example.devcoiff.Entities.Request;

import java.util.List;

public interface IRequest {
    public Request ajoutRequest(Request request);
    public void modifierRequest(Request request);
    public void supprimerRequest(Long id);
    public Request getRequest(Long id);
    public List<Request> getAllRequest();
    public long count();

}
