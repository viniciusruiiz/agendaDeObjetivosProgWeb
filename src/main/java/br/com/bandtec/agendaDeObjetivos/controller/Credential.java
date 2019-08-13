package br.com.bandtec.agendaDeObjetivos.controller;

public class Credential {

	private String username;
	private String password;
	
	public Credential(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
}
