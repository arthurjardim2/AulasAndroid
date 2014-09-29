package com.example.connectionvolley.core;

import com.example.connectionvolley.adapter.Foto;

public class ControllerMainActivity {

	public static ControllerMainActivity INSTANCE = null;
	
	private Foto foto;
	
	private ControllerMainActivity(){}
	
	public static ControllerMainActivity getInstance(){
		
		if (INSTANCE == null) {
			INSTANCE = new ControllerMainActivity();
		}
		return INSTANCE;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	
}
