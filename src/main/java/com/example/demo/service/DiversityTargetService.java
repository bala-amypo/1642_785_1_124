// package com.example.demo.service;

// import java.util.List;

// import com.example.demo.entity.DiversityTarget;

// public interface DiversityTargetService {
//     DiversityTarget createTarget(DiversityTarget target);
//     DiversityTarget updateTarget(Long id,DiversityTarget target);
//     List<DiversityTarget> getTargetsByYear(Integer year);
//     List<DiversityTarget> getAllTargets();
//     void deactivateTarget(Long id);
    
// }

package com.example.demo.service;

import com.example.demo.entity.DiversityTarget;
import java.util.List;

public interface DiversityTargetService {
    DiversityTarget createTarget(DiversityTarget target);
    List<DiversityTarget> getTargetsByYear(Integer year);
    List<DiversityTarget> getAllTargets();
    void deactivateTarget(Long id);
}

