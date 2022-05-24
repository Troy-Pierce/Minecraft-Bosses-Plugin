package cfd.hireme.bosses.exceptions;

public class TypeAlreadyRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TypeAlreadyRegisteredException(String message) {
		super(message);
		this.fillInStackTrace();
	}
}
