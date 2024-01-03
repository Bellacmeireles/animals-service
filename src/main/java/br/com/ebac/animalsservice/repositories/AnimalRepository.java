package br.com.ebac.animalsservice.repositories;

import br.com.ebac.animalsservice.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada DESC")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL ")
    List<Animal> findAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NULL AND a.specie = 'dog'")
    List<Animal> findNotAdoptedDog();

    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NOT NULL AND a.specie = 'dog'")
    List<Animal> findAdoptedDog();

    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NULL AND a.specie = 'cat'")
    List<Animal> findNotAdoptedCat();


    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NOT NULL AND a.specie = 'cat'")
    List<Animal> findAdoptedCat();

    @Query("SELECT a.funcionario, COUNT(*) as quantidadeAnimais FROM Animal a WHERE a.dataEntrada >= :startDate AND a.dataEntrada <= :endDate " +
            "GROUP BY a.funcionario")
    List<String> findEmployees(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );

    @Query("SELECT a FROM Animal a WHERE a.dataEntrada >= :startDate AND a.dataEntrada <= :endDate")
    List<Animal> findMonthAnimals(LocalDate startDate, LocalDate endDate);
}
