package com.example.appeventos.core;

import com.example.appeventos.adapters.model.Eventos;

public class Controller {

	private static Controller instance = null;
	
	private Eventos currentEvento;
	
	private Controller(){}
	
	public static Controller getInstance(){
		
		if (instance == null) {
			instance = new Controller();
		}
		
		return instance;
	}

	public Eventos getCurrentEvento() {
		return currentEvento;
	}

	public void setCurrentEvento(Eventos currentEvento) {
		this.currentEvento = currentEvento;
	}
	
}
