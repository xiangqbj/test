package com.abc.pokercard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.abc.pokerdeck.Card;
import com.abc.pokerdeck.Deck;
import com.abc.pokerdeck.EmptyDeckException;

public class DeckTest {
	private static final int TOTAL_CARDS_NUM = 52;
	private static final int TOTAL_RANKS_NUM = 13;

	@Test
	public void testDeck() {
		Deck deck = new Deck();
		assertEquals(TOTAL_CARDS_NUM, deck.numberOfLeftCards());
		
		while(deck.numberOfLeftCards() > 0) {
			int count = TOTAL_CARDS_NUM - deck.numberOfLeftCards();
			Card card = deck.dealCard();
			int suit = count / TOTAL_RANKS_NUM;
			int rank = count % TOTAL_RANKS_NUM + 1;
			
			assertEquals(suit, card.getSuit());
			assertEquals(rank, card.getRank());
		}
	}
	
	@Test
	public void testShuffle() {
		Deck deck = new Deck();
		deck.shuffle();
		assertEquals(TOTAL_CARDS_NUM, deck.numberOfLeftCards());
		
		int numOfUnmatch = 0;
		while(deck.numberOfLeftCards() > 0) {
			int count = TOTAL_CARDS_NUM - deck.numberOfLeftCards();
			Card card = deck.dealCard();
			int suit = count / TOTAL_RANKS_NUM;
			int rank = count % TOTAL_RANKS_NUM + 1;
			
			if(suit != card.getSuit() || rank != card.getRank()) {
				numOfUnmatch ++;
			}
			
			assertTrue(numOfUnmatch > 0);
		}
	}

	@Test
	public void testNumberOfLeftCards() {
		Deck deck = new Deck();
		assertEquals(TOTAL_CARDS_NUM, deck.numberOfLeftCards());
		
		for(int i = 1; i <= TOTAL_CARDS_NUM; i++) {
			deck.dealCard();
			assertEquals(TOTAL_CARDS_NUM - i, deck.numberOfLeftCards());
		}
	}
	
	@Test
	public void testDealCard() {
		Deck deck = new Deck();
		
		Card card1 = deck.dealCard();
		assertNotNull(card1);
		
		Card card2 = deck.dealCard();
		assertNotNull(card2);
		
		assertTrue(!(card1.getSuit() == card2.getSuit() && card1.getRank() == card2.getRank()));
	}

	@Test(expected = EmptyDeckException.class)
	public void testDealCardException() {
		Deck deck = new Deck();
		
		// repeat dealing cards until deck is empty
		for(int i = 0; i < TOTAL_CARDS_NUM; i++) {
			deck.dealCard();
		}
		
		// the deck has been empty, so this line should trigger EmptyDeckException
		deck.dealCard();
	}
}
