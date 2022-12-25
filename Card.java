
public class Card {
	
	private Rank rank;
	private Suit suit;
	private boolean isVisible = false;
	String cardColour;
	
	public Card(Rank rank, Suit suit, boolean isVisible, String cardColour) {
		this.rank = rank;
		this.suit = suit;
		this.isVisible = isVisible;
		this.cardColour = cardColour;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
	
    public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public String toString() {
		return rank + " " + suit;
	}

	public String getCardColour() {
		return cardColour;
	}

}
