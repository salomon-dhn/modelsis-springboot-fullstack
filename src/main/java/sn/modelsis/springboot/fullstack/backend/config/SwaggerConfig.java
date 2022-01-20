package sn.modelsis.springboot.fullstack.backend.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
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
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        	.groupName("V1")
            .select()
            .apis(RequestHandlerSelectors.basePackage("sn.modelsis.springboot.fullstack.backend"))
            .paths(PathSelectors.any())
            .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "ModelSis Database API",
            "Exposing backend database modelsis management REST endpoints",
            "v1.0",
            "Terms of service",
            new Contact("Salomon DAHOUN", "https://linkedin.com/in/1sal", "salomondahoun@yahoo.fr"),
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }
}