package br.com.alura.springdata;

import br.com.alura.springdata.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AluraSpringDataApplication implements CommandLineRunner {
	@Autowired
	private CargoService cargoService;

	private Boolean system = true;

	public static void main(String[] args) {
		SpringApplication.run(AluraSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (system){
			System.out.println("Qual ação você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");

			int acao = scanner.nextInt();
			if(acao == 1){
				cargoService.inicial(scanner);
			} else if (acao == 0) {
				system = false;
			}

		}
		System.exit(0);
	}
}
