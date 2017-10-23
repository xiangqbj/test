package com.abc.pokerdeck;

/**
 * Thrown by methods in the <code>Deck</code> class to indicate
 * that the poker deck is empty.
 * @author xiangqian
 */
public class EmptyDeckException extends RuntimeException {

	private static final long serialVersionUID = 2015884823117141117L;

	/**
	 * Constructs a new EmptyDeckException with null as its error message string.
	 */
	public EmptyDeckException() {
	}
}
