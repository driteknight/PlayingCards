package diamond;
import card.DiscardPile;
import card.Hand;

public class Player {
	int points;
	private Hand hand;
	
	public Player(Hand hand) {
		points = 0;
		this.hand = hand;
	}
	
	public Player() {
		points = 0;
		this.hand = new DiamondHeartsHand();
	}
	
	public int getPoints() {
		return points;
	}

	public Hand getHand() {
		return hand;
	}
}
