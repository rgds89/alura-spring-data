package br.com.alura.springdata.services;

import br.com.alura.springdata.entities.*;
import br.com.alura.springdata.respositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Service
public class FuncionarioService {
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private UnidadeService unidadeService;
    @Autowired
    private CargoService cargoService;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void inicial(Scanner scanner) {
        System.out.println("1 - Novo Registro");
        System.out.println("2 - Atualizar Resgistro");
        System.out.println("3 - Visualizar Resgistro");
        System.out.println("4 - Deletar Resgistro");
        String acao = scanner.nextLine();

        if(acao.equals("1")) {
            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println("Cpf/Cnpj:");
            String cpfCnpj = scanner.nextLine();

            System.out.println("Salário:");
            String salario = scanner.nextLine();

            System.out.println("Cargo Id:");
            String cargoId = scanner.nextLine();

            System.out.println("Endereço Id:");
            String enderecoId  = scanner.nextLine();

            System.out.println("Unidade Id:");
            String unidadeId  = scanner.nextLine();

            novoRegistro(nome, cpfCnpj, salario, enderecoId, unidadeId, cargoId);
            System.out.println("Registro salvo");
        } else if (acao.equals("2")) {
            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println("Cpf/Cnpj:");
            String cpfCnpj = scanner.nextLine();

            System.out.println("Salário:");
            String salario = scanner.nextLine();

            System.out.println("Cargo Id:");
            String cargoId = scanner.nextLine();

            System.out.println("Endereço Id:");
            String enderecoId  = scanner.nextLine();

            System.out.println("Unidade Id:");
            String unidadeId  = scanner.nextLine();

            System.out.println("Id do Registro:");
            Long id = scanner.nextLong();

            atualizarRegistro(id, nome, cpfCnpj, salario, enderecoId, unidadeId, cargoId);
            System.out.println("Registro atualizado");
        } else if (acao.equals("3")) {
            visualizar();
        } else if (acao.equals("4")) {
            System.out.println("Id Registro");
            Long id = scanner.nextLong();

            deletar(id);
            System.out.println("Registro removido");
        }
    }

    private void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }

    private void visualizar() {
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(System.out::println);
    }

    private void atualizarRegistro(Long id, String nome, String cpfCnpj, String salario, String enderecoId, String unidadeId, String cargoId) {
        Endereco endereco = enderecoService.obterEnderecoPeloID(Long.valueOf(enderecoId));
        Unidade unidade = unidadeService.obterUnidadePeloID(Long.valueOf(unidadeId));
        Cargo cargo = cargoService.obterCargoPeloID(Long.valueOf(cargoId));
        Funcionario funcionario = funcionarioRepository.findById(id).get();

        funcionario.setNome(nome);
        funcionario.setCpfCnpj(cpfCnpj);
        funcionario.setSalario(new BigDecimal(salario));
        funcionario.setCargo(cargo);
        funcionario.setUnidade(unidade);
        funcionario.setEndereco(endereco);

        funcionarioRepository.save(funcionario);
    }

    private void novoRegistro(String nome, String cpfCnpj, String salario, String enderecoId, String unidadeId, String cargoId) {
        Endereco endereco = enderecoService.obterEnderecoPeloID(Long.valueOf(enderecoId));
        Unidade unidade = unidadeService.obterUnidadePeloID(Long.valueOf(unidadeId));
        Cargo cargo = cargoService.obterCargoPeloID(Long.valueOf(cargoId));

        Funcionario funcionario = new Funcionario(nome, cpfCnpj, new BigDecimal(salario), LocalDate.now(), cargo, unidade, endereco);
        funcionarioRepository.save(funcionario);
    }
}
