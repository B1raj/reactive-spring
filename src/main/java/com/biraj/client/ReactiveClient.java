package com.biraj.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveClient {
	private WebClient client = WebClient.create("http://localhost:8080");

	public void init() {

		client = WebClient.builder().baseUrl("").defaultHeader("", "").build();
	}

	private Mono<ClientResponse> result = client.get().uri("/hello").accept(MediaType.TEXT_PLAIN).exchange();

	public String getResult() {
		return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
	}

	public Mono<String> getMono() {

		return client.get().uri("uri").retrieve().bodyToMono(String.class);
	}

	public Flux<String> getFlux() {

		return client.get().uri("uri").retrieve().bodyToFlux(String.class);
	}

	public String getString() {
		return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
	}
}
