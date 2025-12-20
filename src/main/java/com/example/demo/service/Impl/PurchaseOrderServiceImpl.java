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

    // @Override
    // public List<PurchaseOrder>getPurchaseOrdersBySupplier(Long supplierId){
    //       return por.findBySupplierIdContaining(supplierId);
    // }
}
