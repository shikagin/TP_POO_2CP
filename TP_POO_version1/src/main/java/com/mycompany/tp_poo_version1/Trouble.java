package com.mycompany.tp_poo_version1;

public class Trouble {

	private String nom ;
	private CatTrouble categorie ;
	
	public Trouble(String nom, String categorie) {
		this.nom = nom ;
		switch (categorie) {
		case "Trouble de déglutition" : this.categorie = CatTrouble.Deglutition ;
		case "Trouble neuro-dévloppemental" : this.categorie = CatTrouble.NeuroDevloppemental ;
		case "Trouble cognitif" : this.categorie = CatTrouble.Cognitif ;
		}
	}

	public String getNom() {
		return nom;
	}

	public String getCategorie() {

		return switch (this.categorie) {
			case Deglutition -> "trouble de la déglutition";
			case NeuroDevloppemental -> "trouble neuro-développemental";
			case Cognitif -> "trouble cognitif";
			default -> "";
		};
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setCategorie(CatTrouble categorie) {
        this.categorie = categorie;
    }

}
