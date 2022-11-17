package com.labs.br.repository;

import com.labs.br.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNome(String nome);

    Optional<Cliente> findById(Integer id);

    @Query("select c from Cliente c where nome = ?1 and cpf = ?2")
    List<Cliente> selecionarClientepeloNomeECPF(String nome, Integer cpf);

}
