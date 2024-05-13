package com.mycompany.tp_poo_version1;

import java.util.*;

public class Anamnese {
	
	Set <QstLibreAnamnese> listeQuestions;
	
	public Anamnese() {
        listeQuestions = new HashSet<>();
    }

    public void ajouterQuestion(QstLibreAnamnese question) {
        listeQuestions.add(question);
    }
	
    public void modifierQuestion(QstLibreAnamnese ancienneQuestion, QstLibreAnamnese nouvelleQuestion) {
        if (listeQuestions.contains(ancienneQuestion)) {
            listeQuestions.remove(ancienneQuestion);
            listeQuestions.add(nouvelleQuestion);
        } else {
            System.out.println("La question à modifier n'existe pas dans la liste.");
        }
    }

    public void supprimerQuestion(QstLibreAnamnese question) {
        listeQuestions.remove(question);
    }

}
