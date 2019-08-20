package com.erivan.fly.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PassagemRouter {

	@Bean
	public RouterFunction<ServerResponse> route(PassagemHandler handler){
		return RouterFunctions
				.route(GET("/passagens").and(accept(MediaType.APPLICATION_JSON)), handler::findAll) //retorna todos
				.andRoute(GET("/passagem/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/passagem").and(accept(MediaType.APPLICATION_JSON)), handler::save);
	}
}
