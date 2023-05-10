package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.*;

public interface crudRepo extends JpaRepository <crudEntity, Integer> {

}
