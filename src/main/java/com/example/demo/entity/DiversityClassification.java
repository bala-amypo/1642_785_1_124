// package com.example.demo.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.validation.constraints.NotNull;

// @Entity
// public class DiversityClassification {
//      @Id
//      @GeneratedValue(strategy = GenerationType.IDENTITY)
//      private Long id;

//      @NotNull
//      @Column(unique=true)
//      private String code;

//      @NotNull
//      private String description;

//      Boolean active=true;
     
//      public Long getId() {
//          return id;
//      }
//      public void setId(Long id) {
//          this.id = id;
//      }
//      public String getCode() {
//          return code;
//      }
//      public void setCode(String code) {
//          this.code = code;
//      }
//      public String getDescription() {
//          return description;
//      }
//      public void setDescription(String description) {
//          this.description = description;
//      }
//      public Boolean getActive() {
//          return active;
//      }
//      public void setActive(Boolean active) {
//          this.active = active;
//      }
//      public DiversityClassification(Long id, String code, String description, Boolean active) {
//         this.id = id;
//         this.code = code;
//         this.description = description;
//         this.active = active;
//      }
//      public DiversityClassification() {
//      }
     
     
// }

// package com.example.demo.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.validation.constraints.NotNull;
// import jakarta.persistence.ManyToMany;
// import java.util.List;
// import com.fasterxml.jackson.annotation.JsonIgnore;
// import jakarta.persistence.CascadeType;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


// @Entity
// public class DiversityClassification {
//      @Id
//      @GeneratedValue(strategy = GenerationType.IDENTITY)
//      private Long id;

//      @NotNull
//      @Column(unique=true)
//      private String code;

//      @NotNull
//      private String description;

//      Boolean active=true;
     
//      @ManyToMany(mappedBy="dc")
//      @JsonIgnore
//      private List<Supplier> supplier;

//     //  @OneToMany(mappedBy="diversityClassification",cascade=CascadeType.ALL)
//     //  @JsonIgnoreProperties("diversityClassification")
//     //  private List<DiversityTarget> dt;


//      public DiversityClassification(Long id){
//      this.id=id;
//      }
//      public Long getId() {
//          return id;
//      }
//      public void setId(Long id) {
//          this.id = id;
//      }
//      public String getCode() {
//          return code;
//      }
//      public void setCode(String code) {
//          this.code = code;
//      }
//      public String getDescription() {
//          return description;
//      }
//      public void setDescription(String description) {
//          this.description = description;
//      }
//      public Boolean getActive() {
//          return active;
//      }
//      public void setActive(Boolean active) {
//          this.active = active;
//      }
//      public DiversityClassification(Long id, String code, String description, Boolean active) {
//         this.id = id;
//         this.code = code;
//         this.description = description;
//         this.active = active;
//      }
//      public DiversityClassification() {
//      }
     
     
// }

package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.ManyToMany;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class DiversityClassification {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @NotNull
     @Column(unique=true)
     private String code;

     @NotNull
     private String description;

     Boolean active=true;
     
     @ManyToMany(mappedBy="dc")
     @JsonIgnore
     private List<Supplier> supplier;

    //  @OneToMany(mappedBy="diversityClassification",cascade=CascadeType.ALL)
    //  @JsonIgnoreProperties("diversityClassification")
    //  private List<DiversityTarget> dt;


     public DiversityClassification(Long id){
     this.id=id;
     }
     public Long getId() {
         return id;
     }
     public void setId(Long id) {
         this.id = id;
     }
     public String getCode() {
         return code;
     }
     public void setCode(String code) {
         this.code = code;
     }
     public String getDescription() {
         return description;
     }
     public void setDescription(String description) {
         this.description = description;
     }
     public Boolean getActive() {
         return active;
     }
     public void setActive(Boolean active) {
         this.active = active;
     }
     public DiversityClassification(Long id, String code, String description, Boolean active) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.active = active;
     }
     public DiversityClassification() {
     }
     
     
}


















































