package com.developer.photo.app.api.gateway;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class GlobalFiltersConfiguration {

	@Order(1)
	@Bean
	public GlobalFilter secondPreFilter() {
		
		
		return (exchange, chain) ->{
			log.info("my first PreFilter Global is executed....");
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				log.info("my third Post Filter Global was executed :::::::::");
			}));
		};
		
	}
	
	@Order(2)
	@Bean
	public GlobalFilter thirdPreFilter() {
		
		
		return (exchange, chain) ->{
			log.info("my second PreFilter Global is executed....");
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				log.info("my second Post Filter Global was executed :::::::::");
			}));
		};
		
	}
	
	@Order(3)
	@Bean
	public GlobalFilter fourthPreFilter() {
		
		
		return (exchange, chain) ->{
			log.info("my third PreFilter Global is executed....");
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				log.info("my first Post Filter Global was executed :::::::::");
			}));
		};
		
	}
	
}
 