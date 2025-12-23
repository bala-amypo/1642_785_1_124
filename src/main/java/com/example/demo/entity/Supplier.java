// package com.example.demo.entity;

// import java.time.LocalDateTime;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.PreUpdate;
// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotNull;

// @Entity
// public class Supplier {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique=true,nullable=true)
//     private String name;

//     @Column(unique=true,nullable=true)
//     private String registrationNumber;

//     @Column(unique=true)
//     @Email
//     private String email;

//     @NotNull
//     private String phone;

//     @NotNull
//     private String address;

//     Boolean isActive=true;

//     private LocalDateTime createdAt;
//     private LocalDateTime updatedAt;

//     @PrePersist
//     public void onCreate(){
//         LocalDateTime now=LocalDateTime.now();
//         if(createdAt==null){
//             this.createdAt=now;
//         }
//         this.updatedAt=now;
//     }

//     @PreUpdate
//     public void onUpdate(){
//         LocalDateTime now=LocalDateTime.now();
//         this.updatedAt=now;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getRegistrationNumber() {
//         return registrationNumber;
//     }

//     public void setRegistrationNumber(String registrationNumber) {
//         this.registrationNumber = registrationNumber;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getPhone() {
//         return phone;
//     }

//     public void setPhone(String phone) {
//         this.phone = phone;
//     }

//     public String getAddress() {
//         return address;
//     }

//     public void setAddress(String address) {
//         this.address = address;
//     }

//     public Boolean getIsActive() {
//         return isActive;
//     }

//     public void setIsActive(Boolean isActive) {
//         this.isActive = isActive;
//     }

//     public LocalDateTime getCreatedAt() {
//         return createdAt;
//     }

//     public void setCreatedAt(LocalDateTime createdAt) {
//         this.createdAt = createdAt;
//     }

//     public LocalDateTime getUpdatedAt() {
//         return updatedAt;
//     }

//     public void setUpdatedAt(LocalDateTime updatedAt) {
//         this.updatedAt = updatedAt;
//     }

//     public Supplier(Long id, String name, @NotNull String registrationNumber, @Email String email, String phone,
//             String address, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
//         this.id = id;
//         this.name = name;
//         this.registrationNumber = registrationNumber;
//         this.email = email;
//         this.phone = phone;
//         this.address = address;
//         this.isActive = isActive;
//         this.createdAt = createdAt;
//         this.updatedAt = updatedAt;
//     }

//     public Supplier() {
//     }
    
    
// }

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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import java.util.List;


@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true,nullable=true)
    private String name;

    @Column(unique=true,nullable=true)
    private String registrationNumber;

    @Column(unique=true)
    @Email
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String address;

    Boolean isActive=true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name="Supplier_DiversityClassification",
    joinColumns=@JoinColumn(name="supplier_id"),
    inverseJoinColumns=@JoinColumn(name="diversity_id")
    )
    private List<DiversityClassification> dc;

    public List<DiversityClassification> getDc() {
        return dc;
    }

    public void setDc(List<DiversityClassification> dc) {
        this.dc = dc;
    }

    @OneToMany(mappedBy="sup",cascade=CascadeType.ALL)
    private List<PurchaseOrder> sup

    

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Supplier(Long id, String name, @NotNull String registrationNumber, @Email String email, String phone,
            String address, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Supplier() {
    }
    
    
}

