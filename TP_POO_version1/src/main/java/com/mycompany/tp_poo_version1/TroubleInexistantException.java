package com.mycompany.tp_poo_version1;

// Exception personnalisée pour quand le trouble n'existe pas
class TroubleInexistantException extends Exception {
	
	public TroubleInexistantException(String message) {
        super(message);
    }
}