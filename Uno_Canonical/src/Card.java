// Lydia K Fritz
// CST105
// Date: Dec 31, 2019
// This is my own work.

public class Card {

	private char color;
	private int value;

	/*
	 * value glossary 0 - 9 as seen 11 - skip 12 - reverse 13 - draw two 14 -
	 * wild 15 - wild draw 4
	 */
	public Card(char c, int v) {
		color = c;
		value = v;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String str = "";
		switch (value) {
		case 11:
			str = "SK";
			break;
		case 12:
			str = "RV";
			break;
		case 13:
			str = "D2";
			break;
		case 14:
			str = "W";
			break;
		case 15:
			str = "W4";
			break;
		default:
			str = value + "";
		}
		if (value < 14)
			return "[" + color + ":" + str + "]";
		else
			return "[" + str + "]";
	}

	public boolean isWild() {
		return value == 14 || value == 15;
	}

	/**
	 * return true if
	 * 
	 * @param rhs
	 *            matches the calling object
	 * @return false otherwise
	 */
	public boolean isMatch(Card rhs) {

		// if this card is wild, return true
		if (isWild())
			return true;

		// not wild, so check to see if the value matches
		if (value == rhs.value)
			return true;

		// check color
		if (color == rhs.color)
			return true;

		return false;

	}

	// added for milestone 4 turn logic
	public boolean isReverse() {
		return value == 12;
	}

	public boolean isSkip() {
		return value == 11;
	}

	public boolean isDraw2() {
		return value == 13;
	}

	public boolean isWD4() {
		return value == 15;
	}

}
