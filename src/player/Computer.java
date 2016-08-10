package player;

import card.Card;
import card.Hand;
import diamond.DiamondHeartsHand;
import diamond.strategy.RandomStrategy;
import diamond.strategy.Strategy;

public class Computer extends Player{
	private Strategy strategy;
	private DiamondHeartsHand opponentCardsAppeared;
	private DiamondHeartsHand bidOnCardsAppeared;
	
	public Computer(Hand hand, Strategy strategy) {
		points = 0;
		this.hand = hand;
		this.strategy = strategy;
		opponentCardsAppeared = new DiamondHeartsHand();
		bidOnCardsAppeared = new DiamondHeartsHand();
	}

	public Computer() {
		points = 0;
		hand = new DiamondHeartsHand();
		strategy = new RandomStrategy();
		opponentCardsAppeared = new DiamondHeartsHand();
		bidOnCardsAppeared = new DiamondHeartsHand();
	}

	public Computer(Strategy strategy) {
		points = 0;
		this.hand = new DiamondHeartsHand();
		this.strategy = strategy;
		opponentCardsAppeared = new DiamondHeartsHand();
		bidOnCardsAppeared = new DiamondHeartsHand();
	}
	
	public Card getBid(Card opponentCard, Card bidCard) {
		bidOnCardsAppeared.addCard(bidCard);
		Card c = strategy.getBid(hand, opponentCardsAppeared, bidOnCardsAppeared);
		hand.removeCard(c);
		opponentCardsAppeared.addCard(opponentCard);
		return c;
	}

	public void addBidOnCard(Card c) {
		bidOnCardsAppeared.addCard(c);
	}

	public void addOpponentCard(Card c) {
		opponentCardsAppeared.addCard(c);
		
	}
}
