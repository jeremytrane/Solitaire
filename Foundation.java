
public class Foundation extends Deck {

	public Foundation(String deckName) {
    	super(deckName);
    }

	public int[] moveCard(Deck deckToDealFrom, Deck deckToDealTo, Deck Hearts, Deck Clubs, Deck Diamonds, Deck Spades, int[] scoreBoard) {
		
		Hearts.setDeckSuit(Suit.h);
		Clubs.setDeckSuit(Suit.c);
		Diamonds.setDeckSuit(Suit.d);
		Spades.setDeckSuit(Suit.s);

		if (deckToDealFrom.length()<1) {
			System.out.println("Deck is empty");
			 return scoreBoard;

		} else if (deckToDealTo.length()<1) {
			if (deckToDealFrom.getRank(deckToDealFrom.getIndex(deckToDealFrom.length()-1))==Rank.ACE) {
				if (deckToDealFrom.getSuit(deckToDealFrom.getIndex(deckToDealFrom.length()-1))==deckToDealTo.getDeckSuit()) {
					deckToDealTo.addCard(deckToDealFrom.getIndex(deckToDealFrom.length()-1));
					deckToDealFrom.remove(deckToDealFrom.length()-1);
					 scoreBoard[0] += 1;
					 if (deckToDealFrom.getDeckName().equalsIgnoreCase("waste")) {
						 scoreBoard[1] += 10;
					 } else {
						 scoreBoard[1] += 20;
					 }
					 
					 if (deckToDealFrom.length()>0) {
						 deckToDealFrom.getIndex(deckToDealFrom.length()-1).setVisible(true);
					 }
					 return scoreBoard;
				} else {
					System.out.println("Invalid move, card and deck are not the same suit!");
					 return scoreBoard;
				}
			} else {
				System.out.println("Invalid move, first card is not an ace!");
				 return scoreBoard;
			}
			
		} else {

			int checkOrder1 = checkRankOrder(deckToDealFrom.getIndex(deckToDealFrom.length()-1));
			int checkOrder2 = checkRankOrder(deckToDealTo.getIndex(deckToDealTo.length()-1));
			if (checkOrder2-checkOrder1==-1 && deckToDealFrom.getIndex(deckToDealFrom.length()-1).getCardColour()==deckToDealTo.getIndex(deckToDealTo.length()-1).getCardColour()) {
				deckToDealTo.addCard(deckToDealFrom.getIndex(deckToDealFrom.length()-1));
				deckToDealFrom.remove(deckToDealFrom.length()-1);
				scoreBoard[0] += 1;
				if (deckToDealFrom.getDeckName().equalsIgnoreCase("waste")) {
					 scoreBoard[1] += 10;
				 } else {
					 scoreBoard[1] += 20;
				 }
				 if (deckToDealFrom.length()>0) {
					 deckToDealFrom.getIndex(deckToDealFrom.length()-1).setVisible(true);
				 }
				return scoreBoard;

			} else {
			System.out.println("Invalid move!");
			return scoreBoard;
		}
	}	
}

	public int checkRankOrder(Card cardToCheck) {
		int check = switch(cardToCheck.getRank()) {
		case ACE -> 1;
		case TWO -> 2;
		case THREE -> 3;
		case FOUR -> 4;
		case FIVE -> 5;
		case SIX -> 6;
		case SEVEN -> 7;
		case EIGHT -> 8;
		case NINE -> 9;
		case TEN -> 10;
		case JACK -> 11;
		case QUEEN -> 12;
		case KING -> 13;
		default -> 0;	
		};
		return check;
	}
}


