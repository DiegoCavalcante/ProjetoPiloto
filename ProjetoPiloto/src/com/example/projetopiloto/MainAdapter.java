package com.example.projetopiloto;

import java.util.List;

import com.les.atividade.Atividade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {
	private Context context;
	private List<Atividade> lista;
	public MainAdapter(Context contetx, List<Atividade> lista){
		this.context = context;
		this.lista =lista;
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
	public View getView(int position, View arg1, ViewGroup arg2) {
		Atividade atividade = lista.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.recentes, null);
		
		TextView recente = (TextView)layout.findViewById(R.id.recente);
		recente.setText(atividade.getNome());
		
		return layout;
	}

}
