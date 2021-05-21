package com.organization.university.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class OpenAPIDocumentationConfig {
	
	@Autowired
	private SwaggerProperties properties;
	
    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

    }

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()).produces(properties.getProduces())
				.consumes(properties.getConsumes()).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any()).build();
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfo(
				properties.getTitle(),
				properties.getDescription(),
				properties.getVersion(),
				properties.getTosURL(),
				new Contact(
						properties.getContact().getName(),
						properties.getContact().getUrl(),
						properties.getContact().getEmail()),
				properties.getLicense(),
				properties.getLicenseURL(),
				Collections.emptyList());
	}
}