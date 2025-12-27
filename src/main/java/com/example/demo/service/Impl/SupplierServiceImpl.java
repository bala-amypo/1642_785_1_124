// package com.example.demo.service.Impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.entity.Supplier;
// import com.example.demo.repository.SupplierRepository;
// import com.example.demo.service.SupplierService;

// @Service
// public class SupplierServiceImpl implements SupplierService{
//     private final SupplierRepository sr;
//     public SupplierServiceImpl(SupplierRepository sr){
//         this.sr=sr;
//     }
//     @Override
//     public Supplier createSupplier(Supplier supplier){
//         return sr.save(supplier);
//     }

    // @Override
    // public Supplier updateSupplier(Long id,Supplier supplier){
    //     if(sr.existsById(id)){
    //         supplier.setId(id);
    //         return sr.save(supplier);
    //     }
    //     return null;
    // }

//     @Override
//     public Supplier getSupplierById(Long id){
//         return sr.findById(id).orElse(null);
//     }

//     @Override
//     public List<Supplier>getAllSuppliers(){
//         return sr.findAll();
//     }

//     @Override
//     public void deactivateSupplier(Long id){
//       Supplier supplier=sr.findById(id).orElse(null);
//       if(supplier!=null){
//         supplier.setIsActive(false);
//         sr.save(supplier);
//       }
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    
    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    
    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
    }
    
    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    
    @Override
    public void deactivateSupplier(Long id) {
        Supplier supplier = getSupplierById(id);
        supplier.setIsActive(false);
        supplierRepository.save(supplier);
    }

    @Override
    public Supplier updateSupplier(Long id,Supplier supplier){
        if(supplierRepository.existsById(id)){
            supplier.setId(id);
            return supplierRepository.save(supplier);
        }
        return null;
    }
}