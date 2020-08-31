package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping
	public String getHello() {
		return "Em minha primeira graduação tive a oportunidade de trabalhar com um pessoal que era muito\r\n" + 
				"desorganizado e infantil, ja na minha segunda graduação tive outra experiencia totalmente diferente,\r\n" + 
				"super organizado e cada um procurou conhecer o outro, focando nos pontos fortes";
	}
	
}
