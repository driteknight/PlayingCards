package player;

import java.util.ArrayList;

import card.Card;
import card.Hand;
import diamond.DiamondHeartsHand;
import diamond.strategy.RandomStrategy;
import diamond.strategy.Strategy;

public abstract class Player {
	protected int points;
	protected Hand hand;

	public int getPoints() {
		return points;
	}

	public Hand getHand() {
		return hand;
	}

	public void addPoint(int num) {
		this.points += num;
	}

	public void addCards(ArrayList<Card> cards) {
		for (Card card : cards) {
			hand.addCard(card);
		}
	}

	public void removeCard(Card c) {
		hand.removeCard(c);
	}
}
