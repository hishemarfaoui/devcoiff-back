package com.example.devcoiff.Repositories;

import com.example.devcoiff.Entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Integer> {

}
