package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;
    
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/POST/suppliers")
    public Supplier postSupplier(@RequestBody Supplier supplier){
          return supplierService.createSupplier(supplier);
    }

    @PutMapping("/PUT/suppliers/{id}")
    public Supplier updateValue(@PathVariable Long id,@RequestBody Supplier supplier){
        return supplierService.updateSupplier(id,supplier);
    }

    @GetMapping("/GET/suppliers/{id}")
    public Supplier retrieveSupplierById(@PathVariable Long id){
       return supplierService.getSupplierById(id);
    }

    @GetMapping("/GET/suppliers")
    public List<Supplier> retrieveSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @PutMapping("/PUT/suppliers/{id}/deactivate")
    public void deactivateById(@PathVariable Long id){
        supplierService.deactivateSupplier(id);
    }
}