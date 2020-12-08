import java.util.ArrayList;

// Lydia K Fritz
// CST105
// Date: Dec 31, 2019
// This is my own work.

public class Hand {

	private ArrayList<Card> myCards;
	private String name;
	
	public Hand(){
		myCards = new ArrayList<Card>();
	}
	
	public void drawCard(Card c){
		myCards.add(c);
	}
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @param rhs
	 * @return the card played
	 * remove the card from the hand
	 * PRE:  Player must have a match
	 */
	public Card playCard(Card rhs){
		Card c;
		for(int i = 0; i < myCards.size(); i++){
			if(myCards.get(i).isMatch(rhs)){
				c = myCards.get(i);
				myCards.remove(i);
				return c;
			}
		}
		//should never happen
		return null;
	}
	
	public boolean hasMatch(Card rhs){
		boolean match = false;
		for(int i = 0; i < myCards.size(); i++){
			if(myCards.get(i).isMatch(rhs)){
				match = true;
				break;
			}
		}
		return match;
	}

	@Override
	public String toString() {
		String str = String.format("%10s", name);
		return str + ":  " + myCards;
	}
	
	public boolean isWinner(){
		return myCards.size() == 0;
	}
	
	public boolean hasUno(){
		return myCards.size() == 1;
	}
	
	
	
}
