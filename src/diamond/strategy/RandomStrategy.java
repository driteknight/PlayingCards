package diamond.strategy;

import card.Card;
import card.Hand;

public class RandomStrategy extends Strategy {

	@Override
	public Card getBid(Hand playerHand, Hand opponentHand, Hand bidHand) {
		int r = (int) (Math.random() * (playerHand.getCardsInHand().size() - 1));
		return playerHand.getCardsInHand().get(r);
	}

}
