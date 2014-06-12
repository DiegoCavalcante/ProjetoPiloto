package com.example.projetopiloto;

import java.util.ArrayList;
import java.util.List;

import bancodados.BD;

import com.example.projetopiloto.LoginUser.PlaceholderFragment;
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
import android.widget.Button;
import android.widget.ListView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	
	private Usuario usuario;	
	private ArrayAdapter<String> adapter;
	private static final int CONSTANTE_TELA_1 = 1;
	private List<String> list; 
	private BD bd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);			
		bd = new BD(this);
		
		// puxar o usuario do BD
		Intent intent = getIntent();
		usuario = bd.buscar(intent.getExtras().getString("email"));		
		
		list = new ArrayList<String>();
		//list.add(usuario.getSemana().getAtividades().toString());//upar lista do usuario	
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,usuario.getSemana().paraArray());
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
						
		ListView lista = (ListView) findViewById(R.id.lv);		
		lista.setAdapter(adapter);
		
		
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id){
		case R.id.action_settings:
			return true;
		case R.id.item1:
			historico();
		}
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	public void descricaoAtividade(View view){
		Intent intent = new  Intent(this, DisplayTi.class);
		intent.putExtra("email", usuario.getEmail());
		startActivityForResult(intent, CONSTANTE_TELA_1);
	}
	//verificar uma melhor forma de voltar os resultados
	protected void onActivityResult(int codigoTela, int resultado, Intent intent){
		if(codigoTela == CONSTANTE_TELA_1){			
			Bundle params = intent.getExtras();
			if(params != null){
				String nome = params.getString("nome");
				//adapter.add(nome);
				//usuario = bd.buscar(params.getString("email"));				
			}
		}
		
	}
	public void historico(){
		Intent intent = new Intent(this, DisplaySemana.class);
		intent.putExtra("email", usuario.getEmail());
		startActivity(intent);		
	}
	
}
