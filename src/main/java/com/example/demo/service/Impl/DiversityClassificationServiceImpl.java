// package com.example.demo.service.Impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.entity.DiversityClassification;
// import com.example.demo.repository.DiversityClassificationRepository;
// import com.example.demo.service.DiversityClassificationService;

// @Service
// public class DiversityClassificationServiceImpl implements DiversityClassificationService{
//     private final DiversityClassificationRepository dcr;
//     public DiversityClassificationServiceImpl(DiversityClassificationRepository dcr){
//         this.dcr=dcr;
//     }
    // @Override
    // public DiversityClassification createClassification(DiversityClassification c){
    //     return dcr.save(c);
    // }

    // @Override
    // public DiversityClassification updateClassification(Long id,DiversityClassification c){
    //     if(dcr.existsById(id)){
    //         c.setId(id);
    //         return dcr.save(c);
    //     }
    //     return null;

    // }

    // @Override
    // public List<DiversityClassification> getAllClassifications(){
    //      return dcr.findAll();
    // }

    // @Override
    // public DiversityClassification getById(Long id){
    //      return dcr.findById(id).orElse(null);
    // }

    // @Override
    // public void deactivateClassification(Long id){
    //    DiversityClassification dc=dcr.findById(id).orElse(null);
    //    if(dc!=null){
    //     dc.setActive(false);
    //     dcr.save(dc);
    //    }
    // }
// }

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
        if(respository.existsById(id)){
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