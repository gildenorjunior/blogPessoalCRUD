package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column
	@NotNull
	@Size(min = 5, max = 100)
	private String titulo;

	@Column
	@NotNull
	@Size(min = 5, max = 500)
	private String texto;
	
	@NotNull

	private int ano;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
//	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	@Temporal(TemporalType.TIMESTAMP)
//	@CreationTimestamp
	private Date data = new java.sql.Date(System.currentTimeMillis());

	//muitas postagens pertencem a um tema
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	
	//MÉTODOS GETTERS AND SETTERS
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	

}