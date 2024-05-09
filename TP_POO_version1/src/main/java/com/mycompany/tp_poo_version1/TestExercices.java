/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_poo_version1;

import java.util.ArrayList;


public class TestExercices extends Test {
	ArrayList<Exercice> exercices;


	public TestExercices(String nom, int capacite, String conclusion, ArrayList<Exercice> exercices) {
		super(nom, capacite, conclusion);
		this.exercices = exercices;
	}

	
	@Override
	public float calculeScoreTotal() {

		for (Exercice ex : exercices) {
			scoreTotal = +ex.calculeMoyenne();

		}
		return (scoreTotal);
	}

	public void ajouterExercies(String consigne, String nomMateriel, float scores[]) {
		Exercice exercice = new Exercice (consigne, nomMateriel, scores);
		exercices.add(exercice);

	}

	public int rechercherExercices(String consigne) {
		int pos = 0;
		for (Exercice ex : exercices) {
			if (ex.equals(consigne) == true) {
				break;
			}
			pos++;
		}
		return (pos);
	}

	public void supprimerExercies(String cons) {
		int p=rechercherExercices(cons);
		exercices.remove(p);
	}

	
}
