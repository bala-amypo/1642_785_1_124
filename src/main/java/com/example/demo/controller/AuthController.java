// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.service.UserAccountService;

// @RestController
// public class AuthController {
//    private final UserAccountService uas;
//    public AuthController(UserAccountService uas){
//          this.uas=uas;
//    }
    
//    @PostMapping("/POST/auth/register")
//     public String registerUser(@RequestBody UserAccount user){
//         return uas.register(user);
//     }

//     @GetMapping("/GET/find-user")
//     public UserAccount findUserByEmailOrThrow(@RequestParam String email){
//         return uas.findByEmailOrThrow(email);
//     }

//     @PostMapping("/POST/auth/login")
//     public UserAccount log_in(@RequestParam String email,@RequestParam String password){
//          return uas.login(email,password);
//     }
// }












