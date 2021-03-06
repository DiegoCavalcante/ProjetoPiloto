package com.example.projetopiloto;

import bancodados.BD;

import com.les.atividade.Atividade;
import com.les.atividade.Usuario;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;

public class DisplayTi extends ActionBarActivity {
	private Usuario usuario;
	private BD bd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_ti);
		Intent intent = getIntent();
		bd = new BD(this);
		usuario = bd.buscar(intent.getExtras().getString("email"));
		
		//usuario = Usuario.getInstancia();
		//System.out.println(usuario.getNome());
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_ti, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_display_ti,
					container, false);
			return rootView;
		}
	}
	
	public void adicionaAtividade(View view){
		EditText nomeAtividade = (EditText)findViewById(R.id.nome_atividade);
		EditText tempo = (EditText)findViewById(R.id.ti);	
		
		Atividade atividade = new Atividade(nomeAtividade.getText().toString(),Integer.parseInt(tempo.getText().toString()));
		
		Intent intent = new Intent();
		intent.putExtra("nome", nomeAtividade.getText().toString());	
		usuario.getSemana().adicionaAtividade(atividade);
		setResult(1,intent);
		bd.atualizar(usuario);
		System.out.println(usuario.getSemana().totalAtividades());
		if(nomeAtividade.getText().toString().length() > 0 ){
			Toast.makeText(this, "Atividade registrada com sucesso", Toast.LENGTH_SHORT).show();			
		}
		finish();		
	}
	
	

}
