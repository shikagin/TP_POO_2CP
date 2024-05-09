
package com.mycompany.tp_poo_version1;

public abstract class Test {

	private String nom;
	private int capacite;
	float scoreTotal = 0;
	private String conclusion;

	public Test(String nom, int capacite, String conclusion) {
		this.nom = nom;
		this.capacite = capacite;
		this.conclusion = conclusion;

	}

	public String getNom() {
		return (this.nom);

	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacite() {
		return (this.capacite);
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getConclusion() {
		return (this.conclusion);
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public float getScoreTotal() {
		return (this.scoreTotal);
	}

	public void setScoreTotal(float scoreTotal) {
		this.scoreTotal = scoreTotal;
	}

	public abstract float calculeScoreTotal();
}
