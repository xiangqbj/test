package com.abc.pokerdeck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.abc.pokerdeck.Card;

public class CardTest {

	@Test
	public void testCard() {
		new Card(Card.CLUBS, 1);
	}
	
	@Test
	public void testCardException() {
		try {
			new Card(-1, 1);
		}catch(IllegalArgumentException e) {
		}
		
		try {
			new Card(4, 2);
		}catch(IllegalArgumentException e) {
		}
		
		try {
			new Card(0, 0);
		}catch(IllegalArgumentException e) {
		}
		
		try {
			new Card(0, 14);
		}catch(IllegalArgumentException e) {
		}
	}

	@Test
	public void testGetSuit() {
		Card card = new Card(Card.DIAMONDS, 10);
		assertEquals(Card.DIAMONDS, card.getSuit());
	}

	@Test
	public void testGetRank() {
		Card card = new Card(Card.DIAMONDS, 13);
		assertEquals(13, card.getRank());
	}

	@Test
	public void testCompareTo() {
		Card card01 = new Card(Card.DIAMONDS, 1);
		Card card011 = new Card(Card.DIAMONDS, 1);
		Card card02 = new Card(Card.DIAMONDS, 2);
		Card card11 = new Card(Card.CLUBS, 1);
		
		assertEquals(0, card01.compareTo(card011));
		assertEquals(-1, card01.compareTo(card02));
		assertEquals(1, card02.compareTo(card011));
		assertEquals(-1, card01.compareTo(card11));
		assertEquals(1, card11.compareTo(card01));
	}
	
	@Test(expected=NullPointerException.class)
	public void testCompareToException() {
		Card card01 = new Card(Card.DIAMONDS, 1);
		card01.compareTo(null);
	}

	@Test
	public void testToString() {
		Card card01 = new Card(Card.DIAMONDS, 1);
		assertEquals("♦A", card01.toString());
		
		Card card11 = new Card(Card.CLUBS, 2);
		assertEquals("♣2", card11.toString());
		
		Card card210 = new Card(Card.HEARTS, 10);
		assertEquals("♥10", card210.toString());
		
		Card card3Q = new Card(Card.SPADES, 12);
		assertEquals("♠Q", card3Q.toString());
	}

}
