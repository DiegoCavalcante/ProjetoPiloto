package com.example.projetopiloto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.les.atividade.Atividade;
public class AtividadeAdapter extends BaseAdapter {
	
	private Context context;
	private List<Atividade> lista;
	
	public AtividadeAdapter(Context context, List<Atividade> lista){
		this.context = context;
		this.lista = lista;
	}
	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Atividade atividade = lista.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout =  inflater.inflate(R.layout.atividades, null);
		
		TextView nomeA = (TextView) layout.findViewById(R.id.lv_atividade_nome);
		nomeA.setText(atividade.getNome());
		
		TextView tempo = (TextView) layout.findViewById(R.id.lv_atividade_tempo);
		tempo.setText(atividade.parserString());
		
		TextView prop = (TextView) layout.findViewById(R.id.lv_atividade_prop);
		DecimalFormat df = new DecimalFormat("##.##"); 
		prop.setText(df.format(atividade.getPro())+"%");
		
		
		return layout;
	}

}
