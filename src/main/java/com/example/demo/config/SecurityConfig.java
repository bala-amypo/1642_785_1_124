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

// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//             .csrf(csrf -> csrf.disable())
//             .authorizeHttpRequests(auth -> auth

//                
//                 .requestMatchers("/swagger-ui/**", "/v3/api-docs/**")
//                 .hasAnyRole("ADMIN", "USER")

//                
//                 .requestMatchers(HttpMethod.GET,
//                         "/diversity-classifications/**",
//                         "/diversity-targets/**",
//                         "/suppliers/**",
//                         "/purchase-orders/**",
//                         "/spend-categories/**",
//                         "/users/**"
//                 ).hasAnyRole("ADMIN", "USER")

//                 
//                 .requestMatchers(HttpMethod.POST,
//                         "/diversity-classifications/**",
//                         "/diversity-targets/**",
//                         "/suppliers/**",
//                         "/purchase-orders/**",
//                         "/spend-categories/**",
//                         "/users/**"
//                 ).hasRole("ADMIN")

//                 /* UPDATE */
//                 .requestMatchers(HttpMethod.PUT,
//                         "/diversity-classifications/**",
//                         "/diversity-targets/**",
//                         "/suppliers/**",
//                         "/purchase-orders/**",
//                         "/spend-categories/**",
//                         "/users/**"
//                 ).hasRole("ADMIN")

//                 /* DELETE */
//                 .requestMatchers(HttpMethod.DELETE,
//                         "/diversity-classifications/**",
//                         "/diversity-targets/**",
//                         "/suppliers/**",
//                         "/purchase-orders/**",
//                         "/spend-categories/**",
//                         "/users/**"
//                 ).hasRole("ADMIN")

//                 .anyRequest().authenticated()
//             )
//             .formLogin()
//             .and()
//             .logout().permitAll();

//         return http.build();
//     }

//     @Bean
//     public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {

//         var admin = org.springframework.security.core.userdetails.User
//                 .withUsername("admin")
//                 .password(passwordEncoder.encode("admin123"))
//                 .roles("ADMIN")
//                 .build();

//         var user = org.springframework.security.core.userdetails.User
//                 .withUsername("user")
//                 .password(passwordEncoder.encode("user123"))
//                 .roles("USER")
//                 .build();

//         return new InMemoryUserDetailsManager(admin, user);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }


package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth

            .requestMatchers(
                    "/auth/**",
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html"
            ).permitAll()

            .requestMatchers(
                    "/diversityclassification/**",
                    "/diversitytarget/**"
            ).hasRole("ADMIN")

            // USER + ADMIN
            .requestMatchers(
                    "/supplier/**",
                    "/purchaseorders/**",
                    "/spendcategory/**"
            ).hasAnyRole("USER", "ADMIN")

            .anyRequest().authenticated()
        )
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
