
public class Draw {
	
	static void textBasedInterface(Deck d1, Deck d2, Deck d3, Deck d4, Deck d5, Deck d6, Deck d7, Deck waste, Deck heartPile, Deck clubsPile, Deck diamondPile, Deck spadePile, int[] scoreBoard) {
		String wastePileRank = "   ";
		String wastePileSuit = "";
		String heartsPileRank = "   ";
		String heartsPileSuit = "";
		String clubsPileRank = "   ";
		String clubsPileSuit = "";
		String spadesPileRank = "   ";
		String spadesPileSuit = "";		
		String diamondsPileRank = "   ";
		String diamondsPileSuit = "";

		

		if (waste.length()>0) {
			wastePileRank = whatRankToPrint(waste.getIndex(waste.length()-1));
			wastePileSuit = whatSuitToPrint(waste.getIndex(waste.length()-1));
		} 
		if (heartPile.length()>0) {
			heartsPileRank = whatRankToPrint(heartPile.getIndex(heartPile.length()-1));
			heartsPileSuit = whatSuitToPrint(heartPile.getIndex(heartPile.length()-1));
		} 		
		if (clubsPile.length()>0) {
			clubsPileRank = whatRankToPrint(clubsPile.getIndex(clubsPile.length()-1));
			clubsPileSuit = whatSuitToPrint(clubsPile.getIndex(clubsPile.length()-1));
		} 		
		if (spadePile.length()>0) {
			spadesPileRank = whatRankToPrint(spadePile.getIndex(spadePile.length()-1));
			spadesPileSuit = whatSuitToPrint(spadePile.getIndex(spadePile.length()-1));
		} 
		if (diamondPile.length()>0) {
			diamondsPileRank = whatRankToPrint(diamondPile.getIndex(diamondPile.length()-1));
			diamondsPileSuit = whatSuitToPrint(diamondPile.getIndex(diamondPile.length()-1));
		} 
		
		System.out.println(" [   ] [" + wastePileRank + wastePileSuit + "]        [" + clubsPileRank + clubsPileSuit + "] [" + spadesPileRank + spadesPileSuit + "] [" + diamondsPileRank + diamondsPileSuit + "] [" + heartsPileRank + heartsPileSuit + "]    Moves: " + scoreBoard[0] + " Score: " + scoreBoard[1]);
		System.out.println("  P      W            C     S     \u001B[31mD     H\u001B[0m \n");
		System.out.print("\n  1     2     3     4     5     6     7\n");

		for (int i = 0; i < 52; i++) {
			if (i<d1.length()) {
				String firstRankPile = whatRankToPrint(d1.getIndex(i));
				String firstSuitPile = whatSuitToPrint(d1.getIndex(i));
				System.out.print("[" + firstRankPile + firstSuitPile + "] ");
			} else {
				System.out.print("      ");
			}
			if (i<d2.length()) {
				String secondRankPile = whatRankToPrint(d2.getIndex(i));
				String secondSuitPile = whatSuitToPrint(d2.getIndex(i));
				System.out.print("[" + secondRankPile + secondSuitPile + "] ");
			} else {
				System.out.print("      ");
			}
			if (i<d3.length()) {
				String thirdRankPile = whatRankToPrint(d3.getIndex(i));
				String thirdSuitPile = whatSuitToPrint(d3.getIndex(i));
				System.out.print("[" + thirdRankPile + thirdSuitPile + "] ");
			} else {
				System.out.print("      ");
			}
			if (i<d4.length()) {
				String fourthRankPile = whatRankToPrint(d4.getIndex(i));
				String fourthSuitPile = whatSuitToPrint(d4.getIndex(i));
				System.out.print("[" + fourthRankPile + fourthSuitPile + "] ");
			} else {
				System.out.print("      ");
			}
			if (i<d5.length()) {
				String fifthRankPile = whatRankToPrint(d5.getIndex(i));
				String fifthSuitPile = whatSuitToPrint(d5.getIndex(i));
				System.out.print("[" + fifthRankPile + fifthSuitPile + "] ");
			} else {
				System.out.print("      ");
			}
			if (i<d6.length()) {
				String sixthRankPile = whatRankToPrint(d6.getIndex(i));
				String sixthSuitPile = whatSuitToPrint(d6.getIndex(i));
				System.out.print("[" + sixthRankPile + sixthSuitPile + "] ");
			} else {
				System.out.print("      ");
			}
			if (i<d7.length()) {
				String seventhRankPile = whatRankToPrint(d7.getIndex(i));
				String seventhSuitPile = whatSuitToPrint(d7.getIndex(i));
				System.out.println("[" + seventhRankPile + seventhSuitPile + "]");
			} 
		}

	}
	
	/**
	 * @param card
	 * @return
	 */
	public static String whatRankToPrint(Card card) {
		
		if (card.isVisible()) {
		
			String whatNumberToPrint = switch(card.getRank()) {
			case ACE -> "1 ";
			case TWO -> "2 ";
			case THREE -> "3 ";
			case FOUR -> "4 ";
			case FIVE -> "5 ";
			case SIX -> "6 ";
			case SEVEN -> "7 ";
			case EIGHT -> "8 ";
			case NINE -> "9 ";
			case TEN -> "10";
			case JACK -> "J ";
			case QUEEN -> "Q ";
			case KING -> "K ";
			default -> "-?-";	
			};
			
			return whatNumberToPrint;
		} else {
		return " ";
		}
	}
	
	public static String whatSuitToPrint(Card card) {
		
		if (card.isVisible()) {
			String whatSymbolToPrint = switch(card.getSuit()) {
			case d -> "\u001B[31m♦\u001B[0m";
			case c -> "♣";
			case h -> "\u001B[31m♥\u001B[0m";
			case s -> "♠";
			default -> "-?-";	
			};
			
			return whatSymbolToPrint;
		} else {
			return "  ";
		}
	}
		
}
