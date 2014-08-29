package com.example.appeventos.adapters.model;

public class Eventos {

	public String titulo;
	public String data;
	public String url;
	
	public Eventos(String titulo, String data, String url) {
		super();
		this.titulo = titulo;
		this.data = data;
		this.url = url;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
