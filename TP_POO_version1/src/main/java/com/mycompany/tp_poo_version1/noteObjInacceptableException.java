package com.mycompany.tp_poo_version1;

// Exception de la note d'un objectif
@SuppressWarnings("serial")
public class noteObjInacceptableException extends Exception {

	public noteObjInacceptableException(String message) {
		super(message);
	}
}