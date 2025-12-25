// package com.example.demo.service;

// import com.example.demo.entity.UserAccount;

// public interface UserAccountService {
//     String register(UserAccount user);
//     UserAccount findByEmailOrThrow(String email);
//     UserAccount login(String email,String password);
// }

package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {
    UserAccount register(UserAccount userAccount);
    UserAccount findByEmailOrThrow(String email);
}