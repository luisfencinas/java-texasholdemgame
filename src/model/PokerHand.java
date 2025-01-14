package model;

import java.util.ArrayList;
import java.util.Collections;

//@author: Luis F Encinas
public class PokerHand implements Comparable<PokerHand> {
	public int highestSolo = 0;
	public ArrayList<Card> hand = new ArrayList<Card>();
	public int handRating = 1;
	public boolean oneSuit = true;
	public boolean inOrder = false;
	public int fours = 0;
	public int threes = 0;
	public int higherTwo = 0;
	public int lowerTwo = 0;

	public PokerHand(Card s6, Card d7, Card da, Card ca, Card ha) {
		// TODO Complete this constructor.
		// Recommended: Store 5 Card objects in a sorted ArrayList<Card>
		hand.add(s6);
		if (hand.contains(d7)) {
			throw new IllegalArgumentException();
		}
		hand.add(d7);
		if (hand.contains(da)) {
			throw new IllegalArgumentException();
		}
		hand.add(da);
		if (hand.contains(ca)) {
			throw new IllegalArgumentException();
		}
		hand.add(ca);
		if (hand.contains(ha)) {
			throw new IllegalArgumentException();
		}
		hand.add(ha);
		Collections.sort(hand);
		this.checkOneSuit();
		this.checkInOrder();
		this.checkDups();
		this.setRating();

	}

	private void checkOneSuit() {
		for (int i = 0; i < 4; i++) {
			if (hand.get(i).getSuit() != hand.get(i + 1).getSuit()) {
				oneSuit = false;
			}
		}
	}

	private void checkInOrder() {
		if (this.inOrder(hand) == true) {
			inOrder = true;
		}
	}

	private boolean inOrder(ArrayList<Card> list) {
		for (int i = 0; i < 4; i++) {
			if ((list.get(i + 1).getRank().getValue() - (list.get(i)).getRank().getValue()) != 1) {
				return false;
			}
		}
		return true;
	}

	private void checkDups() {
		int currentCount = 1;
		int currentValue = hand.get(0).getValue();
		for (int i = 1; i < 5; i++) {
			if (hand.get(i).getValue() == currentValue) {
				currentCount += 1;

			} else {
				this.updateDups(currentCount, currentValue);
				currentCount = 1;
				currentValue = hand.get(i).getValue();
			}
		}
		this.updateDups(currentCount, currentValue);

	}

	private void updateDups(int count, int value) {
		if (count == 2) {
			if (lowerTwo == 0) {
				lowerTwo = value;
				higherTwo = value;
			}
			if (value > higherTwo) {
				higherTwo = value;
			}

		}
		if (count == 3) {
			threes = value;
		}
		if (count == 4) {
			fours = value;
		}
		if (count == 1) {
			highestSolo = value;
		}
	}

	public void setRating() {
		boolean foundRank = false;
		foundRank = checkIfStraightFlush();
		if (foundRank == false) {
			foundRank = checkIfFourOfAKind();
		}
		if (foundRank == false) {
			foundRank = checkIfFull();
		}

		if (foundRank == false) {
			foundRank = checkIfFlush();
		}

		if (foundRank == false) {
			foundRank = checkIfStraight();
		}

		if (foundRank == false) {
			foundRank = checkIfThreeOfAKind();
		}

		if (foundRank == false) {
			foundRank = this.checkIfTwoPair();
		}

		if (foundRank == false) {
			foundRank = checkIfPair();
		}
	}

	private boolean checkIfStraightFlush() {
		if (this.inOrder && this.oneSuit) {
			this.handRating = 9;
			return true;
		}
		return false;
	}

	private boolean checkIfFourOfAKind() {
		if (this.fours != 0) {
			this.handRating = 8;
			return true;
		}
		return false;
	}

	private boolean checkIfFull() {
		if (this.threes != 0 && this.lowerTwo != 0) {
			this.handRating = 7;
			return true;
		}
		return false;
	}

	private boolean checkIfFlush() {
		if (this.oneSuit) {
			this.handRating = 6;
			return true;
		}
		return false;
	}

	private boolean checkIfStraight() {
		if (this.inOrder) {
			this.handRating = 5;
			return true;
		}
		return false;
	}

	private boolean checkIfThreeOfAKind() {
		if (this.threes != 0) {
			this.handRating = 4;
			return true;
		}
		return false;
	}

	private boolean checkIfTwoPair() {
		if (lowerTwo != 0) {
			if (lowerTwo != higherTwo) {
				this.handRating = 3;
				return true;
			}
		}
		return false;
	}

	private boolean checkIfPair() {
		if (lowerTwo != 0) {
			this.handRating = 2;
			return true;
		}
		return false;
	}

	private boolean identicalHands(PokerHand other) {
		for (int i = 0; i < 5; i++) {
			if (this.hand.get(i).getRank() != other.hand.get(i).getRank()) {
				return false;
			}
		}
		return true;
	}

	private int checkHigher(PokerHand o) {
		for (int i = 4; i > -1; i--) {
			if (o.hand.get(i).getRank().getValue() < this.hand.get(i).getRank().getValue()) {
				return 1;
			}
			if (o.hand.get(i).getRank().getValue() > this.hand.get(i).getRank().getValue()) {
				break;
			}
		}
		return -1;
	}

	private int compareType(PokerHand other, int rank) {
		if (identicalHands(other)) {
			return 0;
		}
		if (rank == 9 || rank == 5) {
			return compareStraight(other);
		}
		if (rank == 8) {
			return compareFour(other);
		}
		if (rank == 7) {
			return compareFull(other);
		}
		if (rank == 4) {
			return compareThree(other);
		}

		if (rank == 3 || rank == 2) {
			return compareTwos(other);
		}
		return checkHigher(other);
	}

	private int compareStraight(PokerHand o) {
		if (this.highestSolo > o.highestSolo) {
			return 1;
		}
		return -1;
	}

	private int compareFour(PokerHand o) {
		if (this.fours != o.fours) {
			if (this.fours > o.fours) {
				return 1;
			}
			return -1;
		}
		if (this.highestSolo > o.highestSolo) {
			return 1;
		}
		return -1;
	}

	private int compareFull(PokerHand o) {
		if (this.threes != o.threes) {
			if (this.threes > o.threes) {
				return 1;
			}
			return -1;
		} else {
			if (this.higherTwo > o.higherTwo) {
				return 1;
			}
			return -1;
		}
	}

	private int compareThree(PokerHand o) {
		if (this.threes != o.threes) {
			if (this.threes > o.threes) {
				return 1;
			}
			return -1;
		}
		return checkHigher(o);
	}

	private int compareTwos(PokerHand o) {
		if (this.higherTwo != o.higherTwo) {
			if (this.higherTwo > o.higherTwo) {
				return 1;
			}
			return -1;
		}
		if (this.lowerTwo != o.lowerTwo) {
			if (this.lowerTwo > o.lowerTwo) {
				return 1;
			}
			return -1;
		}
		return checkHigher(o);
	}

	@Override
	public String toString() {
		String values = hand.get(0).toString();
		for (int i = 1; i < 5; i++) {
			values += " " + hand.get(i).toString();
		}
		return values;
	}

	@Override
	public int compareTo(PokerHand o) {
		// TODO Complete this method, which will take many hours and many many @Tests
		if (this.handRating != o.handRating) {
			if (this.handRating > o.handRating) {
				return 1;
			}
			return -1;
		}
		return compareType(o, this.handRating);
	}

}
