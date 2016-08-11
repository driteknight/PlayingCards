package rummy;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public class Run extends Sequence {
	
	Run(List<Card> list) {
		cards = new ArrayList<Card>();
		cards.addAll(list);
	}
	@Override
	public boolean isExtendable(Card c, int max) {
		return (cards.get(0).isPrevInSeq(c) || cards.get(cards.size() - 1).isNextInSeq(c)) && cards.size() < max;
	}

	@Override
	public void addCard(Card c, int max) {
		if (isExtendable(c, max)) {
			if (cards.get(0).isPrevInSeq(c))
				cards.add(0, c);
			else if (cards.get(cards.size() - 1).isNextInSeq(c))
				cards.add(c);
		}
	}

	public boolean isValidSequence(int max) {
		boolean flag = true;
		if (cards.size() > max)
			return false;
		for (int i = 0; i < cards.size() - 1; i++) {
			if (!cards.get(i).isNextInSeq(cards.get(i + 1)))
				flag = false;
		}
		return flag;
	}

}
