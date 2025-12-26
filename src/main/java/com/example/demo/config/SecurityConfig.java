// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http.csrf(csrf -> csrf.disable())
//             .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
//         return http.build();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//         return config.getAuthenticationManager();
//     }
// }

package com.example.demo1.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo1.Security.JwtFilter;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) //to handle HTTP req
public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;


    @Bean
    public PasswordEncoder passwordEncoder() { //PasswordEncoder is a built in class
        return new BCryptPasswordEncoder(); //to store new hash value everytime
    }


    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) //http is the http request .
        throws Exception {

    http  //browser
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth   //authentication
            .requestMatchers("/auth/**").permitAll()  //auth is the base url in AuthControlelr RequestMapping
            .requestMatchers(
                "/swagger-ui/**",
                "/v3/api-docs/**"
            ).permitAll()
            .anyRequest().authenticated()) //if we have to access anything other than auth/.... we have to do authentication

        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        
    return http.build();
}

}
