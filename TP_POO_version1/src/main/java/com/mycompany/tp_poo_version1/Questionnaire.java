package com.mycompany.tp_poo_version1;

import java.util.ArrayList;
public class Questionnaire  extends Test {    //extends Test : add it when u push 
    private ArrayList<Question> listeQuestion ; 


    public Questionnaire(String nom, int capacite, String conclusion) {
        super(nom, capacite, conclusion);
        this.listeQuestion = new ArrayList<>();
    }

    public ArrayList<Question> getListeQuestion() {
        return listeQuestion;
    }

    public void setListeQuestion(ArrayList<Question> listeQuestion) {
        this.listeQuestion = listeQuestion;
    }

    public void addQuestion(String enonce) {
        Question qst = new Question(enonce);
        listeQuestion.add(qst);
    }

    
	@Override
    public float calculeScoreTotal() {
        int totalScore = 0;
        for (Question question : listeQuestion) {
            totalScore += question.getScore();
        }
        return totalScore;
    }

    public int rechercherQuestion(String enonce) {
		int pos = 0;
		for (Question ex : listeQuestion) {
			if (ex.equals(ex) == true) {
				break;
			}
			pos++;
		}
		return (pos);
	}

    public void supprimerQuestion(String enonce) {
		int p=rechercherQuestion(enonce);
		listeQuestion.remove(p);
	}
}





