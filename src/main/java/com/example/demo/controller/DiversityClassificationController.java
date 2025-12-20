package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.service.DiversityClassificationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class DiversityClassificationController {
    private final DiversityClassificationService dcs;
    public DiversityClassificationController(DiversityClassificationService dcs){
        this.dcs=dcs;
    }

    @PostMapping("/POST/classifications")
    public DiversityClassification postClassification(@RequestBody DiversityClassification c){
          return dcs.createClassification(c);
    }

    @PutMapping("/PUT/suppliers/{id}")
    public DiversityClassification updateValue(@PathVariable Long id,@RequestBody DiversityClassification c){
        return dcs.updateClassification(id,c);
    }

    @GetMapping("/GET/suppliers/{id}")
    public DiversityClassification retrieveDiversityById(@PathVariable Long id){
       return dcs.getById(id);
    }

    @GetMapping("/GET/classifications")
    public List<DiversityClassification> retrieveDiversities(){
        return dcs.getAllClassifications();
    }

    @PutMapping("/PUT/classifications/{id}/deactivate")
    public void deactivateClassificationById(@PathVariable Long id){
        dcs.deactivateClassification(id);
    }
}
