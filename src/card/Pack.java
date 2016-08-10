package card;
import java.util.*;

public class Pack {

	private ArrayList<Card> cardsInPack;
	private final String[] suitNames = { "SPADE", "DIAMOND", "CLUB", "HEART" };
	private final String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	public Pack(int numOfJokers) {

		cardsInPack = new ArrayList<>();

		for (String s : suitNames) {
			for (String v : values) {
				cardsInPack.add(new Card(v, s));
			}
		}

		for (int i = 0; i < numOfJokers; ++i) {
			cardsInPack.add(new Card("JOKER", "0"));
		}
	}

	public ArrayList<Card> getCardsFromPack() {
		return cardsInPack;
	}

}
