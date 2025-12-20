// package com.example.demo.controller;

// public class SupplierController{
    
// }





SupplierServiceImpl.java
package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{
    private final SupplierRepository sr;
    public SupplierServiceImpl(SupplierRepository sr){
        this.sr=sr;
    }
    @Override
    public Supplier createSupplier(Supplier supplier){
        return sr.save(supplier);
    }

    @Override
    public Supplier updateSupplier(Long id,Supplier supplier){
        if(sr.existsById(id)){
            supplier.setId(id);
            return sr.save(supplier);
        }
        return null;
    }

    @Override
    public Supplier getSupplierById(Long id){
        return sr.findById(id).orElse(null);
    }

    @Override
    public List<Supplier>getAllSuppliers(){
        return sr.findAll();
    }

    @Override
    public void deactivateSupplier(Long id){
      Supplier supplier=sr.findById(id).orElse(null);
      if(supplier!=null){
        supplier.setIsActive(false);
        sr.save(supplier);
      }
    }
}
____________________________________________________________________________________________________________
SupplierController.java
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
____________________________________________________________________________________________________________
Supplier.java
package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;
    @NotNull
    @Column(unique=true)
    private String registrationNumber;
      @Column(unique=true)
      @Email
    private String email;
    private String phone;
    private String address;
    Boolean isActive=true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate(){
        LocalDateTime now=LocalDateTime.now();
        if(createdAt==null){
            this.createdAt=now;
        }
        this.updatedAt=now;
    }

    @PreUpdate
    public void onUpdate(){
        LocalDateTime now=LocalDateTime.now();
        this.updatedAt=now;
    }
    // public Long getId() {
    //     return id;
    // }
    // public void setId(Long id) {
    //     this.id = id;
    // }
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public String getRegistrationNumber() {
    //     return registrationNumber;
    // }
    // public void setRegistrationNumber(String registrationNumber) {
    //     this.registrationNumber = registrationNumber;
    // }
    // public String getEmail() {
    //     return email;
    // }
    // public void setEmail(String email) {
    //     this.email = email;
    // }
    // public String getPhone() {
    //     return phone;
    // }
    // public void setPhone(String phone) {
    //     this.phone = phone;
    // }
    // public String getAddress() {
    //     return address;
    // }
    // public void setAddress(String address) {
    //     this.address = address;
    // }
    // public boolean getIsActive() {
    //     return isActive;
    // }
    // public void setIsActive(boolean isActive) {
    //     this.isActive = isActive;
    // }
    // public Supplier() {
    // }
    // public Supplier(Long id, String name, @NotNull String registrationNumber, @Email String email, String phone,
    //         String address, Boolean isActive) {
    //     this.id = id;
    //     this.name = name;
    //     this.registrationNumber = registrationNumber;
    //     this.email = email;
    //     this.phone = phone;
    //     this.address = address;
    //     this.isActive = isActive;
    // }
    
    
}
____________________________________________________________________________________________________________
SupplierService.java
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Supplier;

public interface SupplierService {
    Supplier createSupplier(Supplier supplier);
    Supplier updateSupplier(Long id,Supplier supplier);
    Supplier getSupplierById(Long id);
    List<Supplier>getAllSuppliers();
    void deactivateSupplier(Long id);
}
