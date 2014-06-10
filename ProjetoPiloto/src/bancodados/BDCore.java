package bancodados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper {
	private static final String NOME_BD = "LES";
	private static final int VERSAO_BD = 2;
	
	

	public BDCore(Context context){
		super(context, NOME_BD, null, VERSAO_BD);		
	}

	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL("create table usuario(_id integer primary key autoincrement, nome text not null, email text not null);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
		bd.execSQL("drop table usuario;");
		onCreate(bd);
	}

}
