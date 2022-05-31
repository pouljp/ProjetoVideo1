package br.com.muvi.conteiner.demo.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity // Entidade , tem uma tabela cliente dentro do Banco de dados
public class Movimentacao {

	@Id //A anotação @Id é utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipoMovimento;
	private Date dataInicio;
	private Date dataFim;

	@ManyToOne
	private Conteiner conteiner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Conteiner getConteiner() {
		return conteiner;
	}

	public void setConteiner(Conteiner conteiner) {
		this.conteiner = conteiner;
	}

}
