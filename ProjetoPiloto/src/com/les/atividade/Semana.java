package com.les.atividade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Semana {
	
	private List<Atividade> lista;
	
	
	public Semana(){
		lista = new ArrayList<Atividade>();
		
	}

	public List<Atividade> getAtividades() {		
		return lista;
	}

	public void adicionaAtividade(Atividade atividade){		
		if(lista.contains(atividade)){
			int indice = lista.indexOf(atividade);
			lista.get(indice).somaTi(atividade.getTempo());
			
		}else
			lista.add(atividade);
		proporcao();
	}
	
	public int totalAtividades(){
		return lista.size();
	}
	
	public String[] paraArray(){
		String[] result = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++){
			result[i] = lista.get(i).getNome();
		}
		return result;
	}
	
	public List<Atividade> getRank(){
		Collections.sort(lista);
		return lista;
		
	}
	
	private float tempoTotal(){
		int result = 0;
		for(int i = 0;i<lista.size();i++){
			result+= lista.get(i).getTempo();
		}
		return result;
	}
	
	public void proporcao(){
		float prop;
		float tempoTotal = tempoTotal();
		for(int i = 0;i<lista.size();i++){
			prop = (float) (lista.get(i).getTempo() * 100.0 / tempoTotal);
			lista.get(i).setPro(prop);
		}
	}
	
	public List<Atividade> recentes(Atividade atividade){
		List<Atividade> aux = new ArrayList<Atividade>();
		aux.add(atividade);
		for(int i = lista.size() -1; i <= 0;i--){
			if(!aux.contains(lista.get(i))){
				aux.add(lista.get(i));
			}
		}
		
		return aux;
		
	}
}
