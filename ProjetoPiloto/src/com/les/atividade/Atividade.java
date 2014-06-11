package com.les.atividade;

public class Atividade {
	
	private String nome;
	private String tempo;

	public Atividade(String nome, String tempo){
		this.nome = nome;
		this.tempo = tempo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempo() {
		return Integer.parseInt(tempo);
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	
}
