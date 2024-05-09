/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_poo_version1;

import java.util.ArrayList;

/**
 *
 * @author Rafika MK
 */
public class TESTEXERCICES extends TEST {
	ArrayList<EXERCICE> exercices;

	public TESTEXERCICES (String nom, int capacite, String conclusion, ArrayList<EXERCICE> exercices) {
		super(nom, capacite, conclusion);
		this.exercices = exercices;
	}

	
	@Override
	public float calculeScoreTotal() {

		for (EXERCICE ex : exercices) {
			scoreTotal = +ex.calculeMoyenne();

		}
		return (scoreTotal);
	}

	public void ajouterExercies(String consigne, String nomMateriel, float scores[]) {
		EXERCICE exercice = new EXERCICE(consigne, nomMateriel, scores);
		exercices.add(exercice);

	}

	public int rechercherExercices(String consigne) {
		int pos = 0;
		for (EXERCICE ex : exercices) {
			if (ex.equals(ex) == true) {
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
