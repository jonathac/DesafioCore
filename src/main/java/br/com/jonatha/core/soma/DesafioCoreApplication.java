package br.com.jonatha.core.soma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
public class DesafioCoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioCoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
