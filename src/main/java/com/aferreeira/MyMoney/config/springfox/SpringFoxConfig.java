package com.aferreeira.MyMoney.config.springfox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aferreeira"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(getApiInfo())
                .globalResponseMessage(RequestMethod.GET, apiResponses());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "MyMoney Service Project",
                "A Simple REST API to get my money organized",
                "1.0.0",
                "TERMS OF SERVICE URL",
                new Contact("Alexandre Ferreira","https://www.linkedin.com/in/alexandre-ferreira-dos-santos-921a1b90/","alexandrefs.ferreira@gmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

    private List<ResponseMessage> apiResponses() {
        return Arrays.asList(
                new ResponseMessageBuilder().code(400).message("Bad Request").build(),
                new ResponseMessageBuilder().code(403).message("Forbidden").build(),
                new ResponseMessageBuilder().code(404).message("Invalid request").build(),
                new ResponseMessageBuilder().code(405).message("Method Not Allowed").build(),
                new ResponseMessageBuilder().code(500).message("Internal Server Error").build());
    }
}
