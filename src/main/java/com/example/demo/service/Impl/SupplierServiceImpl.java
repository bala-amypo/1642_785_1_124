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