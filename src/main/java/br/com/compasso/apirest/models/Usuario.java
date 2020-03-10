package br.com.compasso.apirest.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;

	private String nome;
	private String email;
	private String telefone;
	private String sexo;

	private LocalDate dataNascimento;
	
	private int idade;

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(LocalDate idade) {
	
		this.idade = Period.between(getDataNascimento(), LocalDate.now()).getYears();
	}

	}
