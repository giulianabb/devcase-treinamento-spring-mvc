package br.com.devcase.treinamento.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TreinamentoSpringMVCApplication {

	public static void main(String[] args) {
		new SpringApplication(TreinamentoSpringMVCApplication.class).run(args);
	}

	
}
