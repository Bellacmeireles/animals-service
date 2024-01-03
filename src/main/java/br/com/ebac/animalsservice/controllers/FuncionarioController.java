package br.com.ebac.animalsservice.controllers;

import br.com.ebac.animalsservice.entities.Animal;
import br.com.ebac.animalsservice.entities.Funcionario;
import br.com.ebac.animalsservice.repositories.AnimalRepository;
import br.com.ebac.animalsservice.repositories.FuncionarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private AnimalRepository animalRepository;
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(AnimalRepository animalRepository, FuncionarioRepository funcionarioRepository) {
        this.animalRepository = animalRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    private List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    private Funcionario create(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
}
