import java.util.ArrayList;
import java.util.Collections;

// Lydia K Fritz
// CST105
// Date: Dec 31, 2019
// This is my own work.

public class Deck {
	private ArrayList<Card> theCards;
	
	public Deck(){
		//create an empty deck
		theCards = new ArrayList<Card>();
		stockDeck();
	}
	
	public void stockDeck(){
		//create the deck of 108 UNO cards
		
		theCards = new ArrayList<Card>();
		
		for(int i = 0; i < 16; i++){
		
			if(i < 14 && i > 0){
				for(int j = 0; j < 2; j++){
					theCards.add(new Card('R', i));
					theCards.add(new Card('G', i));
					theCards.add(new Card('B', i));
					theCards.add(new Card('Y', i));
				}
			}
			else{
				theCards.add(new Card('R', i));
				theCards.add(new Card('G', i));
				theCards.add(new Card('B', i));
				theCards.add(new Card('Y', i));
			}			
			
		}
	}
	
	public void shuffle(){
		//shuffle the deck
		Collections.shuffle(theCards);
	}

	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < theCards.size(); i++){
			str += theCards.get(i) + " ";
		}
		return str;
	}
	
	public Card dealCard(){
		Card c = theCards.remove(theCards.size()-1);
		return c;
	}
	
	public Card topCard(){
		Card c = theCards.get(theCards.size()-1);
		return c;
	}
	
	public boolean isEmpty(){
		return theCards.isEmpty();
	}
	
	public void replenishDeck(Deck trashPile){
		Collections.shuffle(trashPile.theCards);
		theCards.addAll(trashPile.theCards);
		trashPile.clear();
	}
	
	public void addCard(Card c){
		theCards.add(c);
	}
	
	private void clear(){
		theCards.clear();
	}
}
