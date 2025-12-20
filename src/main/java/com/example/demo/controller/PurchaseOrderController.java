package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;

@RestController
public class PurchaseOrderController {
    private final PurchaseOrderService pos;
    public PurchaseOrderController(PurchaseOrderService pos){
        this.pos=pos;
    }
    
    @PostMapping("/POST/purchase-orders")
    public PurchaseOrder createPurchaseeOrder(PurchaseOrder po){
        return pos.createPurchaseOrder(po);
    }

    
    @PutMapping("/PUT/purchase-orders/{id}")
    public PurchaseOrder updatePurchaseeOrder(Long id,PurchaseOrder po){
          return pos.updatePurchaseOrder(id, po);
    }

    @GetMapping("/GET/purchase-orders/{id}")
    public PurchaseOrder getPurchaseeOrderByID(Long id){
         return pos.getPurchaseOrderByID(id);
    }

    @GetMapping("/GET/purchase-orders")
    public List<PurchaseOrder>getAllPurchaseeOrders(){
         return pos.getAllPurchaseOrders();
    }

    @GetMapping("/GET/supplierId")
    public List<PurchaseOrder>getPurchaseeOrdersBySupplier(Long supplierId){
        return pos.getPurchaseOrdersBySupplier(supplierId);
    }
}












PurchaseOrderImpl.java:
package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{
    private final PurchaseOrderRepository por;
    public PurchaseOrderServiceImpl(PurchaseOrderRepository por){
        this.por=por;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po){
        return por.save(po);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Long id,PurchaseOrder po){
        if(por.existsById(id)){
            po.setId(id);
            return por.save(po);
        }
        return null;
    }

    @Override
    public PurchaseOrder getPurchaseOrderByID(Long id){
         return por.findById(id).orElse(null);
    }

    @Override
    public List<PurchaseOrder>getAllPurchaseOrders(){
          return por.findAll();
    }

    @Override
    public List<PurchaseOrder>getPurchaseOrdersBySupplier(Long supplierId){
          return por.findBySupplierIdContaining(supplierId);
    }
}


PurchaseOrdewrService.java
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PurchaseOrder;

public interface PurchaseOrderService {
    PurchaseOrder createPurchaseOrder(PurchaseOrder po);
    PurchaseOrder updatePurchaseOrder(Long id,PurchaseOrder po);
    PurchaseOrder getPurchaseOrderByID(Long id);
    List<PurchaseOrder>getAllPurchaseOrders();
    List<PurchaseOrder>getPurchaseOrdersBySupplier(Long supplierId);
}