package com.udacity.vehicles.document.config;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@ApiResponses({
        @ApiResponse(code=400, message = "This is a bad request, Please use the right API documentation"),
        @ApiResponse(code=401, message = "This is a bad request, Please use the right API documentation"),
        @ApiResponse(code=500, message = "The server is down. Please make sure the vehicle api is running")
        }
)
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Vehicle API",
                "This API returns vehicle information including price from price service",
                "1.0",
                "www.okeyobia.com/tte",
                new Contact("Okey Obia", "www.okeyobia.com", "okey.obia@gmail.com"),
                "","", Collections.emptyList()
        );
    }
}
