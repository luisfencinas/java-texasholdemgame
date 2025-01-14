package model;

import java.util.ArrayList;
import java.util.Collections;

//@Author Luis Encinas
public class Player implements Comparable<Player> {
	private ArrayList<Card> personalHand;
	private ArrayList<Card> totalCards;
	private ArrayList<PokerHand> totalHands = new ArrayList<PokerHand>();
	private String rank;

	public Player(ArrayList<Card> community, ArrayList<Card> personal) {
		// passes task to fresh hand
		this.freshHand(community, personal);
	}

	private void freshHand(ArrayList<Card> community, ArrayList<Card> personal) {
		// goes through assigning players personal hand, then getting list of total
		// cards
		personalHand = personal;
		ArrayList<Card> tots = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			tots.add(community.get(i));
		}
		tots.add(personal.get(0));
		tots.add(personal.get(1));
		totalCards = tots;
		// sorts cards and then sends to find all hands
		Collections.sort(totalCards);
		findAllHands();
		// sets our rank based on our best hand
		setRank();
	}

	private void findAllHands() {
		ArrayList<Card> c = new ArrayList<Card>();
		// sets the first and second card to not look at for each cycle
		// then adds all the other cards to make a hand, repeats until every
		// possible hand is made
		for (int firstCard = 0; firstCard < 7; firstCard++) {
			for (int secondCard = 0; secondCard < 7; secondCard++) {
				if (firstCard != secondCard) {
					for (int currentCard = 0; currentCard < 7; currentCard++) {
						if (currentCard != secondCard && currentCard != firstCard) {
							c.add(totalCards.get(currentCard));
						}
					}
					PokerHand newlyMade = new PokerHand(c.get(0), c.get(1), c.get(2), c.get(3), c.get(4));
					totalHands.add(newlyMade);
					ArrayList<Card> fresh = new ArrayList<Card>();
					c = fresh;
				}
			}
		}
		// sorts our list making the last card our greatest
		Collections.sort(totalHands);
	}

	private void setRank() {
		// based on our hand we can use this when printing later
		int handRank = bestHand().handRating;
		if (handRank == 9) {
			if (bestHand().highestSolo == 14) {
				rank = "Royal Flush";
			}
			rank = "Straight Flush";
		}
		if (handRank == 8) {
			rank = "Four of a kind";
		}
		if (handRank == 7) {
			rank = "Full House";
		}
		if (handRank == 6) {
			rank = "Flush";
		}
		if (handRank == 5) {
			rank = "Straight";
		}
		if (handRank == 4) {
			rank = "Three of a kind";
		}
		if (handRank == 3) {
			rank = "Two Pair";
		}
		if (handRank == 2) {
			rank = "Pair";
		}
		if (handRank == 1) {
			rank = "High Card";
		}
	}

	public String getRank() {
		// returns our rank when needed
		return rank;
	}

	public PokerHand bestHand() {
		// get best hand
		return Collections.max(totalHands);
	}

	public String getPersonalHand() {
		// return string of our two cards
		return personalHand.get(0).toString() + " " + personalHand.get(1).toString();
	}

	@Override
	public int compareTo(Player o) {
		// compares players by the best hand they possess
		return this.bestHand().compareTo(o.bestHand());
	}
}
