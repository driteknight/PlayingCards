package diamond.heart.strategy;

import java.util.ArrayList;

import card.Card;

public class LinearStrategy extends Strategy {

	@Override
	public int getBid(ArrayList<Card> hand, int value) {
		return value;
	}
	
}
