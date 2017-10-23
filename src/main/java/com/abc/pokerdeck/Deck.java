package com.abc.pokerdeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An object of Deck represents a poker deck that contains 52 playing cards.
 * @author xiangqian
 */
public class Deck {
	/* a list to store 52 cards */
	private List<Card> cardList;
	
	/* the index of next card to return by dealCard() method */
	private int index;
	
	/**
	 * Create an instance of Deck containing 52 cards, which are sorted in the order of diamonds, clubs,
	 * hearts and spades and in each suit, the cards are from ace, 2, ..., queen, king.
	 */
	public Deck() {
		cardList = new ArrayList<>();
		
		for(int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
			for(int rank = 1; rank <= 13; rank++) {
				cardList.add(new Card(suit, rank));
			}
		}
	}
	
	/**
	 * Shuffle the cards randomly, after which all the 52 cards will be available for being dealt.
	 */
	public void shuffle() {
		Collections.shuffle(cardList);
		index = 0;
	}
	
	/**
	 * Return the number of left cards that can be dealt.
	 * @return the number of left cards
	 */
	public int numberOfLeftCards() {
		return cardList.size() - index;
	}
	
	/**
	 * Deal a card from this deck and return it.
	 * @return an instance of Card
	 * @throws EmptyDeckException if the number of left cards is zero
	 */
	public Card dealCard() {
		if(numberOfLeftCards() <= 0) {
			throw new EmptyDeckException();
		}
		
		return cardList.get(index++);
	}
}
