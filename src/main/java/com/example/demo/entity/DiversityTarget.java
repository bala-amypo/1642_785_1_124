package com.example.demo.entity;

import jakarta.persistence.*;
// import jakarta.validation.constraints.DecimalMax;
// import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class DiversityTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int year;

    @NotNull
    // @DecimalMin("0.00")
    // @DecimalMax("100.00")
    private Double targetPercentage;

    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    @JsonIgnoreProperties("dt")
    private DiversityClassification dc;

    public DiversityTarget() {}

    public DiversityTarget(Long id, int year, Double targetPercentage, Boolean active) {
        this.id = id;
        this.year = year;
        this.targetPercentage = targetPercentage;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public Double getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(Double targetPercentage) { this.targetPercentage = targetPercentage; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public DiversityClassification getDc() { return dc; }
    public void setDc(DiversityClassification dc) { this.dc = dc; }
}





