package br.senac.tads.dsw.exemplos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // @Configuration já está implicito
public class ExemplosSpringInicialApplication {

	@Bean
	public GeradorSaida geradorSaida() {
		return new GeradorSaidaJson();
	}

	public static void main(String[] args) {
		SpringApplication.run(ExemplosSpringInicialApplication.class, args);
	}

}
