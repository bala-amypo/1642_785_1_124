// package com.example.demo.service.Impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.entity.SpendCategory;
// import com.example.demo.repository.SpendCategoryRepository;
// import com.example.demo.service.SpendCategoryService;

// @Service
// public class SpendCategoryServiceImpl implements SpendCategoryService{
//     private final SpendCategoryRepository scr;
//     public SpendCategoryServiceImpl(SpendCategoryRepository scr){
//         this.scr=scr;
//     }
//     @Override
//     public SpendCategory createCategory(SpendCategory category){
//         return scr.save(category);
//     }

//      @Override
//     public SpendCategory updateCategory(Long id,SpendCategory category){
//         if(scr.existsById(id)){
//             category.setId(id);
//             return scr.save(category);
//         }
//         return null;
//     }

//     @Override
//     public SpendCategory getCategoryById(Long id){
//          return scr.findById(id).orElse(null);
//     }

//     @Override
//     public List<SpendCategory> getAllCategories(){
//          return scr.findAll();
//     }

//     @Override
//     public void deactivateCategory(Long id){
//         SpendCategory sc=scr.findById(id).orElse(null);
//         if(sc!=null){
//             sc.setActive(false);
//         }
//     }

// }


