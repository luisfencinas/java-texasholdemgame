package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Card;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the CardHand class, last modified Sep 2015, June 2017, July 23, August
 * 23
 * 
 * I think this a pretty good unit test, if you add any other test cases please
 * send them to me!
 * 
 * I am providing all 52 possible Cars to save you time writing @Tests
 * 
 * @author Rick Mercer and Luis Encinas
 */
public class PokerHandTest {

	// This file contains all 52 cards to save you time with names like
	// C2 for the two of clubs
	// AS for the ace of spades

	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
	private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
	private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
	private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
	private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
	private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
	private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
	private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
	private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
	private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
	private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
	private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
	private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
	private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

	private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
	private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
	private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
	private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
	private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
	private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
	private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
	private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
	private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
	private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
	private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
	private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
	private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

	private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
	private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
	private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
	private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
	private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
	private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
	private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
	private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
	private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
	private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
	private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
	private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
	private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

	private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
	private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
	private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
	private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
	private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
	private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
	private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
	private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
	private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
	private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
	private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
	private final static Card SK = new Card(Rank.KING, Suit.SPADES);
	private final static Card SA = new Card(Rank.ACE, Suit.SPADES);

	@Test
	public void testHighCard1() {
		PokerHand a = new PokerHand(C3, C4, D6, D7, DA);
		PokerHand b = new PokerHand(C2, C5, C7, DQ, DK);
		assertEquals(1, a.compareTo(b));
		assertEquals(-1, b.compareTo(a));
	}

	@Test
	public void testCardConstructor() {
		PokerHand a = new PokerHand(C3, D7, DA, C7, D6);
		assertEquals("[3♣, 6♦, 7♦, 7♣, A♦]", a.hand.toString());
		assertEquals("3♣ 6♦ 7♦ 7♣ A♦", a.toString());

	}

	@Test
	public void testThrowsExceptions() {
		assertThrows(IllegalArgumentException.class, () -> new PokerHand(C3, C3, DA, C7, D6));
		assertThrows(IllegalArgumentException.class, () -> new PokerHand(C3, C4, C4, C7, D6));
		assertThrows(IllegalArgumentException.class, () -> new PokerHand(C3, C4, DA, DA, D6));
		assertThrows(IllegalArgumentException.class, () -> new PokerHand(C3, C4, DA, C7, C7));
	}

	@Test
	public void testSameSuit() {
		PokerHand a = new PokerHand(CA, CK, DQ, CJ, C10);
		assertFalse(a.oneSuit);
		PokerHand b = new PokerHand(DA, DK, DQ, DJ, D10);
		assertTrue(b.oneSuit);

	}

	@Test
	public void testDifferientRanks() {
		PokerHand a = new PokerHand(CA, CK, SQ, CJ, C10);
		PokerHand b = new PokerHand(DA, DK, DQ, DJ, D10);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		assertTrue(b.handRating > a.handRating);
	}

	@Test
	public void testCompareStraights() {
		PokerHand a = new PokerHand(CK, CQ, CJ, C10, C9);
		PokerHand b = new PokerHand(DA, DK, DQ, DJ, D10);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		PokerHand c = new PokerHand(HK, CQ, CJ, C10, C9);
		PokerHand d = new PokerHand(HA, DK, DQ, DJ, D10);
		assertEquals(-1, c.compareTo(d));
		assertEquals(1, d.compareTo(c));
	}

	@Test
	public void testCompareFours() {
		PokerHand a = new PokerHand(CK, DK, SK, HK, C9);
		PokerHand b = new PokerHand(DA, CA, SA, HA, D10);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		assertEquals(0, a.compareTo(a));
		PokerHand c = new PokerHand(CK, DK, SK, HK, C9);
		PokerHand d = new PokerHand(CK, DK, SK, HK, C10);
		assertEquals(-1, c.compareTo(d));
		assertEquals(1, d.compareTo(c));
	}

	@Test
	public void testCompareThrees() {
		PokerHand a = new PokerHand(C3, DK, SK, HK, D10);
		PokerHand b = new PokerHand(D4, CA, SA, HA, D10);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		PokerHand c = new PokerHand(CK, DK, SK, H8, C9);
		PokerHand d = new PokerHand(CK, DK, SK, H8, C10);
		assertEquals(-1, c.compareTo(d));
		assertEquals(1, d.compareTo(c));
		PokerHand e = new PokerHand(CK, DK, SK, H8, C8);
		PokerHand f = new PokerHand(CK, DK, SK, HQ, CA);
		assertEquals(-1, c.compareTo(d));
		assertEquals(1, d.compareTo(c));
	}

