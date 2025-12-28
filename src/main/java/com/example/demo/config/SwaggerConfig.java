package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // You need to change the port as per your server
                .servers(List.of(
                        new Server().url("https://9167.pro604cr.amypo.ai")
                ));
        }
}


// // package com.example.demo.config;

// // import io.swagger.v3.oas.models.Components;
// // import io.swagger.v3.oas.models.OpenAPI;
// // import io.swagger.v3.oas.models.security.SecurityRequirement;
// // import io.swagger.v3.oas.models.security.SecurityScheme;
// // import io.swagger.v3.oas.models.servers.Server;
// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;

// // import java.util.List;

// // @Configuration
// // public class SwaggerConfig {

// //     @Bean
// //     public OpenAPI customOpenAPI() {

// //         SecurityScheme jwtScheme = new SecurityScheme()
// //                 .name("Authorization")
// //                 .type(SecurityScheme.Type.HTTP)
// //                 .scheme("bearer")
// //                 .bearerFormat("JWT");

// //         return new OpenAPI()
// //                 .servers(List.of(
// //                         new Server().url("https://9167.pro604cr.amypo.ai")
// //                 ))
// //                 .components(new Components()
// //                         .addSecuritySchemes("bearerAuth", jwtScheme))
// //                 .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
// //     }
// // }

// // package com.example.demo.config;

// // import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// // import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
// // import io.swagger.v3.oas.annotations.info.Info;
// // import io.swagger.v3.oas.annotations.security.SecurityRequirement;
// // import io.swagger.v3.oas.annotations.security.SecurityScheme;
// // import org.springframework.context.annotation.Configuration;

// // @Configuration
// // @OpenAPIDefinition(
// //         info = @Info(title = "Diversity API", version = "1.0"),
// //         security = @SecurityRequirement(name = "bearerAuth")
// // )
// // @SecurityScheme(
// //         name = "bearerAuth",
// //         type = SecuritySchemeType.HTTP,
// //         scheme = "bearer",
// //         bearerFormat = "JWT"
// // )
// // public class SwaggerConfig {
// // }

// package com.example.demo.config;

// import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
// import io.swagger.v3.oas.annotations.info.Info;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;
// import io.swagger.v3.oas.annotations.security.SecurityScheme;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// @OpenAPIDefinition(
//         info = @Info(title = "Diversity API", version = "1.0"),
//         security = @SecurityRequirement(name = "bearerAuth")
// )
// @SecurityScheme(
//         name = "bearerAuth",
//         type = SecuritySchemeType.HTTP,
//         scheme = "bearer",
//         bearerFormat = "JWT"
// )
// public class SwaggerConfig {
// }
