import java.util.ArrayList;

public class UnoGame {

	private ArrayList<Hand> thePlayers = new ArrayList<Hand>();
	private int direction; // 1 for clockwise, -1 for counter-clockwise
	private int currPlayer;
	private Deck theDeck;
	private ArrayList<Card> discardPile = new ArrayList<Card>();

	public UnoGame() {

		// make the players
		generatePlayers();

		theDeck = new Deck();
		currPlayer = 0;
		direction = 1;
	}

	public void playGame() {
		theDeck.shuffle();
		dealCards();
		showPlayersHand();
		setDiscardPile();

		System.out.println("The discard pile shows a " + discardPile.get(discardPile.size() - 1));
		boolean winner = false;
		// initial logic processes all players with no change in direction
		// and no special effects
		while (!winner) {
			// player plays
			getNextPlayer();
			showPlayersHand();
			takeTurn();
			System.out.println("The discard pile shows a " + discardPile.get(discardPile.size() - 1));
			winner = thePlayers.get(currPlayer).isWinner();
			
		}
		System.out.println(thePlayers.get(currPlayer).getName() + " WINS!");

	}

	private Card getDiscardPileCard() {
		Card c = null;
		if (!discardPile.isEmpty())
			return discardPile.get(discardPile.size() - 1);
		return c;
	}

	private void takeTurn() {
		Hand p = thePlayers.get(currPlayer);
		Card c;
		// does current player have a match?
		if (p.hasMatch(getDiscardPileCard())) {
			c = p.playCard(getDiscardPileCard());
			System.out.println(p.getName() + " plays a " + c);
			discardPile.add(c);
		} else {
			// draw a card
			if(theDeck.isEmpty()){
				theDeck.replenishDeck(discardPile);
			}
			p.drawCard(theDeck.dealCard());
			if (p.hasMatch(getDiscardPileCard())) {
				c = p.playCard(getDiscardPileCard());
				System.out.println(p.getName() + " plays a " + c);
				discardPile.add(c);
			} else {
				if(theDeck.isEmpty())
					theDeck.replenishDeck(discardPile);
				p.drawCard(theDeck.dealCard());
				System.out.println(p.getName() + " has to pass");
			}
		}
	}

	private void getNextPlayer() {
		// initial logic - advance player in clock-wise fashion
		currPlayer = (currPlayer + 1) % thePlayers.size();
		// look at discard pile
		// Card dp = discardPile.get(discardPile.size() - 1);
		/*
		 * if (dp.isDraw2()) { processD2(); }
		 */
	}

	private void processD2() {
		// find affected player

		// going clockwise
		int affectedPlayer = (currPlayer + direction + 4) % 4;
		thePlayers.get(affectedPlayer).drawCard(theDeck.dealCard());
		thePlayers.get(affectedPlayer).drawCard(theDeck.dealCard());
		// update currPlayer
		currPlayer = (currPlayer + direction + direction + 4) % 4;

	}

	private void setDiscardPile() {
		discardPile.add(theDeck.dealCard());
	}

	private void showPlayersHand() {
		for (int i = 0; i < thePlayers.size(); i++) {
			System.out.println(thePlayers.get(i));
		}
	}

	private void dealCards() {
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < thePlayers.size(); i++) {
				thePlayers.get(i).drawCard(theDeck.dealCard());
			}
		}

	}

	private void generatePlayers() {
		thePlayers.add(new Hand());
		thePlayers.add(new Hand());
		thePlayers.add(new Hand());
		thePlayers.add(new Hand());
		thePlayers.get(0).setName("Ann");
		thePlayers.get(1).setName("Bob");
		thePlayers.get(2).setName("Cal");
		thePlayers.get(3).setName("Deb");
	}
}
