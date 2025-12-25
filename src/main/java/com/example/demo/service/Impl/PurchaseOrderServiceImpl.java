// package com.example.demo.service.Impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.entity.PurchaseOrder;
// import com.example.demo.repository.PurchaseOrderRepository;
// import com.example.demo.service.PurchaseOrderService;
// import com.example.demo.exception.BadRequestException;
// import java.math.BigDecimal;

// @Service
// public class PurchaseOrderServiceImpl implements PurchaseOrderService{
//     private final PurchaseOrderRepository por;
//     public PurchaseOrderServiceImpl(PurchaseOrderRepository por){
//         this.por=por;
//     }

//     @Override
//     public PurchaseOrder createPurchaseOrder(PurchaseOrder po){
//         if(po.getAmount().compareTo(BigDecimal.ZERO)<=0){
//             throw new BadRequestException("Purchase amount must be greater than 0");
//         }
//         return por.save(po);
//     }

//     @Override
//     public PurchaseOrder updatePurchaseOrder(Long id,PurchaseOrder po){
//         if(por.existsById(id)){
//             po.setId(id);
//             return por.save(po);
//         }
//         return null;
//     }

//     @Override
//     public PurchaseOrder getPurchaseOrderByID(Long id){
//          return por.findById(id).orElse(null);
//     }

//     @Override
//     public List<PurchaseOrder>getAllPurchaseOrders(){
//           return por.findAll();
//     }

//     @Override
//     public List<PurchaseOrder>getPurchaseOrdersBySupplier(Long supplierId){
//           return por.findBySupplier_Id(supplierId);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.entity.Supplier;
import com.example.demo.entity.SpendCategory;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final SupplierRepository supplierRepository;
    private final SpendCategoryRepository spendCategoryRepository;
    
    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository,
                                   SupplierRepository supplierRepository,
                                   SpendCategoryRepository spendCategoryRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.supplierRepository = supplierRepository;
        this.spendCategoryRepository = spendCategoryRepository;
    }
    
    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        if (purchaseOrder.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be positive");
        }
        
        Supplier supplier = supplierRepository.findById(purchaseOrder.getSupplier().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        
        if (!supplier.getIsActive()) {
            throw new BadRequestException("Supplier is not active");
        }
        
        SpendCategory category = spendCategoryRepository.findById(purchaseOrder.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        
        if (!category.getActive()) {
            throw new BadRequestException("Category is not active");
        }
        
        return purchaseOrderRepository.save(purchaseOrder);
    }
    
    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return purchaseOrderRepository.findBySupplier_Id(supplierId);
    }
}