// package com.example.demo.service.Impl;

// import org.springframework.stereotype.Service;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.exception.UnauthorizedException;
// import com.example.demo.repository.UserAccountRepository;
// import com.example.demo.service.UserAccountService;

// @Service
// public class UserAccountServiceImpl implements UserAccountService{
//     private final UserAccountRepository uar;
//     public UserAccountServiceImpl(UserAccountRepository uar){
//         this.uar=uar;
//     }
//     @Override
//     public String register(UserAccount user){
//         uar.save(user);
//         return "User registered successfully";
        
//     }

//     @Override
//     public UserAccount findByEmailOrThrow(String email){
//          UserAccount user=uar.findByEmail(email);
//          if(user==null){
//             throw new ResourceNotFoundException("Given email is not registered");
//          }
//          return user;
//     }

//     @Override
//     public UserAccount login(String email,String password){
//          UserAccount user=uar.findByEmail(email);
//          if(user==null){
//             throw new UnauthorizedException("Invalid email");
//          }
//          if(!user.getPassword().equals(password)){
//             throw new UnauthorizedException("Invalid password");
//          }
//          return user;
//     }
// }