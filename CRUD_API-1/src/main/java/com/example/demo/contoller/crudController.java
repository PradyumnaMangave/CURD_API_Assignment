package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.crudEntity;
import com.example.demo.service.crudService;

@Controller
public class crudController {

	@Autowired
    private crudService service;
	
	@RequestMapping(value = "/addstudent" , method = RequestMethod.POST)
    public crudEntity addstudent(@RequestBody crudEntity student) {
        return service.savestudent(student);
    }

    @PostMapping("/addstudents")
    public List<crudEntity> addstudents(@RequestBody List<crudEntity> students) {
        return service.savestudents(students);
    }

    @GetMapping("/students")
    public List<crudEntity> findAllstudents() {
        return service.getstudents();
    }

    @GetMapping("/studentById/{id}")
    public crudEntity findstudentById(@PathVariable int id) {
        return service.getstudentById(id);
    }

    @PutMapping("/update")
    public crudEntity updatestudent(@RequestBody crudEntity student) {
        return service.updatestudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deletestudent(@PathVariable int id) {
        return service.deletestudent(id);
    }
}
