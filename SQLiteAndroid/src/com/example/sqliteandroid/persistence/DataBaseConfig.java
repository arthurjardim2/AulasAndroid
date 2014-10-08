package com.example.sqliteandroid.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseConfig extends SQLiteOpenHelper{

	public static final int DB_VER = 1;
	public static final String NOME_DB = "NOME";
	public static final String TABELA_USERS = "USER";
	public static final String COL_USERS_ID = "CodId";
	public static final String COL_USERS_NOME = "Nome";
	
	private static final String CREATE_TABELA_USERS =
			"CREATE TABLE USER (CodId TEXT, Nome TEXT);";
	
	//Opcional
	private static final String CREATE_TABELA_USERS2 =
			"CREATE TABLE " + TABELA_USERS + 
			"( " + COL_USERS_ID + " TEXT, "
			+ COL_USERS_NOME + " TEXT);";
	
	public DataBaseConfig(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABELA_USERS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//O QUE FAZER PARA ATUALIZAÇÃO
		//ALTER TABLE
		//DROP TABLE
		db.execSQL("DROP TABLE IF EXIST " + TABELA_USERS + ";");
		onCreate(db);
	}

}
