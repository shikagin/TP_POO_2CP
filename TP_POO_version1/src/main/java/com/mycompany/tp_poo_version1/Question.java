package com.mycompany.tp_poo_version1;

import java.util.Scanner ; 
public class Question {
    protected int score ; 
    protected String enonce ; 

    public Question (String enonce){
        this.enonce=enonce ; 
    }

    //pour que l'ortophoniste puisse saisir le score et renovoyer une exception 
    public void saisirScore() throws InvalidScoreException{ 
        int score ; 
        Scanner sc = new Scanner(System.in) ; 
        System.out.println("Veuillez saisir le score : ");
        score = sc.nextInt();
        //condition pour tester que le score suit la norme précisée 
        if (score < 1 || score > 10) {
            throw new InvalidScoreException("Score must be between 1 and 10.");
        }else {
        setScore(score);
        }
    }

    //Les affichages 

    public void afficherEnonce (){
        System.out.println(enonce);
    }

    public void afficherScore (){
        System.out.println(score);
    }


    //LES SETTERS ET LES GETTERS 
    //do we need access with them even with the protected ? (to be continued ...)

    public void setScore(int score){
        this.score = score ; 

    }

   public int getScore(){
        return score ; 
    }

//     public void setEnonce(String enonce){
//         this.enonce = enonce ; 

//     }

//     public String getEnonce(){
//         return enonce ; 
//     }
 
}






