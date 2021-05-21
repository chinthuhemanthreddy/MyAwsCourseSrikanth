package com.organization.university.config;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app.global.swagger")
public class SwaggerProperties {
	@Data
	public static class Contact {
		private String name;
		private String url;
		private String email;
	}

	private Set<String> produces;
	private Set<String> consumes;
	private String title;
	private String description;
	private String version;
	private String tosURL;
	private String contactName;
	private String license;
	private String licenseURL;
	private Contact contact;

}