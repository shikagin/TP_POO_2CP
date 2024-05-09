
package com.mycompany.tp_poo_version1;

public class TP_POO_version1 {
	
    public static void main(String[] args) {
        Question question = new Question("Question example");
        try {
            question.saisirScore();
           
        } catch (InvalidScoreException e) {
            System.out.println("Invalid score: " + e.getMessage());
        }
    }


}
