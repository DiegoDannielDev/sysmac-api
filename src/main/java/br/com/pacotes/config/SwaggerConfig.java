package br.com.pacotes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.pacotes.controller"))
                .build()
                .groupName("Groupo Sysmac Sistemas")
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .termsOfServiceUrl("Terms of service")
                .title("Sistema de cadastro de produtos e clientes")
                .description("Sysmac sistemas LTDA")
                .version("v1")
                .build();

    }
}

