package diamond.heart.strategy;

import java.util.ArrayList;

import card.Card;
import card.Hand;

public abstract class Strategy {
	public abstract Card getBid(Hand playerHand, Hand opponentHand, Hand bidHand);
}
