
package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SpendCategory;
import com.example.demo.service.SpendCategoryService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SpendCategoryController {
    private final SpendCategoryService scs;
    public SpendCategoryController(SpendCategoryService scs){
        this.scs=scs;
    }

   @PostMapping("/POST/categories")
   public SpendCategory postSpend(@RequestBody SpendCategory category){
      return scs.createCategory(category);
   }

    @PutMapping("/PUT/categories")
    public SpendCategory updateSpendCategory(@PathVariable Long id,@RequestBody SpendCategory category){
       return scs.updateCategory(id,category);
    }

    @GetMapping("/GET/categories/{id}")
    public SpendCategory getSpendCategoryById(@PathVariable Long id){
        return scs.getCategoryById(id);
    }

    @GetMapping("/GET/categories")
    public List<SpendCategory> getAllSpendCategories(){
        return scs.getAllCategories();
    }

    
}









