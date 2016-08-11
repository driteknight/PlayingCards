package diamond;

import java.util.Scanner;

import card.Card;
import card.Deck;
import card.DiscardPile;
import diamond.strategy.RandomStrategy;
import diamond.strategy.SameBidStrategy;
import player.Computer;
import player.Human;
import player.Player;

public class DiamondGame {
	Human human;
	Computer computer;
	DiscardPile discardPile;

	public void init() {

		human = new Human();
		computer = new Computer(new SameBidStrategy());

		Deck deck = new Deck(1);

		human.addCards(deck.getAllClubs());
		computer.addCards(deck.getAllSpades());

		discardPile = new DiscardPile(deck.getAllDiamonds());
		discardPile.shuffle();
	}

	private boolean isValid(int playerBid) {
		for (Card c : human.getHand().getCardsInHand()) {
			if (c.isSameValue(new Card(playerBid, "SPADES"))) {
				return true;
			}
		}
		return false;
	}

	private void printOutput() {
		System.out.println("My Points : " + computer.getPoints());
		System.out.println("Your Points : " + human.getPoints());
		System.out.println(findWinner());
	}

	private void evaluateResult(int bidOn, int playerBid, int computerBid) {

		if (playerBid < computerBid) {
			computer.addPoint(bidOn);
		} else if (computerBid < playerBid) {
			human.addPoint(bidOn);
		} else {
			human.addPoint((double)bidOn / 2);
			computer.addPoint((double)bidOn / 2);
		}

		printRoundResults(playerBid, computerBid);
	}

	private void printRoundResults(int playerBid, int computerBid) {
		System.out.println("Your Bid : " + playerBid);
		System.out.println("My Bid : " + computerBid);
		System.out.println("Your Points : " + human.getPoints());
		System.out.println("My Points : " + computer.getPoints());
		System.out.println();
	}

	private String findWinner() {
		if (computer.getPoints() > human.getPoints()) {
			return "I Win!!! Thanks for playing";
		} else if (human.getPoints() > computer.getPoints()) {
			return "You Win!!! Congratulations";
		} else {
			return "It's a Draw!!!";
		}
	}

	private Card getPlayerCard(int playerBid) {
		for (Card c : human.getHand().getCardsInHand()) {
			if (c.isSameValue(new Card(playerBid, "SPADES"))) {
				human.removeCard(c);
				return c;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		DiamondGame driver = new DiamondGame();
		driver.init();
		int playerBid;
		Card playerCard = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Diamond!!!!");

		for (Card c : driver.discardPile.getCardsInDiscardPile()) {
			int bidOn = c.getValue();
			System.out.println("Bid On : " + c.getValue());

			System.out.println("Your Cards : " + driver.human.getHand());
			System.out.println("Enter you bid : ");
			playerBid = sc.nextInt();
			while (!driver.isValid(playerBid)) {
				System.out.println("Invalid Bid!!! Pls enter correct bid");
				playerBid = sc.nextInt();
			}

			playerCard = driver.getPlayerCard(playerBid);

			driver.computer.addBidOnCard(c);
			driver.evaluateResult(bidOn, playerBid, driver.computer.getBid(playerCard, c).getValue());
			driver.computer.addOpponentCard(playerCard);
		}
		sc.close();

		driver.printOutput();

	}

}
