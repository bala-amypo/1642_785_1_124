package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

@RestController
public class AuthController {
   private final UserAccountService uas;
   public AuthController(UserAccountService uas){
         this.uas=uas;
   }
    
   @PostMapping("/POST/user-account")
    public String registerUser(@RequestBody UserAccount user){
        return uas.register(user);
    }

    @GetMapping("/GET/find-user")
    public UserAccount findUserByEmailOrThrow(@RequestParam String email){
        return uas.findByEmailOrThrow(email);
    }
}











UserAccountService.java
package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {
    String register(UserAccount user);
    UserAccount findByEmailOrThrow(String email);
}

UserAccountServiceImpl.java
package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService{
    private final UserAccountRepository uar;
    public UserAccountServiceImpl(UserAccountRepository uar){
        this.uar=uar;
    }
    @Override
    public String register(UserAccount user){
        uar.save(user);
        return "User registered successfully";
        
    }

    @Override
    public UserAccount findByEmailOrThrow(String email){
         UserAccount user=uar.findByEmail(email);
         if(user==null){
            throw new ResourceNotFoundException("Given email is not registered");
         }
         return user;
    }

}