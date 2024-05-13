// Exception personnalisée pour quand le trouble existe déjà
@SuppressWarnings("serial")
public class TroubleDejaExistantException extends Exception {

	public TroubleDejaExistantException(String message) {
        super(message);
    }
}
