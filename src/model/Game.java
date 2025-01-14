package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//@author Luis F Encinas
public class Game {
	private int numOfPlayers;
	private int numOfWinners;
	private ArrayList<Card> community;
	private PokerHand winner;
	private ArrayList<Double> tabs = new ArrayList<Double>();
	private Deck ourDeck;
	private ArrayList<Player> players;
	private Double potValue;

	public void start() {
		// TODO Auto-generated method stub
		Scanner playerInput = new Scanner(System.in);
		System.out.print("How many players? ");
		numOfPlayers = playerInput.nextInt();
		System.out.println("");
		buildTab();
		potValue = (2.00 * numOfPlayers);
		ourDeck = new Deck();
		match(playerInput);
		playerInput.close();
	}

	private void match(Scanner keyboard) {
		// puts our deck back together
		ourDeck.reset();
		// gives a brand new shuffled deck for the match
		ourDeck.shuffle();
		// Charges the players $2 to play
		chargeBid();
		// Gives all players two cards, and then creates community pile
		buildPlayers();
		// Gets the max hand
		findWinnerHand();
		// Finds the amount of winners to calculate if split pot
		findWinners();
		// prints all current player info under community cards
		printPlayerInfo();
		// prints either ties of hands or single winner
		if (numOfWinners > 1) {
			printWinners();
		} else {
			printSingleWinner();
		}
		// prompts player to play again
		System.out.print("Play another game? <y or n> ");
		// takes in their response as string
		String play = keyboard.next();
		System.out.println();
		// checks if yes, plays again if so with recursion
		if (play.equals("y")) {
			match(keyboard);
		}
	}

	private String communityCards() {
		// goes through community cards and converts string properly
		String cards = "";
		for (int i = 0; i < 4; i++) {
			cards = cards + community.get(i) + " ";
		}
		cards = cards + community.get(4);
		return "Community Cards: " + cards;
	}

	private void buildTab() {
		// builds tab based on amount of players
		for (int i = 1; i < numOfPlayers + 1; i++) {
			tabs.add(100.00);
		}
	}

	private void buildPlayers() {
		// Create array of players
		players = new ArrayList<Player>();
		// Creates list of card lists to give to players later
		ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>();
		for (int i = 1; i < numOfPlayers + 1; i++) {
			hands.add(ourDeck.returnCards(2));
		}
		// creates community pile
		community = ourDeck.returnCards(5);
		for (int i = 0; i < numOfPlayers; i++) {
			// assigns each player their pulled personal hand
			players.add(new Player(community, hands.get(i)));
		}
	}

	private void chargeBid() {
		// Goes through all players and charges playing fee of $2
		ArrayList<Double> newTabs = new ArrayList<Double>();
		for (int i = 0; i < numOfPlayers; i++) {
			Double oldValue = tabs.get(i);
			newTabs.add(oldValue - 2.00);
		}
		tabs = newTabs;
	}

	private void findWinnerHand() {
		// gets best hand from players
		winner = Collections.max(players).bestHand();
	}

	private void findWinners() {
		// goes through and finds winner count
		int win = 0;
		for (int i = 0; i < numOfPlayers; i++) {
			if (players.get(i).bestHand().compareTo(winner) == 0) {
				win += 1;
			}
		}
		numOfWinners = win;
	}

	private void printPlayerInfo() {
		// prints community string
		System.out.println(communityCards());
		System.out.println();
		// goes and prints each player in order
		for (int i = 0; i < numOfPlayers; i++) {
			System.out.println("Player " + String.valueOf(i + 1) + ": $" + String.format("%.2f", tabs.get(i)) + " - "
					+ players.get(i).getPersonalHand());
			System.out.println("   Best Hand:  " + players.get(i).bestHand() + " - " + players.get(i).getRank());
			System.out.println();
		}
	}

	private void printSingleWinner() {
		// adds gains to winner
		Double gains = potValue;
		for (int i = 0; i < numOfPlayers; i++) {
			if (players.get(i).bestHand().compareTo(winner) == 0) {
				tabs.set(i, tabs.get(i) + gains);
				System.out
						.println("Winner: Player " + String.valueOf(i + 1) + " $" + String.format("%.2f", tabs.get(i)));
				System.out.println(players.get(i).bestHand() + "    " + players.get(i).getRank());
				break;
			}
		}
	}

	private Double calculatePot() {
		// if multiple winners, need to calculate it
		Double value = potValue / numOfWinners;
		Double multiplied = value * 100;
		long rounded = Math.round(multiplied);
		Double result = (double) rounded / 100;
		return result;
	}

	private void printWinners() {
		// goes through and finds winners, at same time updates their money
		Double gains = calculatePot();
		System.out.println("Winning hands (tie)");
		for (int i = 0; i < numOfPlayers; i++) {
			if (players.get(i).bestHand().compareTo(winner) == 0) {
				tabs.set(i, tabs.get(i) + gains);
				System.out.println(players.get(i).bestHand() + " " + players.get(i).getRank() + " Player "
						+ String.valueOf(i + 1) + " $" + String.format("%.2f", tabs.get(i)));
			}
		}
	}
}
