// package com.example.demo.service.Impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.entity.DiversityTarget;
// import com.example.demo.repository.DiversityTargetRepository;
// import com.example.demo.service.DiversityTargetService;

// @Service
// public class DiversityTargetServiceImpl implements DiversityTargetService{
//     private final DiversityTargetRepository dtr;
//     public DiversityTargetServiceImpl(DiversityTargetRepository dtr){
//             this.dtr=dtr;
//     }
      
//     @Override
//     public DiversityTarget createTarget(DiversityTarget target){
//         return dtr.save(target);
//     }

//     @Override
//     public DiversityTarget updateTarget(Long id,DiversityTarget target){
//         if(dtr.existsById(id)){
//             target.setId(id);
//             return dtr.save(target);
//         }
//         return null;
//     }
     
//     @Override
//     public List<DiversityTarget> getTargetsByYear(Integer year){
//          return dtr.findByYear(year);
//     }

//     @Override
//     public List<DiversityTarget> getAllTargets(){
//          return dtr.findAll();
//     }

//     @Override
//     public void deactivateTarget(Long id){
         
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {
    private final DiversityTargetRepository repository;
    
    public DiversityTargetServiceImpl(DiversityTargetRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return repository.save(target);
    }
    
    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return repository.findByTargetYear(year);
    }
    
    @Override
    public List<DiversityTarget> getAllTargets() {
        return repository.findAll();
    }
    
    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Target not found"));
        target.setActive(false);
        repository.save(target);
    }
}