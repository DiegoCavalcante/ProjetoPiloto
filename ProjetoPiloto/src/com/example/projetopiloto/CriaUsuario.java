package com.example.projetopiloto;

import bancodados.BD;

import com.example.projetopiloto.Login.PlaceholderFragment;
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
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class CriaUsuario extends ActionBarActivity {
	private EditText nome;
	private EditText email;
	private Usuario usuario ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cria_usuario);		
		
		nome = (EditText) findViewById(R.id.nome_usuario);
		email = (EditText) findViewById(R.id.email);		
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cria_usuario, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_cria_usuario,
					container, false);
			return rootView;
		}
	}
	
	public void criaUsuario(View view){
		nome = (EditText) findViewById(R.id.nome_usuario);
		email = (EditText) findViewById(R.id.email);
		boolean insert;
		usuario = new Usuario(nome.getText().toString(),email.getText().toString());
		
		BD bd = new BD(this);
		insert = bd.inserir(usuario);		
		
		if(insert){
			Toast.makeText(this, "Usuario criado com sucesso", Toast.LENGTH_SHORT).show();
			finish();
		}else{
			Toast.makeText(this, "Usuario existente", Toast.LENGTH_SHORT).show();
		}	
		
	}
	

}
