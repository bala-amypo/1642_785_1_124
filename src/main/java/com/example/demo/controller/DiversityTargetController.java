package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.service.DiversityTargetService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class DiversityTargetController {
    private final DiversityTargetService dts;
    public DiversityTargetController(DiversityTargetService dts){
        this.dts=dts;
    }
    @PostMapping("/POST/targets")
    public DiversityTarget createDiversityTarget(@RequestBody DiversityTarget target){
        return dts.createTarget(target);
    }
 
    @PutMapping("/PUT/targets/{id}")
    public DiversityTarget updateDiversityTarget(@PathVariable Long id,@RequestBody DiversityTarget target){
         return dts.updateTarget(id,target);
    }

    @GetMapping("/GET/targets/years/{year}")
    public List<DiversityTarget> getDiversityTargetsByYear(@PathVariable Integer year){
        return dts.getTargetsByYear(year);
    }

    @GetMapping("/GET/targets")
    public List<DiversityTarget> getAllDiversityTargets(){
        return dts.getAllTargets();
    }

    @PutMapping("/PUT/targets/{id}/deactivate")
    public void deactivateDiversityTarget(Long id){
        dts.deactivateTarget(id);
    }
    
}












DiversityTargetService:
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.DiversityTarget;

public interface DiversityTargetService {
    DiversityTarget createTarget(DiversityTarget target);
    DiversityTarget updateTarget(Long id,DiversityTarget target);
    List<DiversityTarget> getTargetsByYear(Integer year);
    List<DiversityTarget> getAllTargets();
    void deactivateTarget(Long id);
    
}