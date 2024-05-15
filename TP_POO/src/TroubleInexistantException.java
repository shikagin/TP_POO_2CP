// Exception personnalisée pour quand le trouble n'existe pas
@SuppressWarnings("serial")
class TroubleInexistantException extends Exception {
	
	public TroubleInexistantException(String message) {
        super(message);
    }
}
