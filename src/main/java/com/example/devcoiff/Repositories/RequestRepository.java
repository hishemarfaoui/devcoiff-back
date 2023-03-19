package com.example.devcoiff.Repositories;

import com.example.devcoiff.Entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {
}
