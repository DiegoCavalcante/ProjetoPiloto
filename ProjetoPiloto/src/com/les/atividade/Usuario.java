package com.les.atividade;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private long id;
	private String nome;
	private String email;
	private List<Atividade> atividades;	
	
	
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
	
	public List<Atividade> getAtividades(){
		return atividades;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long novoId){
		this.id = novoId;
	}

	public void addAtividade(String string, int i) {
		Atividade atividade =  new Atividade(string, i);
		atividades.add(atividade);		
	}

	
}
