package model;

import java.util.ArrayList;

import java.util.Collections;

public class SortICA {

	// Set up some arbitrary Poker Hands

	private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);

	private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);

	private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);

	private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);

	private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);

	private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
	private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);

	private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);

	private final static Card CK = new Card(Rank.KING, Suit.CLUBS);

	private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

	private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);

	private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);

	private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
	private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);

	private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);

	private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);

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

	public static void main(String[] args) {

		PokerHand a = new PokerHand(D2, C3, H5, H9, H8);

		PokerHand b = new PokerHand(D4, C4, H4, H7, HA);

		PokerHand c = new PokerHand(D4, C4, H4, H9, H8);

		PokerHand d = new PokerHand(D4, C4, H4, H9, H6);

		PokerHand e = new PokerHand(D4, C4, H4, H9, H8);

		PokerHand f = new PokerHand(D4, C4, H4, H9, H2);

		PokerHand g = new PokerHand(S6, D6, D2, CA, H3);

		PokerHand h = new PokerHand(S3, D3, S9, CA, H4);

		PokerHand i = new PokerHand(S6, D6, D4, CA, H5);

		PokerHand j = new PokerHand(C6, H9, D6, CQ, H6);

		PokerHand k = new PokerHand(S6, D6, C3, CK, H7);

		PokerHand l = new PokerHand(C7, H7, C4, C3, H8);

		PokerHand m = new PokerHand(S6, D7, C5, C7, H9);

		ArrayList<PokerHand> hands = new ArrayList<>();

		hands.add(a);

		hands.add(b);

		hands.add(c);

		hands.add(d);

		hands.add(e);

		hands.add(f);

		hands.add(g);

		hands.add(h);

		hands.add(i);

		hands.add(j);

		hands.add(k);

		hands.add(l);

		hands.add(m);

		ArrayList<Card> Community = new ArrayList<Card>();
		Community.add(H6);
		Community.add(S3);
		Community.add(HA);
		Community.add(HJ);
		Community.add(H8);
		ArrayList<Card> personal1 = new ArrayList<Card>();
		personal1.add(C3);
		personal1.add(D5);
		Player test1 = new Player(Community, personal1);
		System.out.println(test1.bestHand());
		ArrayList<Card> personal2 = new ArrayList<Card>();
		personal2.add(HK);
		personal2.add(S6);
		Player test2 = new Player(Community, personal2);
		System.out.println(test2.bestHand());
		ArrayList<Card> personal3 = new ArrayList<Card>();
		personal3.add(S9);
		personal3.add(C10);
		Player test3 = new Player(Community, personal3);
		System.out.print(test3.bestHand());

		Collections.shuffle(hands);

		Collections.sort(hands);

	}

}