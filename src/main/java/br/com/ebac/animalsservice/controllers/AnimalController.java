package br.com.ebac.animalsservice.controllers;

import br.com.ebac.animalsservice.entities.Animal;
import br.com.ebac.animalsservice.repositories.AnimalRepository;
import br.com.ebac.animalsservice.repositories.FuncionarioRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    private AnimalRepository repository;
    private FuncionarioRepository funcionarioRepository;

    public AnimalController(AnimalRepository repository, FuncionarioRepository funcionarioRepository) {
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    private List<Animal> findAll() {
        return repository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal) {
        return repository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    @GetMapping("/not-adopted-dog")
    private List<Animal> findNotAdoptedDog() {
        return repository.findNotAdoptedDog();
    }

    @GetMapping("/adopted-dog")
    private List<Animal> findAdoptedDog() {
        return repository.findAdoptedDog();
    }

    @GetMapping("/not-adopted-cat")
    private List<Animal> findNotAdoptedCat() {
        return repository.findNotAdoptedCat();
    }

    @GetMapping("/adopted-cat")
    private List<Animal> findAdoptedCat() {
        return repository.findAdoptedCat();
    }

    @GetMapping("/employee-gap")
    private List<String> FindEmployees() {
        Date startDate = Date.valueOf("2023-02-05");
        Date endDate =  Date.valueOf("2023-07-05");
        return repository.findEmployees(startDate, endDate);
    }

    @GetMapping("/month")
    private List<Animal> FindMonthAnimals(
            @RequestParam(name = "startDate",required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate startDate,
            @RequestParam(name = "endDate",required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate endDate)
    {
        return repository.findMonthAnimals(startDate, endDate);
    }
}
