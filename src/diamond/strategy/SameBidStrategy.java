package diamond.strategy;

import card.Card;
import card.Hand;

public class SameBidStrategy extends Strategy {

	@Override
	public Card getBid(Hand playerHand, Hand opponentHand, Hand bidHand) {
		return playerHand.getCardsInHand().stream().filter(
				c -> c.getValue() == bidHand.getCardsInHand().get(bidHand.getCardsInHand().size() - 1).getValue())
				.findFirst().orElse(null);
	}

}
