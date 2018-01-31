package com.yy.springbootswagger.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @package: cn.yy.swagger
 * @Description:
 * @Date: Created in  2018-01-30 11:52
 * @Author: yy
 */
@Configuration
@EnableSwagger2
public class Swagger {
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.yy.springbootswagger.controller";
    public static final String VERSION = "1.0.0";

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Springboot-Swagger")
                .description("自定义springboot-swagger")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version(VERSION)
                .contact(new Contact("yy","", ""))
                .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .build()
                .apiInfo(apiInfo());
    }
}