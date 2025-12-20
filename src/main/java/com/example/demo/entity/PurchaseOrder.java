package com.example.demo.entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class PurchaseOrder {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String poNumber;

    @Positive
    private BigDecimal amount;

    @PastOrPresent
    private LocalDate dateIssued;

    private String approvedBy;

    private String notes;

    @OneToOne
    @JoinColumn(name="supplier_Pur",nullable=true)
    private Supplier supplier;

    @OneToOne
    @JoinColumn(name="category_pur",nullable=true)
    private SpendCategory category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public SpendCategory getCategory() {
        return category;
    }

    public void setCategory(SpendCategory category) {
        this.category = category;
    }

    public PurchaseOrder(Long id, String poNumber, @Positive BigDecimal amount, @PastOrPresent LocalDate dateIssued,
            String approvedBy, String notes, Supplier supplier, SpendCategory category) {
        this.id = id;
        this.poNumber = poNumber;
        this.amount = amount;
        this.dateIssued = dateIssued;
        this.approvedBy = approvedBy;
        this.notes = notes;
        this.supplier = supplier;
        this.category = category;
    }

    public PurchaseOrder() {
    }
     
    

    
}
