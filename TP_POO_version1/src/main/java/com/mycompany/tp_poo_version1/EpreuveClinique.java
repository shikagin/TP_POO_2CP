package com.mycompany.tp_poo_version1;
import java.util.ArrayList;

public class EpreuveClinique {
	
    private String [] observationClinique ; 
    private ArrayList <Test> listeTests ; 
    
    public EpreuveClinique(String [] observationClinique){
        this.observationClinique=observationClinique;
        this.listeTests= new ArrayList<>();

    }


    
}