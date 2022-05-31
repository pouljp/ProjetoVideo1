package br.com.muvi.conteiner.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.muvi.conteiner.demo.model.Cliente;

@Repository // A Classe que utilizamos para acessar metodos para interagir com o bando de dados (Pesquisar/ deletar/pesquisar/) 
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	
}
