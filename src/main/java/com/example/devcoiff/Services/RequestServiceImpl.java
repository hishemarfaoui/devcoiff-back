package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Request;
import com.example.devcoiff.Repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RequestServiceImpl implements IRequest{
    @Autowired
    RequestRepository requestRepository;
    @Override
    public Request ajoutRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public void modifierRequest(Request request) {
        requestRepository.save(request);

    }

    @Override
    public void supprimerRequest(Long id) {
        requestRepository.deleteById(id);

    }

    @Override
    public Request getRequest(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    @Override
    public List<Request> getAllRequest() {
        return requestRepository.findAll();
    }

    @Override
    public long count() {
        return requestRepository.count();
    }
}
