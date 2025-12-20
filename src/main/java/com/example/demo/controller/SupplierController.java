// package com.example.demo.controller;

// public class SupplierController{
    
// }



package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;

@RestController
public class SupplierController {
    private final SupplierService ss;
    public SupplierController(SupplierService ss){
        this.ss=ss;
    }

    @PostMapping("/POST/suppliers")
    public Supplier postSupplier(@RequestBody Supplier supplier){
          return ss.createSupplier(supplier);
    }

    @PutMapping("/PUT/suppliers/{id}")
    public Supplier updateValue(@PathVariable Long id,@RequestBody Suppplier supplier){
        return ss.updateSupplier(id,supplier);
    }

    @GetMapping("/GET/suppliers/{id}")
    public Supplier retrieveSupplierById(Long id){
       return ss.getSupplierById(id);
    }

    @GetMapping("/GET/suppliers")
    public List<Supplier> retrieveSuppliers(){
        return ss.getAllSuppliers();
    }

    @PutMapping("/PUT/suppliers/{id}/deactivate")
    public void deactivateById(Long id){
        ss.deactivateSupplier(id);
    }
}
