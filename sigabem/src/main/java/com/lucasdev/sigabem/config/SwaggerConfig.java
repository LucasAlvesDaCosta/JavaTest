package com.lucasdev.sigabem.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdev.sigabem.utils.ReadFile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		ReadFile read = new ReadFile();
		String html;
		 try {
				html = read.readFile().replaceAll("\t", "");
				System.out.println(">> HTML description loaded in Swagger\n");
		 }catch (IOException e) {
			html = "O arquivo de descrição não foi encontrado: "+e.getMessage();
		}
	    return new ApiInfoBuilder()
	            .title("SigaBem - Spring Boot REST API")
	            .description(html)
	            .version("1.0.0")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .build();
	}
}