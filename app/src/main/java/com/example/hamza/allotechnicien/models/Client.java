package com.example.hamza.allotechnicien.models;

public class Client {

	private long id;
	private String adresse;
	
	private Utilisateur utilisateur;
	
	
	public Client() {
		super();
	}
	

	public Client(String adresse) {
		super();
		this.adresse = adresse;
	}


	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	

	
}
