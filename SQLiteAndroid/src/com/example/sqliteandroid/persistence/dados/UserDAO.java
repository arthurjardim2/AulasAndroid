package com.example.sqliteandroid.persistence.dados;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqliteandroid.persistence.DataBaseConfig;
import com.example.sqliteandroid.persistence.model.User;

public class UserDAO {
	
	private DataBaseConfig config;
	private SQLiteDatabase liteDB;
	
	public UserDAO(Context c){
		config = new DataBaseConfig(c, DataBaseConfig.NOME_DB,
				null, DataBaseConfig.DB_VER);
	}
	
	public boolean insert(User user){
		
		ContentValues cv = new ContentValues();
		cv.put(DataBaseConfig.COL_USERS_ID, user.getCod());
		cv.put(DataBaseConfig.COL_USERS_NOME, user.getNome());
		
		liteDB = config.getWritableDatabase();
		
		boolean flag = liteDB.insert(DataBaseConfig.TABELA_USERS, null, cv) > 0;
		
		liteDB.close();
		config.close();
		
		return flag;
	}
	
	public ArrayList<User> getAll(){
		
		ArrayList<User> users = new ArrayList<User>();
		
		liteDB = config.getReadableDatabase();
//		
//		Cursor c = liteDB.query(DataBaseConfig.TABELA_USERS, null, null, null, null, null, null);
//		
//		while (c.moveToNext()) {
//			User u = new User();
//			u.setCod(c.getString(0));
//			u.setNome(c.getString(1));
//			users.add(u);
//		}
//		
//		liteDB.close();
//		config.close();
		
		Cursor c = liteDB.rawQuery("SELECT * FROM " +  DataBaseConfig.TABELA_USERS, null);
		
		while (c.moveToNext()) {
			User u = new User();
			u.setCod(c.getString(0));
			u.setNome(c.getString(1));
			users.add(u);
		}
		
		liteDB.close();
		config.close();
		
		return users;
		
	}

}
