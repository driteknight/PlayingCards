package rummy;

import java.util.ArrayList;

import card.Card;
import card.Hand;

public abstract class Sequence{
	int numOfCards;
	ArrayList<Card> cards;
	public ArrayList<Card> getCards() {
		return cards;
	}
	abstract public void isExtendable(Card c, int max);
	abstract public void addCard(Card c);
	abstract public boolean isValidSequence(int max);
}
