package rummy;
import java.util.ArrayList;
import java.util.List;

import card.Card;
import card.Deck;
import card.Hand;

public class RummyHand extends Hand {
	
	final int MAX_SEQ_SIZE = 5;
	final int NUMBER_OF_CARD = 13;
	final int MIN_SEQ_SIZE = 3;
	public RummyHand() {
		this.cardsInHand = new ArrayList<Card>();
	}
	
	public RummyHand(List<Card> list) {
		this.cardsInHand = new ArrayList<Card>();
		this.cardsInHand.addAll(list);
	}
	
	List<Sequence> allSequences = new ArrayList<Sequence>();
	List<List<Sequence>> allCombinations = new ArrayList<>();
	
	public void generateRunSequences(int n) {
		Hand newHand = new RummyHand(this.cardsInHand);
		newHand.sortBySuitAndValue();
		for(int i = 0; i < newHand.numOfCardsInHand() - n + 1; i++) {
			ArrayList<Card> list = new ArrayList<Card>();
			for(int j = i; j < i + n; j++) {
				list.add(newHand.getCardsInHand().get(j));	
			}
			Sequence seq = new Run(list);
			if(seq.isValidSequence(MAX_SEQ_SIZE)) {
				allSequences.add(seq);
			} 
			
			Card cardWithABeg = getCardWithABeg(seq, newHand);
			if(getCardWithABeg(seq, newHand) != null) {
				List<Card> listWithA = new ArrayList<>(list);
				listWithA.add(0, cardWithABeg);
				seq = new Run(listWithA.subList(0, listWithA.size() - 1));
				if(seq.isValidSequence(MAX_SEQ_SIZE)) {
					allSequences.add(seq);
				}
			}
			
		}
	}
	
	public void generateSetSequences(int n) {
		Hand newHand = new RummyHand(this.cardsInHand);
		newHand.sortByValue();
		
		for(int i = 0; i < newHand.numOfCardsInHand() - n + 1; i++) {
			ArrayList<Card> list = new ArrayList<Card>();
			for(int j = i; j < i + n; j++) {
				list.add(newHand.getCardsInHand().get(j));	
			}
			Sequence seq = new Set(list);
			if(seq.isValidSequence(4)) {
				allSequences.add(seq);
			} 
		}
	}
	
	private Card getCardWithABeg(Sequence s, Hand hand) {
		Card seqFirstCard = s.getCards().get(0);
		if(seqFirstCard.isSameValue(new Card(2, "SPADE"))) {
			for(Card c : hand.getCardsInHand()) {
				if(c.isSameSuit(seqFirstCard) && c.isSameValue(new Card(14, "SPADE"))) {
					return c;
				}
			}
		}
		return null;
	}

	public void addSequenceToCombination(Sequence s) {
		for(List<Sequence> combination : allCombinations) {
			if(!isOverLapping(combination, s)) {
				combination.add(s);
			}
		}
		List<Sequence> list = new ArrayList<>();
		list.add(s);
		allCombinations.add(list);
	}
	
	private boolean isOverLapping(List<Sequence> combination, Sequence s) {
		for(Sequence seq : combination) {
			if(seq.isOverlapping(s)) {
				return true;
			}
		}
		return false;
	}

	public void getAllCombinations() {
		for(Sequence seq : allSequences) {
			addSequenceToCombination(seq);
		}
	}
	
	public int getCardsToComplete(List<Sequence> combo) {
		int sum = 0;
		for(Sequence s : combo) {
			sum += s.getNumOfCards();
		}
		return NUMBER_OF_CARD - sum;
	}
	
	
	
	public void evaluate() {		
		for(int i = MIN_SEQ_SIZE; i <= MAX_SEQ_SIZE; i++) {
			generateRunSequences(i);
			if( i <= 4)
				generateSetSequences(i);
		}
		getAllCombinations();
	}
	
	
	
	public static void main(String args[]) {
		Deck deck = new Deck(2);
		deck.shuffle();
		List<Card> list = deck.pick(13);
		System.out.println(list);
		RummyHand r = new RummyHand(list);
		r.evaluate();
		r.printOutput();
		
	}

	private void printOutput() {
		int max = NUMBER_OF_CARD;
		List<Sequence> bestCombo = null;
		for(List<Sequence> combo : allCombinations) {
			int cardsToComplete = getCardsToComplete(combo);
			if(cardsToComplete < max) {
				max = cardsToComplete;
				bestCombo = combo;
			}
		}
		
		System.out.println("Sequence : " + bestCombo);
		System.out.println("Cards To Complete : " + max);
	}
} 