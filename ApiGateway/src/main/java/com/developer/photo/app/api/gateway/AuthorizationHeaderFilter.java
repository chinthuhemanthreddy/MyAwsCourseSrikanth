package com.developer.photo.app.api.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;
@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config>{

	@Autowired
	private Environment environment;
	
	public AuthorizationHeaderFilter() {
		super(Config.class);
	}
	public static class Config{
		//put configuration properties here
		
	}
	
	@Override
	public GatewayFilter apply(Config config) {
		
		
		return (exchange, chain)->{
			System.out.println("in AuthorizationHeaderFilter class filter.... ");
			ServerHttpRequest request = exchange.getRequest();
			if(!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
				return onError(exchange,"No Authorization header",HttpStatus.UNAUTHORIZED);
			}
			
			String authHeader = request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
			String jwt= authHeader.replace("Bearer", "");
			if(!isJwtTokenisValid(jwt)) {
				return onError(exchange,"Authorization token is not valid ",HttpStatus.UNAUTHORIZED);
			}
			return chain.filter(exchange);
		};
	}
	
	private Mono<Void> onError(ServerWebExchange exchange, String error, HttpStatus statusCode) {
		// TODO Auto-generated method stub
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(statusCode);
		
		return response.setComplete();
	}

	private boolean isJwtTokenisValid(String jwt) {
		boolean returnedVlaue = true ;
		String userId = null;
		try {
		userId= Jwts.parser().setSigningKey(environment.getProperty("token.secret"))
		.parseClaimsJws(jwt)
		.getBody()
		.getSubject();
		}catch(Exception ex) {
			System.out.println(" exception is :: "+ex.getMessage());
			ex.printStackTrace();
		}
		if(userId == null || userId.isEmpty() )
			returnedVlaue=false;
		System.out.println("returned value is :::"+jwt );
		return returnedVlaue  ;
	}
	
}
