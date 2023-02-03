package br.com.alura.springdata.services.relatorios;

import br.com.alura.springdata.entities.Funcionario;
import br.com.alura.springdata.respositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioFuncionarioService {
    private FuncionarioRepository funcionarioRepository;
    public void inicial(Scanner scanner) {
        System.out.println("1 - Busca funcionário por nome");
//        System.out.println("2 - Atualizar Resgistro");
//        System.out.println("3 - Visualizar Resgistro");
//        System.out.println("4 - Deletar Resgistro");
        String acao = scanner.nextLine();

        if(acao.equals("1")) {
            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println(nome);

            buscaFuncionarioPorNome(nome);
        } else if (acao.equals("2")) {
            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println("Registro atualizado");
        } else if (acao.equals("3")) {
        } else if (acao.equals("4")) {

        }
    }

    private void buscaFuncionarioPorNome(String nome) {
        try{
            List<Funcionario> funcionarios = funcionarioRepository.findByNomeLike(nome);
            funcionarios.forEach(System.out::println);
        } catch (NullPointerException npe){
            System.out.println("Funcionario não encontrado!");
        }
    }
}
