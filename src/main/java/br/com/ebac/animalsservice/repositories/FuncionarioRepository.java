package br.com.ebac.animalsservice.repositories;

import br.com.ebac.animalsservice.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    Funcionario findByNome(String nome);
}
