package br.com.alura.springdata.services;

import br.com.alura.springdata.entities.Cargo;
import br.com.alura.springdata.respositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public void CriaCargo(){
        Cargo cargo = new Cargo(1L, "Desenvolvedor Java Júnior");
        cargoRepository.save(cargo);
    }
}
