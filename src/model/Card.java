package model;

/**
 * class Card represents one of the 52 poker cards. There are no comments before
 * methods because the method name says it all.
 * 
 * @author Rick Mercer and Luis Encinas
 */

public class Card implements Comparable<Card> {
	private final Rank rank;
	private final Suit suit;

	// Constructor
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	public int getValue() {
		return rank.getValue();
	}

	public String toString() {
		// Use these four Unicode icons for the solid suit icons.
		char suitIcon = '\u2663';
		if (suit == Suit.DIAMONDS)
			suitIcon = '\u2666';
		if (suit == Suit.HEARTS)
			suitIcon = '\u2665';
		if (suit == Suit.SPADES)
			suitIcon = '\u2660';

		// Need to get the value instead of "?"
		int rankValue = rank.getValue();
		if (rankValue == 11) {
			return "J" + suitIcon;
		}
		if (rankValue == 12) {
			return "Q" + suitIcon;
		}
		if (rankValue == 13) {
			return "K" + suitIcon;
		}
		if (rankValue == 14) {
			return "A" + suitIcon;
		}
		return String.valueOf(rankValue) + suitIcon;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Card)) {
			return false;
		}
		Card card = (Card) other;
		if (this.getRank() == card.getRank() && this.getSuit() == card.getSuit()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Card other) {
		Integer ourValue = this.getValue();
		Integer otherValue = other.getValue();
		return ourValue.compareTo(otherValue);
	}

}