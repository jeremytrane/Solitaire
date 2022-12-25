import java.util.ArrayList;

public class Tableau extends Deck {
	
	String deckName;

    public Tableau(ArrayList<Card> deckToDealFrom, int numberOfCardsToDeal, String deckName) {
    	super(deckName);
    	for (int i = 0; i<numberOfCardsToDeal; i++) {
        	this.deck.add(deckToDealFrom.get(i));
        	deckToDealFrom.remove(i);
        	}
        deck.get(numberOfCardsToDeal-1).setVisible(true);
        this.deckName = deckName;
    }
    
	public int[] moveCard(Deck deckToDealFrom, Deck deckToDealTo, int[] scoreBoard) {
		if (deckToDealFrom.length()<1||deckToDealTo.getDeckName().equalsIgnoreCase("waste")) {
			System.out.println("Ivalid move!");
			return scoreBoard;
			 
		} else if (deckToDealTo.length()<1) {
					deckToDealTo.addCard(deckToDealFrom.getIndex(deckToDealFrom.length()-1));
					deckToDealFrom.remove(deckToDealFrom.length()-1);
					scoreBoard[0] += 1;
					scoreBoard[1] += 5;
			
					if (deckToDealFrom.length()>0) {
						deckToDealFrom.getIndex(deckToDealFrom.length()-1).setVisible(true);
					}
					return scoreBoard;

		} else {

			int checkOrder1 = checkRankOrder(deckToDealFrom.getIndex(deckToDealFrom.length()-1));
			int checkOrder2 = checkRankOrder(deckToDealTo.getIndex(deckToDealTo.length()-1));
			if (checkOrder1-checkOrder2==-1 && deckToDealFrom.getIndex(deckToDealFrom.length()-1).getCardColour()!=deckToDealTo.getIndex(deckToDealTo.length()-1).getCardColour()) {
				deckToDealTo.addCard(deckToDealFrom.getIndex(deckToDealFrom.length()-1));
				deckToDealFrom.remove(deckToDealFrom.length()-1);
				scoreBoard[0] += 1;
				scoreBoard[1] += 5;
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
	
	public int[] movePile(Deck deckToDealFrom, Deck deckToDealTo, String numberOfCardsToMove, int[] scoreBoard) {
		if (deckToDealTo.length()<1) {
			if (deckToDealFrom.getIndex(deckToDealFrom.length()-Integer.valueOf(numberOfCardsToMove)).isVisible()) {
				for (int i=0; i<Integer.valueOf(numberOfCardsToMove); i++) {
					deckToDealTo.addCard(deckToDealFrom.getIndex(deckToDealFrom.length()-Integer.valueOf(numberOfCardsToMove)+i));
					deckToDealFrom.remove(deckToDealFrom.length()-Integer.valueOf(numberOfCardsToMove)+i);
					scoreBoard[0] += 1;	
					if (!deckToDealFrom.getDeckName().equalsIgnoreCase("waste")) {
						scoreBoard[1] += 5;
					}	
					if (deckToDealFrom.length()>0) {
						deckToDealFrom.getIndex(deckToDealFrom.length()-1).setVisible(true);
					}
				} 
			} else {
				System.out.println("Not all the cards are visible!");
				return scoreBoard;
			}
			return scoreBoard;
		}
		
		if (deckToDealFrom.length()>=Integer.valueOf(numberOfCardsToMove)) {
			if (deckToDealFrom.getIndex(deckToDealFrom.length()-Integer.valueOf(numberOfCardsToMove)).isVisible()) {
				for (int i=0; i<Integer.valueOf(numberOfCardsToMove); i++) {
					int checkOrder1 = checkRankOrder(deckToDealFrom.getIndex(deckToDealFrom.length() - Integer.valueOf(numberOfCardsToMove)+i));
					int checkOrder2 = checkRankOrder(deckToDealTo.getIndex(deckToDealTo.length()-1));
					if (deckToDealFrom.getIndex(deckToDealFrom.length() - Integer.valueOf(numberOfCardsToMove)+i).getCardColour() != deckToDealTo.getIndex(deckToDealTo.length()-1).getCardColour() && checkOrder2-checkOrder1==1) {
						deckToDealTo.addCard(deckToDealFrom.getIndex(deckToDealFrom.length()-Integer.valueOf(numberOfCardsToMove)+i));
						deckToDealFrom.remove(deckToDealFrom.length()-Integer.valueOf(numberOfCardsToMove)+i);
						scoreBoard[0] += 1;
						if (!deckToDealFrom.getDeckName().equalsIgnoreCase("waste")) {
							scoreBoard[1] += 5;
						}					
					}
				}
			} else {
				System.out.println("Not all the cards are visible!");

			}
		}
		if (deckToDealFrom.length()>0) {
			deckToDealFrom.getIndex(deckToDealFrom.length()-1).setVisible(true);
		}
		if (deckToDealFrom.length()<Integer.valueOf(numberOfCardsToMove)) {
			System.out.println("Invalid move, not enough cards to move!");
		}
		return scoreBoard;
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

	public int[] deckShuffle(Deck waste, Deck deck, int[] scoreBoard) {
		int deckLength = waste.length();
		for (int i =0; i<deckLength;i++) {
			if (waste.length()!=0) {
				deck.addCard(waste.getIndex(waste.length()-1));
				waste.remove(waste.length()-1);
			}
		}
		scoreBoard[0] += 1;
		return scoreBoard;
	}
    
}
