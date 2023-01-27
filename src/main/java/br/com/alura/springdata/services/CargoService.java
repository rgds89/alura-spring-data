package br.com.alura.springdata.services;

import br.com.alura.springdata.entities.Cargo;
import br.com.alura.springdata.respositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public void inicial(Scanner scanner){
        System.out.println("1 - Novo Registro");
        System.out.println("2 - Atualizar Resgistro");
        System.out.println("3 - Visualizar Resgistro");
        System.out.println("4 - Deletar Resgistro");
        int acao = scanner.nextInt();

        if(acao == 1) {
            System.out.println("Descrição do cargo:");
            novoRegistro(scanner.next());
            System.out.println("Registro salvo");
        } else if (acao == 2) {
            System.out.println("Id do Registro:");
            Long id = scanner.nextLong();

            System.out.println("Descrição Cargo");
            String descricao = scanner.next();

            atualizarRegistro(id, descricao);
            System.out.println("Registro atualizado");
        } else if (acao == 3) {
            visualizar();
        } else if (acao == 4) {
            System.out.println("Id Registro");
            Long id = scanner.nextLong();

            deletar(id);
            System.out.println("Registro removido");
        }


    }

    private void novoRegistro(String descricao){
        Cargo cargo = new Cargo(descricao);
        cargoRepository.save(cargo);
    }

    private void atualizarRegistro(Long id, String descricao){
        cargoRepository.updateDescricaoById(descricao, id);
    }

    private void visualizar(){
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(System.out::println);
    }

    private void deletar(Long id){
        cargoRepository.deleteById(id);
    }
}
