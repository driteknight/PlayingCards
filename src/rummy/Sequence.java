package rummy;

import java.util.ArrayList;

import card.Card;

public abstract class Sequence{
	
	
	int numOfCards;
	ArrayList<Card> cards;
	public ArrayList<Card> getCards() {
		return cards;
	}
	abstract public boolean isExtendable(Card c, int max);
	abstract public void addCard(Card c, int max);
	abstract public boolean isValidSequence(int max);
	
	public boolean isOverlapping(Sequence s) {
		for(Card card1 : cards) {
			for(Card card2 : s.cards) {
				if(card1 == card2) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public int getNumOfCards() {
		return cards.size();
	}
	
	public String toString() {
		return cards.toString();
	}
}
