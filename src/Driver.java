import card.Deck;
import diamond.DiamondHeartsHand;
import diamond.Player;

public class Driver {

	Player player;
	Player computer;
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.player = new Player(new DiamondHeartsHand());
		driver.computer = new Player(new DiamondHeartsHand());
		DiamondHeartsHand a = new DiamondHeartsHand();	
		Deck deck = new Deck(1);
	}

}
