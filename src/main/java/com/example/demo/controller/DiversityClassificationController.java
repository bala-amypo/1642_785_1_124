// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.DiversityClassification;
// import com.example.demo.service.DiversityClassificationService;

// import org.springframework.web.bind.annotation.RequestBody;


// @RestController
// public class DiversityClassificationController {
//     private final DiversityClassificationService dcs;
//     public DiversityClassificationController(DiversityClassificationService dcs){
//         this.dcs=dcs;
//     }

//     @PostMapping("/POST/classifications")
//     public DiversityClassification postClassification(@RequestBody DiversityClassification c){
//           return dcs.createClassification(c);
//     }

//     @PutMapping("/PUT/classifications/{id}")
//     public DiversityClassification updateValue(@PathVariable Long id,@RequestBody DiversityClassification c){
//         return dcs.updateClassification(id,c);
//     }

//     @GetMapping("/GET/classifications/{id}")
//     public DiversityClassification retrieveDiversityById(@PathVariable Long id){
//        return dcs.getById(id);
//     }

//     @GetMapping("/GET/classifications")
//     public List<DiversityClassification> retrieveDiversities(){
//         return dcs.getAllClassifications();
//     }

//     @PutMapping("/PUT/classifications/{id}/deactivate")
//     public void deactivateClassificationById(@PathVariable Long id){
//         dcs.deactivateClassification(id);
//     }
// }

// package com.example.demo.controller;

// import com.example.demo.service.DiversityClassificationService;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// @RestController
// @RequestMapping("/diversityclassification")
// public class DiversityClassificationController {
//     private final DiversityClassificationService service;
    
//     public DiversityClassificationController(DiversityClassificationService service) {
//         this.service = service;
//     }
// }

package com.example.demo.controller;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diversityclassification")
public class DiversityClassificationController {

    private final DiversityClassificationService service;

    public DiversityClassificationController(DiversityClassificationService service) {
        this.service = service;
    }

    @PostMapping
    public DiversityClassification create(@RequestBody DiversityClassification obj) {
        return service.save(obj);
    }

    @GetMapping
    public List<DiversityClassification> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DiversityClassification getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public DiversityClassification update(@PathVariable Long id,
                                          @RequestBody DiversityClassification obj) {
        return service.update(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
