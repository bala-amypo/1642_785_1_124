// package com.example.demo.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.validation.constraints.Email;

// public class UserAccount {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;

//     private String fullNameString;

//     @Column(unique=true)
//     @Email
//     private String email;

//     private String password;

//     private String role="USER";

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getFullNameString() {
//         return fullNameString;
//     }

//     public void setFullNameString(String fullNameString) {
//         this.fullNameString = fullNameString;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public String getRole() {
//         return role;
//     }

//     public void setRole(String role) {
//         this.role = role;
//     }

//     public UserAccount(Long id, String fullNameString, @Email String email, String password, String role) {
//         this.id = id;
//         this.fullNameString = fullNameString;
//         this.email = email;
//         this.password = password;
//         this.role = role;
//     }

//     public UserAccount() {
//     }

    

    

// }