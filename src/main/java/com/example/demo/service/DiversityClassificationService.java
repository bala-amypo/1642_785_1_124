// package com.example.demo.service;

// import java.util.List;

// import com.example.demo.entity.DiversityClassification;

// public interface DiversityClassificationService{
//     DiversityClassification createClassification(DiversityClassification c);
//     DiversityClassification updateClassification(Long id,DiversityClassification c);
//     List<DiversityClassification> getAllClassifications();
//     DiversityClassification getById(Long id);
//     void deactivateClassification(Long id);
// }

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