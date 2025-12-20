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
    public PurchaseOrder createPurchaseeOrder(@RequestBody PurchaseOrder po){
        return pos.createPurchaseOrder(po);
    }

    
    @PutMapping("/PUT/purchase-orders/{id}")
    public PurchaseOrder updatePurchaseeOrder(@PathVariable Long id,@RequestBody PurchaseOrder po){
          return pos.updatePurchaseOrder(id, po);
    }

    @GetMapping("/GET/purchase-orders/{id}")
    public PurchaseOrder getPurchaseeOrderByID(@PathVariable Long id){
         return pos.getPurchaseOrderByID(id);
    }

    @GetMapping("/GET/purchase-orders")
    public List<PurchaseOrder>getAllPurchaseeOrders(){
         return pos.getAllPurchaseOrders();
    }

    @GetMapping("/GET/{supplierId}")
    public List<PurchaseOrder>getPurchaseeOrdersBySupplier(Long supplierId){
        return pos.getPurchaseOrdersBySupplier(supplierId);
    }
}














