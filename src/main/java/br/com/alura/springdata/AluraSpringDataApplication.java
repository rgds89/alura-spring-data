package br.com.alura.springdata;

import br.com.alura.springdata.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraSpringDataApplication implements CommandLineRunner {
	@Autowired
	private CargoService cargoService;

	public static void main(String[] args) {
		SpringApplication.run(AluraSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cargoService.CriaCargo();
	}
}
