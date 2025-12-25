package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class DiversityClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private String description;

    private Boolean active = true;

    @ManyToMany(mappedBy = "dc")
    @JsonIgnoreProperties("dc") // prevents recursion
    private List<Supplier> supplier;

    @OneToMany(mappedBy = "dc", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("dc")
    private List<DiversityTarget> dt;

    public DiversityClassification() {}

    public DiversityClassification(Long id, String code, String description, Boolean active) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public List<Supplier> getSupplier() { return supplier; }
    public void setSupplier(List<Supplier> supplier) { this.supplier = supplier; }

    public List<DiversityTarget> getDt() { return dt; }
    public void setDt(List<DiversityTarget> dt) { this.dt = dt; }
}


