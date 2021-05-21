package com.developer.photo.app.api.gateway;

import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
@Component
@Slf4j
public class MyPreFilter implements GlobalFilter, Ordered {

	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("My pre filter method is callinng... ");
		log.info("My pre filter method is callinng... log file");
		ServerHttpRequest request = exchange.getRequest();
		String requestPath = request.getPath().toString();
		HttpHeaders headers = request.getHeaders(); 
		log.info("Request path::: "+requestPath);
		Set<String> headerNames = headers.keySet();
		log.info("headerNames ::: "+headerNames);
		headerNames.forEach((headerName)->{
			String headerValue = headers.getFirst(headerName);
			log.info(headerName +" === "+headerValue);
		});
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {

		return 0;
	}

}
