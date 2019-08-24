package app.toyrobot.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguaration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("app.toyrobot.web.controller.impl"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Toy Robot API Documentation", 
                "Rest Api's for Toy Robot Coding Challenge",
                "1.0",
                "Free to use", 
                new Contact("Ankur Goel", "https://github.com/ankurgoel92/toy-robot", "ankurgoel.juit@gmail.com"), 
                "MIT Lisence", 
                "https://github.com/ankurgoel92/toy-robot/blob/master/LICENSE", 
                Collections.emptyList());
    }
}
