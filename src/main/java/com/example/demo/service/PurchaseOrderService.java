// package com.example.demo.service;

// import java.util.List;

// import com.example.demo.entity.PurchaseOrder;

// public interface PurchaseOrderService {
//     PurchaseOrder createPurchaseOrder(PurchaseOrder po);
//     PurchaseOrder updatePurchaseOrder(Long id,PurchaseOrder po);
//     PurchaseOrder getPurchaseOrderByID(Long id);
//     List<PurchaseOrder>getAllPurchaseOrders();
//     List<PurchaseOrder>getPurchaseOrdersBySupplier(Long supplierId);
// }

package com.example.demo.service;

import com.example.demo.entity.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder);
    List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId);
    PurchaseOrder createPurchaseOrder(PurchaseOrder po);
    PurchaseOrder updatePurchaseOrder(Long id,PurchaseOrder po);
    PurchaseOrder getPurchaseOrderByID(Long id);
}