
// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.Min;

// @Entity
// public class DiversityTarget {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;

//     private int targetYear;
    
//     @Min(0)
//     @Max(100)
//     private Double targetPercentage;
    
//     Boolean active=true;

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public int getTargetYear() {
//         return targetYear;
//     }

//     public void setTargetYear(int targetYear) {
//         this.targetYear = targetYear;
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

//     public DiversityTarget(Long id, int targetYear, @Min(0) @Max(100) Double targetPercentage, Boolean active) {
//         this.id = id;
//         this.targetYear = targetYear;
//         this.targetPercentage = targetPercentage;
//         this.active = active;
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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class DiversityTarget {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private int Year;
    
    @Min(0)
    @Max(100)
    private Double targetPercentage;
    
    Boolean active=true;
    
    @OneToOne
    @JoinColumn(name="classificationn",unique=true)
    DiversityClassification classfication;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTargetYear() {
        return targetYear;
    }

    public void setTargetYear(int targetYear) {
        this.targetYear = targetYear;
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

    public DiversityClassification getClassfication() {
        return classfication;
    }

    public void setClassfication(DiversityClassification classfication) {
        this.classfication = classfication;
    }

    public DiversityTarget(Long id, int targetYear, @Min(0) @Max(100) Double targetPercentage, Boolean active,
            DiversityClassification classfication) {
        this.id = id;
        this.targetYear = targetYear;
        this.targetPercentage = targetPercentage;
        this.active = active;
        this.classfication = classfication;
    }

    public DiversityTarget() {
    }
}


