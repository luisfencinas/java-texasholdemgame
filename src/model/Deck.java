package model;

import java.util.ArrayList;
import java.util.Collections;

//@author Luis F Encinas
public class Deck {
	private ArrayList<Card> pile = new ArrayList<Card>();
	private int topCard = 0;

	public Deck() {
		for (Rank rank : Rank.values()) {
			for (Suit suits : Suit.values()) {
				Card newCard = new Card(rank, suits);
				pile.add(newCard);
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(pile);
	}

	public int cardsLeft() {
		return 52 - topCard;
	}

	public ArrayList<Card> returnCards(int numOfCards) {
		ArrayList<Card> toReturn = new ArrayList<Card>();
		for (int i = 0; i < numOfCards; i++) {
			toReturn.add(pile.get(topCard));
			topCard = topCard += 1;
		}
		return toReturn;
	}

	public void reset() {
		topCard = 0;
	}
}
