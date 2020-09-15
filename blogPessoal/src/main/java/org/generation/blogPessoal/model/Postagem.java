package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Essa notacao indica que essa classe é uma entidade do JPA hibernate
@Table(name = "tb_postagem") // indica que essa entidade dentro do banco sera uma tabela com o nome tb_postagem
public class Postagem {
	
	@Id // indica que é uma id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indica que vai ser uma primary key
	private long id;
	
	@NotNull // indica que nao pode ser vazia
	@Size(min = 5, max = 100) // Indica um tamanho limite para a variavel
	private String titulo;
	
	@NotNull // indica que nao pode ser vazia
	@Size(min = 10, max = 500)
	private String texto;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP) // indica para o JPA que estamos trabalhando com tempo
	private Date date = new java.sql.Date(System.currentTimeMillis());
	// Pega exatamente a Data, hora, minuto, segundos e milesimos
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")// quando chegar em postagem para de apresentar informação
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	//Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
