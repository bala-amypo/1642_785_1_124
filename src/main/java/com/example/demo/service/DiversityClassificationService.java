package com.example.demo.service;

import com.example.demo.entity.DiversityClassification;
import java.util.List;

public interface DiversityClassificationService {
    List<DiversityClassification> getAllClassifications();
    void deactivateClassification(Long id);
    DiversityClassification postClassificationn(DiversityClassification c);
    public DiversityClassification updateClassification(Long id,DiversityClassification c);
    DiversityClassification getById(Long id);

}