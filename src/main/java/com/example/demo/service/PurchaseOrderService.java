package com.example.demo.service;

import com.example.demo.entity.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder);
    List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId);
    PurchaseOrder updatePurchaseOrder(Long id,PurchaseOrder po);
    PurchaseOrder getPurchaseOrderByID(Long id);
    List<PurchaseOrder>getAllPurchaseOrders();
}