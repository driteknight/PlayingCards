package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DiscardPile {
	private ArrayList<Card> cardsInDiscardPile;

	public DiscardPile() {
		cardsInDiscardPile = new ArrayList<>();
		;
	}

	public DiscardPile(ArrayList<Card> list) {
		cardsInDiscardPile = new ArrayList<>();
		cardsInDiscardPile.addAll(list);
	}

	public void addCard(Card card) {
		cardsInDiscardPile.add(card);
	}

	public Card removeCard() {
		Card c = cardsInDiscardPile.get(cardsInDiscardPile.size() - 1);
		return c;
	}

	public void shuffle() {
		Collections.shuffle(cardsInDiscardPile);
	}

	public Deck convertToDeck() {
		Deck deck = new Deck(cardsInDiscardPile);
		deck.shuffle();
		return deck;
	}

	public ArrayList<Card> getCardsInDiscardPile() {
		return cardsInDiscardPile;
	}

	public void sortBySuit() {
		this.cardsInDiscardPile.sort((Card c1, Card c2) -> c1.getSuit().compareTo(c2.getSuit()));
	}

	public void sortByValue() {
		this.cardsInDiscardPile.sort((Card c1, Card c2) -> c1.getValue() - c2.getValue());
	}

	public void sortBySuitAndValue() {
		this.cardsInDiscardPile.sort(new Comparator<Card>() {

			public int compare(Card o1, Card o2) {
				if (o1.isSameSuit(o2)) {
					return o1.getValue() - o2.getValue();
				} else {
					return o1.getSuit().compareTo(o2.getSuit());
				}
			}
		});
	}

	public ArrayList<Card> getAllDiamonds() {
		ArrayList<Card> allDiamonds = new ArrayList<Card>();
		for (Card c : cardsInDiscardPile) {
			if (c.getSuit().equals("DIAMOND")) {
				allDiamonds.add(c);
			}
		}
		return allDiamonds;
	}

	public ArrayList<Card> getAllSpades() {
		ArrayList<Card> allSpades = new ArrayList<Card>();
		for (Card c : cardsInDiscardPile) {
			if (c.getSuit().equals("SPADE")) {
				allSpades.add(c);
			}
		}
		return allSpades;
	}

	public ArrayList<Card> getAllClubs() {
		ArrayList<Card> allClubs = new ArrayList<Card>();
		for (Card c : cardsInDiscardPile) {
			if (c.getSuit().equals("CLUB")) {
				allClubs.add(c);
			}
		}
		return allClubs;
	}

	public ArrayList<Card> getAllHearts() {
		ArrayList<Card> allHearts = new ArrayList<Card>();
		for (Card c : cardsInDiscardPile) {
			if (c.getSuit().equals("HEART")) {
				allHearts.add(c);
			}
		}
		return allHearts;
	}

	public ArrayList<Card> getCardsOfValue(int value) {
		ArrayList<Card> cardsOfSameValue = new ArrayList<>();
		for (Card card : cardsInDiscardPile) {
			if (card.getValue() == value) {
				cardsOfSameValue.add(card);
			}
		}

		return cardsOfSameValue;
	}

	public int numOfCardsInDiscardPile() {
		return cardsInDiscardPile.size();
	}
}
