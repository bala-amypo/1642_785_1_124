// package com.example.demo.entity;
// import java.math.BigDecimal;
// import java.time.LocalDate;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.validation.constraints.PastOrPresent;
// import jakarta.validation.constraints.Positive;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.JoinColumn; 
// import jakarta.validation.constraints.NotNull;
// import jakarta.persistence.ManyToOne;

// @Entity
// public class PurchaseOrder {
//      @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique=true,nullable=true)
//     private String poNumber;

//     // @Positive(message="Amount must be greater than zero")
//     @NotNull
//     private BigDecimal amount;

//     @NotNull
//     @PastOrPresent
//     private LocalDate dateIssued;

//     @NotNull
//     private String approvedBy;

//     @NotNull
//     private String notes;

//     @ManyToOne
//     @JoinColumn(name="supplier_id")
//     private Supplier supplier;


//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getPoNumber() {
//         return poNumber;
//     }

//     public void setPoNumber(String poNumber) {
//         this.poNumber = poNumber;
//     }

//     public BigDecimal getAmount() {
//         return amount;
//     }

//     public void setAmount(BigDecimal amount) {
//         this.amount = amount;
//     }

//     public LocalDate getDateIssued() {
//         return dateIssued;
//     }

//     public void setDateIssued(LocalDate dateIssued) {
//         this.dateIssued = dateIssued;
//     }

//     public String getApprovedBy() {
//         return approvedBy;
//     }

//     public void setApprovedBy(String approvedBy) {
//         this.approvedBy = approvedBy;
//     }

//     public String getNotes() {
//         return notes;
//     }

//     public void setNotes(String notes) {
//         this.notes = notes;
//     }

//     public PurchaseOrder(Long id, String poNumber, @Positive BigDecimal amount, @PastOrPresent LocalDate dateIssued,
//             String approvedBy, String notes) {
//         this.id = id;
//         this.poNumber = poNumber;
//         this.amount = amount;
//         this.dateIssued = dateIssued;
//         this.approvedBy = approvedBy;
//         this.notes = notes;
//     }

//     public PurchaseOrder() {
//     }
     
    

    
// }

package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String poNumber;
    private BigDecimal amount;
    private LocalDate dateIssued;
    private String notes;
    
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private SpendCategory category;
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }
    
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    
    public LocalDate getDateIssued() { return dateIssued; }
    public void setDateIssued(LocalDate dateIssued) { this.dateIssued = dateIssued; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    
    public SpendCategory getCategory() { return category; }
    public void setCategory(SpendCategory category) { this.category = category; }
}
