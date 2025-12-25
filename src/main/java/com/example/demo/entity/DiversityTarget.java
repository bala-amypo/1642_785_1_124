// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.ManyToOne;
// import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotNull;

// @Entity
// public class DiversityTarget {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;

//     @NotNull
//     private int year;
    
//     @Min(0)
//     @Max(100)
//     @NotNull
//     private Double targetPercentage;
    
//     Boolean active=true;
    
//     @OneToOne
//     @JoinColumn(name="classificationn",unique=true)
//     DiversityClassification classification;

//     // @ManyToOne
//     // @JoinColumn(name="Diversity_Classification")
//     // private DiversityClassification dc;
    
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public int getTargetYear() {
//         return year;
//     }

//     public void setTargetYear(int year) {
//         this.year = year;
//     }

//     public Double getTargetPercentage() {
//         return targetPercentage;
//     }

//     public void setTargetPercentage(Double targetPercentage) {
//         this.targetPercentage = targetPercentage;
//     }

//     public Boolean getActive() {
//         return active;
//     }

//     public void setActive(Boolean active) {
//         this.active = active;
//     }

//     public DiversityClassification getClassfication() {
//         return classification;
//     }

//     public void setClassfication(DiversityClassification classification) {
//         this.classification = classification;
//     }

//     public DiversityTarget(Long id, int year, @Min(0) @Max(100) Double targetPercentage, Boolean active,
//             DiversityClassification classification) {
//         this.id = id;
//         this.year = year;
//         this.targetPercentage = targetPercentage;
//         this.active = active;
//         this.classification = classification;
//     }

//     public DiversityTarget() {
//     }
// }


package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
public class DiversityTarget {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int year;
    
    @DecimalMin(0.00)
    @DecimalMax(100.00)
    @NotNull
    private Double targetPercentage;
    
    Boolean active=true;

    @ManyToOne
    @JoinColumn(name="classification_id")
    private DiversityClassification dc;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTargetYear() {
        return year;
    }

    public void setTargetYear(int year) {
        this.year = year;
    }

    public Double getTargetPercentage() {
        return targetPercentage;
    }

    public void setTargetPercentage(Double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public DiversityTarget(Long id, int year, @Min(0) @Max(100) Double targetPercentage, Boolean active) {
        this.id = id;
        this.year = year;
        this.targetPercentage = targetPercentage;
        this.active = active;
    }

    public DiversityTarget() {
    }
}




