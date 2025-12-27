// package com.example.demo.service;

// import java.util.List;

// import com.example.demo.entity.Supplier;

// public interface SupplierService {
//     Supplier createSupplier(Supplier supplier);
//     Supplier updateSupplier(Long id,Supplier supplier);
//     Supplier getSupplierById(Long id);
//     List<Supplier>getAllSuppliers();
//     void deactivateSupplier(Long id);
// }

package com.example.demo.service;

import com.example.demo.entity.Supplier;
import java.util.List;

public interface SupplierService {
    Supplier createSupplier(Supplier supplier);
    Supplier getSupplierById(Long id);
    List<Supplier> getAllSuppliers();
    void deactivateSupplier(Long id);
    Supplier updateSupplier(Long id,Supplier supplier)
}