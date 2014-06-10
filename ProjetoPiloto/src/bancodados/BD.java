package bancodados;

import com.les.atividade.Usuario;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BD {
	private SQLiteDatabase bd;	 
	private final String[] 	COLUNAS = {"_id","nome","email"};
	
	public BD(Context context){
		BDCore auxBd = new BDCore(context);
		bd = auxBd.getWritableDatabase();
	}	
	
	
	public boolean inserir(Usuario usuario){
		boolean resp = false;
		ContentValues valores = new ContentValues();
		valores.put("nome", usuario.getNome());
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
		valores.put("nome", usuario.getNome());
		valores.put("email", usuario.getEmail());
		
		
		bd.update("usuario", valores, "_id = "+usuario.getId(), null);
	}
	
	public void deletar(Usuario usuario){
		bd.delete("usuario", "_id = "+ usuario.getId(), null);
	}
	
	public Usuario buscar(String email){
		Usuario usuario = new Usuario();
		
		String [] colunas = new String[]{"_id","nome","email"};
		Cursor cursor = bd.query("usuario", colunas,  "email = ?",new String[]{email} , null, null, null);	
		cursor.moveToFirst();
		
		if(cursor.getCount() > 0){
			usuario.setId(cursor.getLong(0));
			usuario.setNome(cursor.getString(1));
			usuario.setEmail(cursor.getString(2));
		}		
		cursor.close();		
		return usuario;
	}

}
