package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;

@Service
public class DiversityClassificationServiceImpl implements DiversityClassificationService{
    private final DiversityClassificationRepository dcr;
    public DiversityClassificationServiceImpl(DiversityClassificationRepository dcr){
        this.dcr=dcr;
    }
    @Override
    public DiversityClassification createClassification(DiversityClassification c){
        return dcr.save(c);
    }

    @Override
    public DiversityClassification updateClassification(Long id,DiversityClassification c){
        if(dcr.existsById(id)){
            c.setId(id);
            return dcr.save(c);
        }
        return null;

    }

    @Override
    public List<DiversityClassification> getAllClassifications(){
         return dcr.findAll();
    }

    @Override
    public DiversityClassification getById(Long id){
         return dcr.findById(id).orElse(null);
    }

    @Override
    public void deactivateClassification(Long id){
       DiversityClassification dc=dcr.findById(id).orElse(null);
       if(dc!=null){
        dc.setActive(false);
       }
    }
}
