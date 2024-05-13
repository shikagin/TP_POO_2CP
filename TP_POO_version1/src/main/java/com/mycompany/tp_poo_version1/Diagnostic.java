package com.mycompany.tp_poo_version1;

import java.util.*;

public class Diagnostic {

	ArrayList<Trouble> listeTroubles ;
	
	public Diagnostic() {
		// Initialisation de la liste des troubles
		listeTroubles = new ArrayList<Trouble>() ;
	}
	
	// Méthode d'ajout d'un trouble au diagnostic
	public void ajouterTrouble(Trouble trouble) throws TroubleDejaExistantException {
		// Si le trouble existe déja dans le diagnostic, une exception est lancée
        if (listeTroubles.contains(trouble)) {
            throw new TroubleDejaExistantException("Le trouble existe déjà.");
        }
        listeTroubles.add(trouble);
	}
	
	// Méthode de suppression d'un trouble du diagnostic
	public void supprimerTrouble(Trouble trouble) throws TroubleInexistantException {
    	// Si le trouble n'existe pas dans le diagnostic, une exception est lancée
        if (!listeTroubles.contains(trouble)) {
            throw new TroubleInexistantException("Le trouble n'existe pas.");
        }
        listeTroubles.remove(trouble);
	}

    // Une méthode pour modifier un trouble is needed hh

}
