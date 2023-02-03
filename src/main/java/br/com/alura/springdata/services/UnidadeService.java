package br.com.alura.springdata.services;

import br.com.alura.springdata.entities.Endereco;
import br.com.alura.springdata.entities.Unidade;
import br.com.alura.springdata.respositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UnidadeService {
    @Autowired
    private UnidadeRepository unidadeRepository;
    @Autowired
    private EnderecoService enderecoService;
    public void inicial(Scanner scanner) {
        System.out.println("1 - Novo Registro");
        System.out.println("2 - Atualizar Resgistro");
        System.out.println("3 - Visualizar Resgistro");
        System.out.println("4 - Deletar Resgistro");
        String acao = scanner.nextLine();

        if(acao.equals("1")) {
            System.out.println("Descrição:");
            String descricao = scanner.nextLine();

            System.out.println("Endereço Id:");
            String endereco  = scanner.nextLine();

            novoRegistro(descricao, endereco);
            System.out.println("Registro salvo");
        } else if (acao.equals("2")) {
            System.out.println("Descrição:");
            String descricao = scanner.nextLine();

            System.out.println("Endereço Id:");
            String endereco  = scanner.nextLine();

            System.out.println("Id do Registro:");
            Long id = scanner.nextLong();

            atualizarRegistro(id, descricao, endereco);
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
        unidadeRepository.deleteById(id);
    }

    private void visualizar() {
        Iterable<Unidade> unidades = unidadeRepository.findAll();
        unidades.forEach(System.out::println);
    }

    private void atualizarRegistro(Long id, String descricao, String enderecoId) {
        Endereco endereco = enderecoService.obterEnderecoPeloID(Long.valueOf(enderecoId));
        Unidade unidade = unidadeRepository.findById(id).get();
        unidade.setDescricao(descricao);
        unidade.setEndereco(endereco);
        unidadeRepository.save(unidade);
    }

    private void novoRegistro(String descricao, String enderecoId) {
        Endereco endereco = enderecoService.obterEnderecoPeloID(Long.valueOf(enderecoId));
        Unidade unidade = new Unidade(descricao, endereco);
        unidadeRepository.save(unidade);
    }

    public Unidade obterUnidadePeloID(Long id) {
        return unidadeRepository.findById(id).get();
    }
}
