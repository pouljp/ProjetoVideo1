package br.com.muvi.conteiner.demo.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity // Entidade , tem uma tabela cliente dentro do Banco de dados
public class Conteiner {
	
	@Id //A anotação @Id é utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária 
	@GeneratedValue(strategy = GenerationType.IDENTITY )// um valor para o identificador é gerado para cada registro inserido no banco. Alguns bancos de dados podem não suportar essa opção. - Biblioteca
	private Long id;
	
	private String conteinerLetra;
	private String conteinerNumero;
	private String tipo;
	private String status;
	private String categoria;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "conteiner", cascade = CascadeType.ALL) // Que Conteiner  tem varios Movimentações  e também pode não tenhum.
	private List<Movimentacao> movimentacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConteinerLetra() {
		return conteinerLetra;
	}

	public void setConteinerLetra(String conteinerLetra) {
		this.conteinerLetra = conteinerLetra;
	}

	public String getConteinerNumero() {
		return conteinerNumero;
	}

	public void setConteinerNumero(String conteinerNumero) {
		this.conteinerNumero = conteinerNumero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Movimentacao> getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(List<Movimentacao> movimentacao) {
		this.movimentacao = movimentacao;
	}


	
}
