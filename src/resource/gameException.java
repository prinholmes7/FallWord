package resource;

public class gameException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorType;
	
	public gameException(int type) {
		errorType = type;
	}
	
	@Override
	public String getMessage() {
		String[] message = {"Can't load highscore."};
		return message[errorType];
	}
	
}
