package com.mycompany.tp_poo_version1;

public class Trouble {

	private String nom;

	private TypeTroubles categorie;

	public Trouble(String nom, TypeTroubles categorie) {
		this.nom = nom;
		this.categorie = categorie;
	}

	public String getNom() {
		return nom;
	}

	public String getCategorie() {

		return switch (this.categorie) {
			case TROUBLE_DEGLUTITION -> "trouble de la d�glutition";
			case TROUBLE_NEURO_DEVELOPPEMENTAL -> "trouble neuro-d�veloppemental";
			case TROUBLE_COGNITIF -> "trouble cognitif";
			default -> "";
		};
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setCategorie(TypeTroubles categorie) {
        this.categorie = categorie;
    }
}
