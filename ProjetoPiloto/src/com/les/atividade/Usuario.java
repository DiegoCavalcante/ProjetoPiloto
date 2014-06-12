package com.les.atividade;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private long id;
	private String nome;
	private String email;	
	private Semana[] semanas ;
	
	public Usuario(String nome, String email){
		this.nome = nome;
		this.email = email;
		
		inicializar();
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
	
	
	
	public long getId(){
		return id;
	}
	
	public void setId(long novoId){
		this.id = novoId;
	}

	
	public void inicializar(){
		this.semanas = new Semana[1];
		this.semanas[0] = new Semana();
	}
	
	
	public Semana getSemana(){
		return semanas[0];
	}
	
}
