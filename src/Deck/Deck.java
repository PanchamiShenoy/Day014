package Deck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckOfCard deck = new DeckOfCard();
		ArrayList<Card> cards = deck.getCards();
		int players = 4;
		int numOfCards = 9;
		int index = 0;
		for (int i = 1; i <= players; i++) {
			System.out.println("player" + i);
			for (int j = 1; j <= numOfCards; j++) {
				System.out.println(cards.get(index++));
			}
		}
	}

}

class Card {

	private final String suit;
	private final String rank;

	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}

}

class DeckOfCard {

	private static final String suits[] = { "clubs", "diamonds", "hearts", "spades" };
	private static final String ranks[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king",
			"ace" };
	private final ArrayList<Card> cards;

	/*
	 * method to create new cards and shuffle
	 */
	public DeckOfCard() {
		cards = new ArrayList<Card>();
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				this.cards.add(new Card(suits[i], ranks[j]));
			}
		}

		for (int i = 0; i < cards.size(); i++) {
			int index = (int) (Math.random() * cards.size());
			Card card1 = cards.get(i);
			Card card2 = cards.get(index);
			cards.set(i, card2);
			cards.set(index, card1);

		}

	}

	/*
	 * method to return list of cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}

}
