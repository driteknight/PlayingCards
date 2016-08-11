package rummy;

import java.util.ArrayList;
import java.util.List;

import card.Card;
import card.Hand;

public class RummyHand extends Hand {

	int numOfSets = 0;
	int numOfRuns = 0;
	int numOfPureRuns = 0;

	List<List<Card>> runs;
	List<List<Card>> sets;

	public boolean isPureRun() {

	}

	public RummyHand() {
		this.cardsInHand = new ArrayList<>();
	}

	public RummyHand(ArrayList<Card> list) {
		this.cardsInHand = new ArrayList<>();
		this.cardsInHand.addAll(list);
	}

	private void getValidRun(int n) {
		sortBySuitAndValue();
		List<Card> runNew=new ArrayList<Card>(n);
	    int i,count=1;
	    for(i=0;i<numOfCardsInHand();i++)
	    {
				if(this.cardsInHand.get(i).isNextInSeq(this.cardsInHand.get(i+1))
					count++;
				else
					count=0;
				if(count==n)
				{
					for(j=i+1-n;j<i+n;j++)
						runNew.add(removeCard(this.cardsInHand.get(j)));
					sets.add(runNew);
					runNew=new List<Card>(n);
					count=0;
					i++;
				}
	  	}
	}

	private void getValidSet(int n) {
		return false;
	}

	public boolean addToRun(Card c) {
		for (List<Card> run : runs) {
			if (run.get(0).isPrevInSeq(c) || c.isJoker()) {
				run.add(0, c);
				return true;
			} else if (run.get(run.size() - 1).isNextInSeq(c) || c.isJoker()) {
				run.add(c);
				return true;
			}
		}
		return false;
	}

	private boolean addToSet(Card c) {
		for (List<Card> set : runs) {
			if (set.get(0).isSameValue(c) || c.isJoker()) {
				set.add(0, c);
				return true;
			}
		}
		return false;
	}

	public void evaluate() {
		getValidRun(3);
		getValidSet(3);
	
		sortByValue();
		for(Card card : cardsInHand) {
			if(!card.isJoker()) {
				if(!addToRun(card)) {
					addToSet(card);
				}
			}
		}
		
		for(Card card : cardsInHand) {
			if(!addToRun(card)) {
				addToSet(card);
			}
		}
		
		convertToJoker(int jokerValue, )
		
		
		
	}

	public static void main(String argsp[]) {

	}

}
