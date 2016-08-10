package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck(int numberOfPacks, int numberOfJokers) {
		cardsInDeck = new ArrayList<>();

		for (int i = 0; i < numberOfPacks; ++i) {
			Pack p = new Pack(numberOfJokers);
			cardsInDeck.addAll(p.getCardsFromPack());
		}

	}

	public Deck(int numberOfPacks) {
		cardsInDeck = new ArrayList<>();

		for (int i = 0; i < numberOfPacks; ++i) {
			Pack p = new Pack(0);
			cardsInDeck.addAll(p.getCardsFromPack());
		}
	}

	public Deck(ArrayList<Card> list) {
		cardsInDeck = new ArrayList<>();
		cardsInDeck.addAll(list);
	}

	public boolean isEmpty() {
		return cardsInDeck.size() == 0;
	}

	public void shuffle() {
		Collections.shuffle(cardsInDeck);
	}

	public Card removeCardOnTop() {
		Card c = cardsInDeck.get(0);
		cardsInDeck.remove(c);
		return c;
	}
	
	

	public ArrayList<Card> getAllDiamonds() {
		ArrayList<Card> allDiamonds = new ArrayList<Card>();
		for (Card c : cardsInDeck) {
			if (c.getSuit().equals("DIAMOND")) {
				allDiamonds.add(c);
			}
		}
		return allDiamonds;
	}

	public ArrayList<Card> getAllSpades() {
		ArrayList<Card> allSpades = new ArrayList<Card>();
		for (Card c : cardsInDeck) {
			if (c.getSuit().equals("SPADE")) {
				allSpades.add(c);
			}
		}
		return allSpades;
	}

	public ArrayList<Card> getAllClubs() {
		ArrayList<Card> allClubs = new ArrayList<Card>();
		for (Card c : cardsInDeck) {
			if (c.getSuit().equals("CLUB")) {
				allClubs.add(c);
			}
		}
		return allClubs;
	}

	public ArrayList<Card> getAllHearts() {
		ArrayList<Card> allHearts = new ArrayList<Card>();
		for (Card c : cardsInDeck) {
			if (c.getSuit().equals("HEART")) {
				allHearts.add(c);
			}
		}
		return allHearts;
	}

	public ArrayList<Card> getCardsOfValue(int value) {
		ArrayList<Card> cardsOfSameValue = new ArrayList<>();
		for (Card card : cardsInDeck) {
			if (card.getValue() == value) {
				cardsOfSameValue.add(card);
			}
		}

		return cardsOfSameValue;
	}
	
	public void sortBySuit() {
		this.cardsInDeck.sort((Card c1,Card c2) -> c1.getSuit().compareTo(c2.getSuit()));
	}
	
	public void sortByValue() {
		this.cardsInDeck.sort((Card c1, Card c2) -> c1.getValue() - c2.getValue());
	}
	
	public void sortBySuitAndValue() {
		this.cardsInDeck.sort(new Comparator<Card>() {

			public int compare(Card o1, Card o2) {
				if(o1.isSameSuit(o2)) {
					return o1.getValue() - o2.getValue();
				} else {
					return o1.getSuit().compareTo(o2.getSuit());
				}
			}
		});
	}
	
	public ArrayList<Card> pick(int n) {
		ArrayList<Card> pickedCards = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			pickedCards.add(removeCardOnTop());
		}
		return pickedCards;
	}
	
	public int numOfCardsInDeck() {
		return cardsInDeck.size();
	}
}
