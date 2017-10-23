package com.abc.pokerdeck;

/**
 * An object of Card represents a card from poker deck.
 * 
 * @author xiangqian
 */
public class Card implements Comparable<Card> {
	/**
	 * A constant with value 0 representing suit diamonds
	 */
	public static final int DIAMONDS = 0;
	
	/**
	 * A constant with value 1 representing suit clubs
	 */
	public static final int CLUBS = 1;
	
	/**
	 * A constant with value 2 representing suit hearts
	 */
	public static final int HEARTS = 2;
	
	/**
	 * A constant with value 3 representing suit spades
	 */
	public static final int SPADES = 3;
	
	private final int suit;
	private final int rank;
	
	/* the characters(♦, ♣, ♥, ♠) that represent four suits */
	private static final char[] SUIT_SYMBOLS = {'\u2666', '\u2663', '\u2665', '\u2660'};
	
	private static final String[] RANK_SYMBOLS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	/**
	 * Create a card with specified suit and rank.
	 * @param suit
	 * @param rank
	 * @throws IllegalArgumentException if suit < 0 or suit > 3 or rank < 1 or rank > 13
	 */
	public Card(int suit, int rank) {
		if(suit < 0 || suit > 3) {
			throw new IllegalArgumentException("the suit must be between 0 and 3: " + suit);
		}
		
		if(rank < 1 || rank > 13) {
			throw new IllegalArgumentException("the rank must be between 1 and 13: " + rank);
		}
		
		this.suit = suit;
		this.rank = rank;
	}
	
	/**
	 * Return an integer ranging from 0 to 3, which represent the suits of diamonds, clubs, hearts and spades respectively.
	 * @return the suit value
	 */
	public int getSuit() {
		return suit;
	}
	
	/**
	 * Return an integer ranging from 1 to 13, which represent the card ranks from ace to king respectively.
	 * @return an integer value representing
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Compare the Card objects according to the following relation definition:
	 * 1) card1 equals to card2, if and only if both cards have the same suit and rank values
	 * 2) card1 is great than card2, if card1's suit value is great than card2's or both have the same
	 *    suit values and card1's rank value is great than card2's
	 * 3) card1 is less than card2, if card's suit value is less than card2's or both have the same
	 *    rank values and card1's rank value is less than card2's
	 */
	@Override
	public int compareTo(Card o) {
		if(o == null) {
			throw new NullPointerException("The Card object to be compared is null");
		}
		
		// firstly, compare by their suits
		if(getSuit() < o.getSuit()) {
			return -1;
		}
		if(getSuit() > o.getSuit()) {
			return 1;
		}
		
		// if the two objects are the same suits, compare their ranks
		int rank1 = getRank();
		int rank2 = o.getRank();
		return rank1 < rank2 ? -1 : (rank1 == rank2 ? 0 : 1);
	}
	
	@Override
	public String toString() {
		return SUIT_SYMBOLS[suit] + "" + RANK_SYMBOLS[rank - 1];
	}
}
