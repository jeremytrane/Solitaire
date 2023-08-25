import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	protected ArrayList<Card> deck = new ArrayList<>();
	private Suit deckSuit;
	private String deckName;

	public Deck(String deckName) {
		this.deckName = deckName;
	}

	public Suit getDeckSuit() {
		return deckSuit;
	}

	public void setDeckSuit(Suit deckSuit) {
		this.deckSuit = deckSuit;
	}

	public void deckSetup() {

		deck = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values())
				if (suit == Suit.h || suit == Suit.d) {
					deck.add(new Card(rank, suit, false, "red"));
				} else {
					deck.add(new Card(rank, suit, false, "black"));
				}
		}
	}

	public int length() {
		return deck.size();
	}

	public ArrayList<Card> getDeck() {
		return this.deck;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public void addCard(Card cardToAdd) {
		cardToAdd.setVisible(true);
		deck.add(cardToAdd);

	}

	public Card getIndex(int i) {
		return deck.get(i);
	}

	public Card remove(int i) {
		return deck.remove(i);
	}

	public Suit getSuit(Card card) {
		return card.getSuit();
	}

	public Rank getRank(Card card) {
		return card.getRank();
	}

	public String getDeckName() {
		return this.deckName;
	}

	public int[] moveCard(Deck deckToDealFrom, Deck deckToDealTo, int[] scoreBoard) {
		if (deckToDealFrom.length() > 0) {
			deckToDealTo.addCard(deckToDealFrom.getIndex(deckToDealFrom.length() - 1));
			deckToDealFrom.remove(deckToDealFrom.length() - 1);
			scoreBoard[0] += 1;
			return scoreBoard;
		} else {
			System.out.println("There are no more cards in the deck!");
			return scoreBoard;
		}
	}

}
