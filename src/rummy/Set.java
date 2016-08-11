package rummy;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public class Set extends Sequence {
	
	Set(List<Card> list) {
		cards = new ArrayList<Card>();
		cards.addAll(list);
	}
	@Override
	public boolean isExtendable(Card c, int max) {
		for (int i = 0; i < cards.size(); i++) {
			if (c.isSameSuit(cards.get(i)) || !c.isSameValue(cards.get(i)) || cards.size() == max) {
				return false;
			} 
		}
		return true;
	}

	@Override
	public void addCard(Card c, int max) {
		if (isExtendable(c, max)) {
			cards.add(c);
		}
	}

	@Override
	public boolean isValidSequence(int max) {
		if(cards.size() > max) {
			return false;
		}
		
		
		for (int j = 0; j < cards.size() - 1; j++) {
			if (cards.get(j).isSameSuit(cards.get(j + 1)) || !cards.get(j).isSameValue(cards.get(j + 1))) {
				return false;
			}
		}
		
		return true;
	}

}
