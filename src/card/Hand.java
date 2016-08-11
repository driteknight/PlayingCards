package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

abstract public class Hand {
	protected ArrayList<Card> cardsInHand;

	public ArrayList<Card> getCardsInHands() {
		return cardsInHand;
	}
	
	public void addCard(Card c) {
		cardsInHand.add(c);
	}

	public Card removeCard(Card c) {
		cardsInHand.remove(c);
		return c;
	}

	public ArrayList<Card> getCardsInHand() {
		return this.cardsInHand;
	}

	public ArrayList<Card> getAllDiamonds() {
		ArrayList<Card> allDiamonds = new ArrayList<Card>();
		for (Card c : cardsInHand) {
			if (c.getSuit().equals("DIAMOND")) {
				allDiamonds.add(c);
			}
		}
		return allDiamonds;
	}

	public void shuffle() {
		Collections.shuffle(cardsInHand);
	}

	public ArrayList<Card> getAllSpades() {
		ArrayList<Card> allSpades = new ArrayList<Card>();
		for (Card c : cardsInHand) {
			if (c.getSuit().equals("SPADE")) {
				allSpades.add(c);
			}
		}
		return allSpades;
	}

	public ArrayList<Card> getAllClubs() {
		ArrayList<Card> allClubs = new ArrayList<Card>();
		for (Card c : cardsInHand) {
			if (c.getSuit().equals("CLUB")) {
				allClubs.add(c);
			}
		}
		return allClubs;
	}

	public ArrayList<Card> getAllHearts() {
		ArrayList<Card> allHearts = new ArrayList<Card>();
		for (Card c : cardsInHand) {
			if (c.getSuit().equals("HEART")) {
				allHearts.add(c);
			}
		}
		return allHearts;
	}

	public ArrayList<Card> getCardsOfValue(int value) {
		ArrayList<Card> cardsOfSameValue = new ArrayList<>();
		for (Card card : cardsInHand) {
			if (card.getValue() == value) {
				cardsOfSameValue.add(card);
			}
		}

		return cardsOfSameValue;
	}

	public String toString() {
		return cardsInHand.toString();
	}

	public void sortBySuit() {
		this.cardsInHand.sort((Card c1, Card c2) -> c1.getSuit().compareTo(c2.getSuit()));
	}

	public void sortByValue() {
		this.cardsInHand.sort((Card c1, Card c2) -> c1.getValue() - c2.getValue());
	}

	public void sortBySuitAndValue() {
		this.cardsInHand.sort(new Comparator<Card>() {

			public int compare(Card o1, Card o2) {
				if (o1.isSameSuit(o2)) {
					return o1.getValue() - o2.getValue();
				} else {
					return o1.getSuit().compareTo(o2.getSuit());
				}
			}
		});
	}

	public int numOfCardsInHand() {
		return cardsInHand.size();
	}

}
