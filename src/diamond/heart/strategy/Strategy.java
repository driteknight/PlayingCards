package diamond.heart.strategy;
import java.util.ArrayList;

import card.Card;

public abstract class Strategy {
	public abstract int getBid(ArrayList<Card> hand, int value);
}
