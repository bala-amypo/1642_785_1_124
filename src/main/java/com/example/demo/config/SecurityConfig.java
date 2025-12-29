// package com.example.demo.config;

// import com.example.demo.security.JwtAuthFilter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     private final JwtAuthFilter jwtAuthFilter;

//     public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
//         this.jwtAuthFilter = jwtAuthFilter;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http.csrf(csrf -> csrf.disable())
//             .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers(
//                         "/auth/**",
//                         "/v3/api-docs/**",
//                         "/swagger-ui/**",
//                         "/swagger-ui.html"
//                 ).permitAll()
//                 .requestMatchers(
                       
//                         "/diversitytarget/**"
//                 ).hasRole("ADMIN")
//                 .requestMatchers(
//                          "/diversityclassification/**",
//                         "/supplier/**",
//                         "/purchaseorders/**",
//                         "/spendcategory/**"
//                 ).hasAnyRole("USER", "ADMIN")
//                 .anyRequest().authenticated()
//             )
//             .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

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

package com.example.demo.config;

import com.example.demo.security.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            .authorizeHttpRequests(auth -> auth

                .requestMatchers(
                        "/auth/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                ).permitAll()

               
                .requestMatchers(HttpMethod.GET, "/diversitytarget/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST, "/diversitytarget/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.PUT, "/diversitytarget/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/diversityclassification/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST, "/diversityclassification/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.PUT, "/diversityclassification/**").hasAnyRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/supplier/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST, "/supplier/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.PUT, "/supplier/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/purchaseorders/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST, "/purchaseorders/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.PUT, "/purchaseorders/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/spendcategory/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST, "/spendcategory/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/spendcategory/**").hasRole("ADMIN")

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
