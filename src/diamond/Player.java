package diamond;

import java.util.ArrayList;

import card.Card;
import card.Hand;
import diamond.heart.strategy.RandomStrategy;
import diamond.heart.strategy.Strategy;

public class Player {
	int points;
	private Hand hand;
	Strategy strategy;
	private Hand opponentHand;
	private Hand bidOnPile;

	public Player(Hand hand, Strategy strategy) {
		points = 0;
		this.hand = hand;
		this.strategy = strategy;
		opponentHand = new DiamondHeartsHand();
		bidOnPile = new DiamondHeartsHand();
	}

	public Player() {
		points = 0;
		hand = new DiamondHeartsHand();
		strategy = new RandomStrategy();
		opponentHand = new DiamondHeartsHand();
		bidOnPile = new DiamondHeartsHand();
	}

	public Player(Strategy strategy) {
		points = 0;
		this.hand = new DiamondHeartsHand();
		this.strategy = strategy;
		opponentHand = new DiamondHeartsHand();
		bidOnPile = new DiamondHeartsHand();
	}

	public int getPoints() {
		return points;
	}

	public Hand getHand() {
		return hand;
	}

	public Card getBid(Card opponentCard, Card bidCard) {
		opponentHand.addCard(opponentCard);
		bidOnPile.addCard(bidCard);
		Card c = strategy.getBid(hand, opponentHand, bidOnPile);
		hand.removeCard(c);
		return c;
	}

	public void addPoint(int num) {
		this.points += num;
	}
	
	public void addCards(ArrayList<Card> cards) {
		for(Card card : cards) {
			hand.addCard(card);
		}
	}

	public void addBidOn(Card c) {
		this.bidOnPile.addCard(c);
	}

	public void removeCard(Card c) {
		hand.removeCard(c);
	}
	
	public void addOpponentCard(Card c) {
		opponentHand.addCard(c);
	}
}
