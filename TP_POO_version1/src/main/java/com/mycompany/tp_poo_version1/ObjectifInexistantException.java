// Exception personnalisée pour quand l'objectif n'existe pas
@SuppressWarnings("serial")
class ObjectifInexistantException extends Exception {

	public ObjectifInexistantException(String message) {
        super(message);
    }
}