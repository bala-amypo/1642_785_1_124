// package com.example.demo.service;

// import java.util.List;

// import com.example.demo.entity.SpendCategory;

// public interface SpendCategoryService {
//     SpendCategory createCategory(SpendCategory category);
//     SpendCategory updateCategory(Long id,SpendCategory category);
//     SpendCategory getCategoryById(Long id);
//     List<SpendCategory> getAllCategories();
//     void deactivateCategory(Long id);
// }

package com.example.demo.service;

import com.example.demo.entity.SpendCategory;
import java.util.List;

public interface SpendCategoryService {
    List<SpendCategory> getAllCategories();
    void deactivateCategory(Long id);
    SpendCategory createCategory(SpendCategory category);
    SpendCategory updateCategory(Long id,SpendCategory category);
    SpendCategory getCategoryById(Long id);
}