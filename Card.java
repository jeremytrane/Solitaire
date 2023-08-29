
public class Card {

	private final Rank rank;
	private final Suit suit;
	private boolean isVisible = false;
	private final String cardColour;

	public Card(Rank rank, Suit suit, boolean isVisible, String cardColour) {
		if (rank == null || suit == null) {
			throw new IllegalArgumentException("Rank and Suit must not be null");
		}
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

	public String getCardColour() {
		return cardColour;
	}

	@Override
	public String toString() {
		return rank + " " + suit;
	}

}
