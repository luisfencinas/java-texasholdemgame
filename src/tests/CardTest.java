package tests;

/** 
 * Start of a JUnit test for class Card with enums.
 * 
 * @author Rick Mercer and YOUR NAME
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import model.Card;
import model.Rank;
import model.Suit;

public class CardTest {

	@Test
	public void testGetters() {
		Card c1 = new Card(Rank.DEUCE, Suit.CLUBS);
		assertEquals(Rank.DEUCE, c1.getRank());
		assertEquals(Suit.CLUBS, c1.getSuit());
		assertEquals(2, c1.getValue());
	}

	@Test
	public void testCompareTo() {
		Card c1 = new Card(Rank.DEUCE, Suit.CLUBS);
		Card c2 = new Card(Rank.THREE, Suit.DIAMONDS);
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c2.compareTo(c1) > 0);
		assertTrue(c1.compareTo(c1) == 0);
	}

	@Test
	public void testToString() {
		Card c2 = new Card(Rank.DEUCE, Suit.CLUBS);
		assertEquals("2" + '\u2663', c2.toString());
		Card c3 = new Card(Rank.THREE, Suit.DIAMONDS);
		assertEquals("3" + '\u2666', c3.toString());
		Card c4 = new Card(Rank.FOUR, Suit.HEARTS);
		assertEquals("4" + '\u2665', c4.toString());
		Card c5 = new Card(Rank.KING, Suit.HEARTS);
		assertEquals("K" + '\u2665', c5.toString());
	}
	
	@Test 
	public void checkArraySort() {
		Card c2 = new Card(Rank.DEUCE, Suit.CLUBS);
		assertEquals("2" + '\u2663', c2.toString());
		Card c3 = new Card(Rank.THREE, Suit.DIAMONDS);
		assertEquals("3" + '\u2666', c3.toString());
		Card c4 = new Card(Rank.FOUR, Suit.HEARTS);
		assertEquals("4" + '\u2665', c4.toString());
		Card c5 = new Card(Rank.KING, Suit.HEARTS);
		assertEquals("K" + '\u2665', c5.toString());
		Card c6 = new Card(Rank.ACE, Suit.HEARTS);
		
		ArrayList<Card> hand = new ArrayList<Card>();
		hand.add(c6);
		hand.add(c2);
		hand.add(c3);
		hand.add(c5);
		Collections.sort(hand);
		hand.add(c4);
		System.out.print(hand);
		
	}
	@Test
	public void testEquals() {
		Card c1 = new Card(Rank.DEUCE, Suit.CLUBS);
		Card c2 = new Card(Rank.THREE, Suit.DIAMONDS);
		Card c3 = new Card(Rank.DEUCE, Suit.CLUBS);

		assertFalse(c1.equals(c2));
		assertFalse(c3.equals(c2));
		assertTrue(c1.equals(c3));
	}

}