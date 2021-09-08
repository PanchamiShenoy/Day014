package Deck;

import java.util.Collections;

import java.util.*;

public class Deck {

	public static void main(String[] args) {
		Deck1 deck = new Deck1();
		String[] arr = deck.getCards();
		distributeCards(arr, 4, 9);
	}

	/*
	 * method to distribute cards among players
	 */
	public static void distributeCards(String[] arr, int numOfPlayer, int numOfCards) {

		String[][] array = new String[numOfPlayer][numOfCards];
		int k = 0;

		for (int i = 0; i < numOfPlayer; i++) {
			System.out.println("\nPlayer " + (i + 1));
			for (int j = 0; j < numOfCards; j++) {

				array[i][j] = arr[k++];
				System.out.println(array[i][j]);
			}
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
