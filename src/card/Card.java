package card;

public class Card{
	private int value;
	private String displayValue;
	private  String suit;
	
	public Card(int value, String displayValue, String suit) {
		this.value = value;
		this.displayValue = displayValue;
		this.suit = suit;
	}

	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
		this.displayValue = convertToDisplayValue(value);
	}

	public Card(String displayValue, String suit) {
		this.displayValue = displayValue;
		this.suit = suit;
		this.value = convertToValue(displayValue);
	}

	public int convertToValue(String displayValue) {
		switch (displayValue) {
		case "A":
			return 14;
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;
		default:
			return Integer.parseInt(displayValue);
		}
	}

	public String convertToDisplayValue(int value) {
		switch (value) {
		case 14:
			return "A";
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
		default:
			return String.valueOf(value);
		}
	}

	public int getValue() {
		return this.value;
	}

	public String getSuit() {
		return this.suit;
	}
	
	public String getDisplayValue() {
		return this.displayValue;
	}

	public boolean isSameSuit(Card c2) {
		return c2.suit.equals(this.suit);
	}

	public boolean isSameValue(Card c2) {
		return c2.value == this.value;
	}

	public boolean isNextInSeq(Card c2) {
		if (isSameSuit(c2)) {
			if (this.value == 14) {
				return c2.value == 2;
			} else {
				return c2.value == this.value + 1;
			}
		}
		return false;
	}

	public boolean isPrevInSeq(Card c2) {
		if (isSameSuit(c2)) {
			if (this.value == 2) {
				return c2.value == 14;
			} else {
				return c2.value == this.value - 1;
			}
		}

		return false;
	}
	

	public String toString() {
		return this.suit + " " + this.displayValue;
	}
	
}