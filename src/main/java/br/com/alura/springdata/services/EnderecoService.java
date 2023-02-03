package br.com.alura.springdata.services;

import br.com.alura.springdata.entities.Endereco;
import br.com.alura.springdata.respositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    public void inicial(Scanner scanner) {
        System.out.println("1 - Novo Registro");
        System.out.println("2 - Atualizar Resgistro");
        System.out.println("3 - Visualizar Resgistro");
        System.out.println("4 - Deletar Resgistro");
        String acao = scanner.nextLine();

        if(acao.equals("1")) {
            System.out.println("Logadouro:");
            String logadouro = scanner.nextLine();

            System.out.println("Número:");
            String numero  = scanner.nextLine();

            System.out.println("Complemento:");
            String complemento = scanner.nextLine();

            System.out.println("Município:");
            String municipio = scanner.nextLine();

            System.out.println("UF:");
            String uf = scanner.nextLine();
            
            novoRegistro(logadouro, numero, complemento, municipio, uf);
            System.out.println("Registro salvo");
        } else if (acao.equals("2")) {
            System.out.println("Logadouro:");
            String logadouro = scanner.nextLine();

            System.out.println("Número:");
            String numero  = scanner.nextLine();

            System.out.println("Complemento:");
            String complemento = scanner.nextLine();

            System.out.println("Município:");
            String municipio = scanner.nextLine();

            System.out.println("UF:");
            String uf = scanner.nextLine();

            System.out.println("Id do Registro:");
            Long id = scanner.nextLong();

            atualizarRegistro(id, logadouro, numero, complemento, municipio, uf);
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
        enderecoRepository.deleteById(id);
    }

    private void visualizar() {
        Iterable<Endereco> listaEndereco = enderecoRepository.findAll();
        listaEndereco.forEach(System.out::println);
    }

    private void atualizarRegistro(Long id, String logadouro, String numero, String complemento, String municipio, String uf) {
        Endereco endereco = enderecoRepository.findById(id).get();
        endereco.setLogadouro(logadouro);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setCidade(municipio);
        endereco.setUf(uf);
        enderecoRepository.save(endereco);
    }

    private void novoRegistro(String logadouro, String numero, String complemento, String municipio, String uf) {
        Endereco endereco = new Endereco(logadouro, numero, complemento, municipio, uf);
        enderecoRepository.save(endereco);
    }

    public Endereco obterEnderecoPeloID(Long id) {
        return enderecoRepository.findById(id).get();
    }
}
