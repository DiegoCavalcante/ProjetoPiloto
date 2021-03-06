package com.example.projetopiloto;

import java.util.ArrayList;

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
import android.widget.ListView;
import android.os.Build;
import bancodados.BD;

import com.les.atividade.Atividade;
import com.les.atividade.Usuario;

public class DisplaySemana extends ActionBarActivity {
	private Usuario usuario;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_display_semana);
		Intent intent = getIntent();
		if(intent!=null){
			Bundle bundle = intent.getExtras();
			if(bundle!=null){
				BD bd = new BD(this);
				usuario = bd.buscar(bundle.getString("email"));
				ListView lv = (ListView) findViewById(R.id.listView1);
				if(usuario.getSemana().getAtividades().size()>0){
					lv.setAdapter(new AtividadeAdapter(this,usuario.getSemana().getRank()));
				}								
				
				//ArrayList<Atividade> atividades = new ArrayList<Atividade>();
				
			}
			
		}
		
		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_semana, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_display_semana,
					container, false);
			return rootView;
		}
	}

}
