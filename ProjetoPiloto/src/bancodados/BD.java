package bancodados;

import com.google.gson.Gson;
import com.les.atividade.Usuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BD {
	private SQLiteDatabase bd;	 
	private final String[] 	COLUNAS = {"_id","nome","email"};
	private final Gson gson;
	
	public BD(Context context){
		BDCore auxBd = new BDCore(context);
		bd = auxBd.getWritableDatabase();
		gson = new Gson();
	}	
	
	
	public boolean inserir(Usuario usuario){
		boolean resp = false;
		String usuarioJson = gson.toJson(usuario);
		
		ContentValues valores = new ContentValues();
		valores.put("nome", usuarioJson);
		valores.put("email", usuario.getEmail());
		
		Cursor cursor = bd.query("usuario", COLUNAS, "email = ?", new String[]{usuario.getEmail()}, null, null, null);
		
		if(cursor.getCount()<=0){
			long idUser = bd.insert("usuario", null, valores);
			usuario.setId(idUser);	
			resp = true;
		}
		cursor.close();
		return resp;
	}
	
	public void atualizar(Usuario usuario){
		ContentValues valores = new ContentValues();
		String usuarioJson = gson.toJson(usuario);
		
		valores.put("nome", usuarioJson);
		//valores.put("email", usuario.getEmail());		
		
		bd.update("usuario", valores, "email = ?", new String[]{usuario.getEmail()});
	}
	
	public void deletar(Usuario usuario){
		bd.delete("usuario", "_id = "+ usuario.getId(), null);
	}
	
	public Usuario buscar(String email){
		
		String [] colunas = new String[]{"_id","nome","email"};
		Cursor cursor = bd.query("usuario", colunas,  "email = ?",new String[]{email} , null, null, null);	
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			return toUsuario(cursor);
		}		
		cursor.close();		
		return null;
	}
	
	public Usuario toUsuario(Cursor cursor){
		String usuarioJson = cursor.getString(1);
		Usuario usuario = gson.fromJson(usuarioJson, Usuario.class);
		
		return usuario; 
	}

}
