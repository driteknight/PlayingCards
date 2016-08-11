package player;

import java.util.ArrayList;

import card.Card;
import card.Hand;
import diamond.DiamondHeartsHand;
import diamond.strategy.RandomStrategy;
import diamond.strategy.Strategy;

public abstract class Player {
	protected double points;
	protected Hand hand;

	public double getPoints() {
		return points;
	}

	public Hand getHand() {
		return hand;
	}

	public void addPoint(double d) {
		this.points += d;
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
