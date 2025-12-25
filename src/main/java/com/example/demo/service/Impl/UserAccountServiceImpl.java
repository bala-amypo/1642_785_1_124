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

package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;
    
    public UserAccountServiceImpl(UserAccountRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public UserAccount register(UserAccount userAccount) {
        if (repository.existsByEmail(userAccount.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return repository.save(userAccount);
    }
    
    @Override
    public UserAccount findByEmailOrThrow(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}