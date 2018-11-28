package br.com.livraria.domain;

import java.io.Serializable;
import java.util.Calendar;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private Endereco endereco;
	private Calendar dataNascimento;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco
				+ ", dataNascimento=" + dataNascimento + "]";
	}

}
