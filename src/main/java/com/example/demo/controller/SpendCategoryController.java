// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.SpendCategory;
// import com.example.demo.service.SpendCategoryService;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;


// @RestController
// public class SpendCategoryController {
//     private final SpendCategoryService scs;
//     public SpendCategoryController(SpendCategoryService scs){
//         this.scs=scs;
//     }

//    @PostMapping("/POST/categories")
//    public SpendCategory postSpend(@RequestBody SpendCategory category){
//       return scs.createCategory(category);
//    }

//     @PutMapping("/PUT/categories/{id}")
//     public SpendCategory updateSpendCategory(@PathVariable Long id,@RequestBody SpendCategory category){
//        return scs.updateCategory(id,category);
//     }

//     @GetMapping("/GET/categories/{id}")
//     public SpendCategory getSpendCategoryById(@PathVariable Long id){
//         return scs.getCategoryById(id);
//     }

//     @GetMapping("/GET/categories")
//     public List<SpendCategory> getAllSpendCategories(){
//         return scs.getAllCategories();
//     }

    
// }

package com.example.demo.controller;

import com.example.demo.service.SpendCategoryService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/spendcategory")
public class SpendCategoryController {
    private final SpendCategoryService service;
    
    public SpendCategoryController(SpendCategoryService service) {
        this.service = service;
    }

    
    @PostMapping("/POST/categories")
    public SpendCategory postSpend(@RequestBody SpendCategory category){
      return service.createCategory(category);
    }

    @PutMapping("/PUT/categories/{id}")
    public SpendCategory updateSpendCategory(@PathVariable Long id,@RequestBody SpendCategory category){
       return service.updateCategory(id,category);
    }

    @GetMapping("/GET/categories/{id}")
    public SpendCategory getSpendCategoryById(@PathVariable Long id){
        return service.getCategoryById(id);
    }

    @GetMapping("/GET/categories")
    public List<SpendCategory> getAllSpendCategories(){
        return service.getAllCategories();
    }

    @PutMapping("/PUT/categories/{id}/deactivate")
    public void deactivateCategoryByID
}







