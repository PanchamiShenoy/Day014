package Deck;

import java.util.Collections;

import java.util.*;

public class Deck {

	public static void main(String[] args) {
		Deck1 deck = new Deck1();
		String[] arr = deck.getCards();
		Players player[] = new Players[4];
		ArrayList<Integer> cardList = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			System.out.println("\nPlayer " + (i + 1) + " cards:");
			player[i] = new Players();
			int cardCount = 0;
			while (cardCount < 9) {
				int randomValue = (int) (Math.random() * arr.length);
				if (cardList.contains(randomValue) == false) {
					player[i].cards.add(arr[randomValue]);
					cardList.add(randomValue);
					cardCount++;
				}
			}
			player[i].cards.print();
			System.out.println();
		}
	}

}

class Deck1 {

	private static final String suits[] = { "Club", "Diamond", "Heart", "Spade" };
	private static final String ranks[] = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King" };
	private String[] cards = new String[52];

	/*
	 * initialise and shuffle cards
	 */
	public Deck1() {
		int k = 0;
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				cards[k++] = suits[i] + " - " + ranks[j];
			}
		}

		for (int i = 0; i < 52; i++) {
			int index = (int) (Math.random() * k);
			String temp1 = cards[i];
			String temp2 = cards[index];
			cards[index] = temp1;
			cards[i] = temp2;
		}

	}

	/*
	 * method to return cards
	 */
	public String[] getCards() {
		return cards;
	}
}
