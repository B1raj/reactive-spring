package com.biraj.webflux;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SpringWebFlux {

	public Map<Integer, String> store = new HashMap<Integer, String>() {
		{
			put(1, "biraj");
			put(2, "mishra");
		}
	};

	@GetMapping(value = "/jedi", produces = "application/json")
	public Mono<?> jediById() {
		return Mono.just(store.get(1));
	}
	
	
	@GetMapping(value = "/jedi/all" , produces = "application/json")
	public Flux<?> jedi() {
		return Flux.just(store.values());
	}
}
