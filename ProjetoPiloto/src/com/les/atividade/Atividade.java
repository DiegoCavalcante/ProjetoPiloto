package com.les.atividade;

public class Atividade implements Comparable<Atividade> {
	
	private String nome;
	private int tempo;
	private float prop;

	public Atividade(String nome, int tempo){
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
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public float getPro(){
		return prop;
	}
	
	public void setPro(float newPro){
		this.prop = newPro;
	}

	public void somaTi(int tempo){
		this.tempo += tempo;
	}
	
	public boolean equals(Atividade at){		
		return this.getNome().equals(at.getNome());
	}
	
	 @Override
	 public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        Atividade pseu = (Atividade) obj;
	        if (nome == null) {
	            if (pseu.getNome() != null) {
	                return false;
	            }
	        } else if (!nome.equals(pseu.getNome())) {
	            return false;
	        }
	        return true;
	 }
	 @Override
	 public int compareTo(Atividade atividade) {
	        if (this.getTempo() > atividade.getTempo()) {
	            return -1;
	        } else if (this.getTempo() <atividade.getTempo()) {
	            return 1;
	        }
	        return 0;
	    }
	
	 public String parserString(){
		 return Integer.toString(this.tempo);
	 }
}
