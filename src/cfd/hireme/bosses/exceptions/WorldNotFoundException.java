package cfd.hireme.bosses.exceptions;

public class WorldNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WorldNotFoundException(String message) {
		super(message);
		this.fillInStackTrace();
	}
}
