package br.com.muvi.conteiner.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // Entidade , tem uma tabela cliente dentro do Banco de dados

public class Cliente {

	@Id // A anotação @Id é utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária 
	@GeneratedValue(strategy = GenerationType.IDENTITY)// um valor para o identificador é gerado para cada registro inserido no banco. Alguns bancos de dados podem não suportar essa opção. - Biblioteca
	private Long id;

	private String nome;
	private String cpfCnpj;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)//  Que Cliente  tem varios conteiners e também pode não tenhum.
	private List<Conteiner> conteiner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getcpfCnpj() {
		return cpfCnpj;
	}

	public void setCpf(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public List<Conteiner> getConteiner() {
		return conteiner;
	}

	public void setConteiner(List<Conteiner> conteiner) {
		this.conteiner = conteiner;
	}

}
