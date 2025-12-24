// package com.example.demo.service;

// public interface UserAccountService{
    
// }
package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {
    String register(UserAccount user);
    UserAccount findByEmailOrThrow(String email);
    UserAccount login(String email,String password);
}