package com.example.hamza.allotechnicien.models;

public class Technicien {


	private long id;	
	private float note;	
	
	private Utilisateur utilisateur;
	
	public Technicien() {
		super();
	}
	
	public Technicien(float note, Utilisateur utilisateur) {
		super();
		this.note = note;
		this.utilisateur  = utilisateur;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
