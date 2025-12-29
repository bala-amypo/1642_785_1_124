package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiversityClassificationServiceImpl implements DiversityClassificationService {
    private final DiversityClassificationRepository repository;
    
    public DiversityClassificationServiceImpl(DiversityClassificationRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<DiversityClassification> getAllClassifications() {
        return repository.findAll();
    }
    
    @Override
    public void deactivateClassification(Long id) {
        DiversityClassification classification = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classification not found"));
        classification.setActive(false);
        repository.save(classification);
    }

    @Override
    public DiversityClassification postClassificationn(DiversityClassification c){
         return repository.save(c);
    }

    @Override
    public DiversityClassification updateClassification(Long id,DiversityClassification c){
        if(repository.existsById(id)){
            c.setId(id);
            return repository.save(c);
        }
        return null;

    }

    @Override
    public DiversityClassification getById(Long id){
         return repository.findById(id).orElse(null);
    }

}