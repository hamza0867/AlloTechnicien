package com.example.hamza.allotechnicien.models;

import java.util.HashSet;
import java.util.Set;

public class Domaine {

	private long id;
	
	private String designation;		
	
	
	private Set<Technicien> techniciens = new HashSet<>();
	
	public Domaine() {
		super();
	}
	
	public Domaine(String designation) {
		super();
		
		this.designation = designation;
	}

	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Set<Technicien> getTechniciens() {
		return techniciens;
	}

	public void setTechniciens(Set<Technicien> techniciens) {
		this.techniciens = techniciens;
	}
	
	
	public void ajouterTechnicien(Technicien technicien) {
		this.techniciens.add(technicien);
	}
	
	
	
}