	@Test
	public void testCompareTwoPair() {
		PokerHand a = new PokerHand(C8, D8, SK, HK, D9);
		PokerHand b = new PokerHand(D8, C8, SA, HA, D10);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		PokerHand c = new PokerHand(C7, DK, SK, H6, C6);
		PokerHand d = new PokerHand(C7, DK, SK, H8, C8);
		assertEquals(-1, c.compareTo(d));
		assertEquals(1, d.compareTo(c));
		PokerHand e = new PokerHand(CA, DK, SK, H8, C5);
		PokerHand f = new PokerHand(CA, DK, SK, H8, C6);
		assertEquals(-1, e.compareTo(f));
		assertEquals(1, f.compareTo(e));
	}

	@Test
	public void testComparePair() {
		PokerHand a = new PokerHand(C4, D8, SK, HK, D10);
		PokerHand b = new PokerHand(D4, C8, SA, HA, D10);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		PokerHand c = new PokerHand(C7, DK, SK, H8, C9);
		PokerHand d = new PokerHand(C7, DK, SK, H8, C10);
		assertEquals(-1, c.compareTo(d));
		assertEquals(1, d.compareTo(c));
	}

	@Test
	public void testCompareFullHouse() {
		PokerHand a = new PokerHand(CK, DK, SK, S10, C10);
		PokerHand b = new PokerHand(SA, CA, DA, S10, D10);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		PokerHand c = new PokerHand(CK, DK, SK, S10, C10);
		PokerHand d = new PokerHand(CK, DK, SK, DJ, HJ);
		assertEquals(-1, c.compareTo(d));
		assertEquals(1, d.compareTo(c));
	}

	@Test
	public void testFlush() {
		PokerHand a = new PokerHand(CK, DK, C6, C2, C4);
		PokerHand b = new PokerHand(D4, CA, DA, S10, D10);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		assertEquals(0, b.compareTo(b));
	}

	@Test
	public void testSameHands() {
		PokerHand a = new PokerHand(CA, CK, CQ, CJ, C10);
		PokerHand b = new PokerHand(DA, DK, DQ, DJ, D10);
		assertEquals(0, a.compareTo(b));
	}

	@Test

	public void testHighCards() {
		PokerHand a = new PokerHand(DA, C10, C7, H5, C3);
		PokerHand b = new PokerHand(DA, C10, C7, H5, C2);
		assertEquals(1, a.compareTo(b));
		assertEquals(-1, b.compareTo(a));
		PokerHand c = new PokerHand(DA, C10, C7, H4, C3);
		assertEquals(1, a.compareTo(c));
		assertEquals(-1, c.compareTo(a));
		PokerHand d = new PokerHand(DA, C9, C7, H5, C3);
		assertEquals(1, a.compareTo(d));
		assertEquals(-1, d.compareTo(a));
		PokerHand e = new PokerHand(DK, C10, C7, H5, C3);
		assertEquals(1, a.compareTo(e));
		assertEquals(-1, e.compareTo(a));

	}

	@Test
	public void testRanks() {
		PokerHand a = new PokerHand(CA, CK, CQ, CJ, C10);
		assertEquals(9, a.handRating);
		PokerHand b = new PokerHand(CA, DA, HA, S7, C7);
		assertEquals(7, b.handRating);
		PokerHand c = new PokerHand(CA, DA, HA, SA, C7);
		assertEquals(8, c.handRating);
		PokerHand d = new PokerHand(CA, CK, CQ, C2, C10);
		assertEquals(6, d.handRating);
		PokerHand e = new PokerHand(DA, CK, CQ, CJ, C10);
		assertEquals(5, e.handRating);
		PokerHand f = new PokerHand(DA, CA, SA, CJ, C10);
		assertEquals(4, f.handRating);
		PokerHand g = new PokerHand(DA, CA, SK, CK, C10);
		assertEquals(3, g.handRating);
		PokerHand h = new PokerHand(DA, C3, SK, CK, C10);
		assertEquals(2, h.handRating);
		PokerHand i = new PokerHand(C3, D7, DA, CK, D6);
		assertEquals(1, i.handRating);
	}

	@Test
	public void testDups() {
		PokerHand a = new PokerHand(SA, CA, D7, CQ, C10);
		assertEquals(a.higherTwo, a.lowerTwo);
		assertEquals(12, a.highestSolo);
		PokerHand b = new PokerHand(CA, DA, HA, S7, C10);
		assertEquals(0, b.lowerTwo);
		assertEquals(0, b.higherTwo);
		assertEquals(14, b.threes);
		assertEquals(0, b.fours);
	}

}