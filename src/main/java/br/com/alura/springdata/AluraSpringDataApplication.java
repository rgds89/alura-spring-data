package br.com.alura.springdata;

import br.com.alura.springdata.services.CargoService;
import br.com.alura.springdata.services.EnderecoService;
import br.com.alura.springdata.services.FuncionarioService;
import br.com.alura.springdata.services.UnidadeService;
import br.com.alura.springdata.services.relatorios.RelatorioFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Scanner;

@SpringBootApplication
public class AluraSpringDataApplication implements CommandLineRunner {
	@Autowired
	private CargoService cargoService;
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private UnidadeService unidadeService;

	@Autowired
	private RelatorioFuncionarioService relatorioFuncionarioService;

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
			System.out.println("1 - Endereço");
			System.out.println("2 - Unidade");
			System.out.println("3 - Cargo");
			System.out.println("4 - Funcionário");
			System.out.println("5 - Relatórios Funcionários");

			String acao = scanner.nextLine();
			if(acao.equals( "1")){
				enderecoService.inicial(scanner);
			} else if (acao.equals("2")) {
				unidadeService.inicial(scanner);
			} else if (acao.equals( "3")) {
				cargoService.inicial(scanner);
			} else if (acao.equals("4")) {
				funcionarioService.inicial(scanner);
			} else if (acao.equals("5")) {
				relatorioFuncionarioService.inicial(scanner);
			} else if (acao.equals("0")) {
				system = false;
			}

		}
		System.exit(0);
	}
}
