package com.erivan.fly.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import reactor.core.publisher.Mono;

import com.erivan.fly.document.Passagem;
import com.erivan.fly.service.PassagemService;

@Component
public class PassagemHandler {
	
	@Autowired
	PassagemService service;
	
	//lista todas as passagens
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Passagem.class);
		
	}
	//lista por id selecionado
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(id), Passagem.class);
	}
	
	//salvar
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<Passagem> passagem = request.bodyToMono(Passagem.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(passagem.flatMap(service::save), Passagem.class)); //salva no banco
	}

}
