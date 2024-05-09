package com.mycompany.tp_poo_version1;

public class QstLibreAnamneseEnfant extends QstLibreAnamnese {
	
	private TypeQstAnamneseEnfant categorie;
	
	public QstLibreAnamneseEnfant(String enonce, TypeQstAnamneseEnfant categorie) {
		super(enonce);
		this.categorie = categorie;
	}

}
