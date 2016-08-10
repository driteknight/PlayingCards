package diamond.heart.strategy;

import java.util.ArrayList;

import card.Card;

public class RandomStrategy extends Strategy{

	@Override
	public int getBid(ArrayList<Card> hand, int value) {
		int r = (int) (Math.random() * (hand.size() - 1));
		return hand.get(r).getValue();
	}

}
