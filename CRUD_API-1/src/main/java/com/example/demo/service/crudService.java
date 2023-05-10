package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.crudEntity;
import com.example.demo.repo.crudRepo;


@Service
public class crudService {

	@Autowired
	private crudRepo repository;
	
	public crudEntity savestudent(crudEntity student) {
		return repository.save(student);
	}
	
	public List<crudEntity> savestudents(List<crudEntity> students) {
		return repository.saveAll(students);
	}
	
	public List<crudEntity> getstudents() {
        return repository.findAll();
    }

    public crudEntity getstudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deletestudent(int id) {
        repository.deleteById(id);
        return "student removed !! " + id;
    }

    public crudEntity updatestudent(crudEntity student) {
    	crudEntity existingstudent = repository.findById(student.getId()).orElse(null);
        existingstudent.setName(student.getName());
        existingstudent.setEmail(student.getEmail());
        existingstudent.setAge(student.getAge());
        return repository.save(existingstudent);
    }
}
