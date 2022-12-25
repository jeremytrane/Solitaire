import java.util.ArrayList;

public class UserInput {
	
	String gameCommand;
	
	public UserInput() {
	}
	
	public String whichDeckToMove(String parsedUserInput) {
		
		String deckName = switch(parsedUserInput) {
		case "P" -> "waste";
		case "p" -> "waste";
		case "D" -> "Diamonds";
		case "d" -> "Diamonds";
		case "H" -> "Hearts";
		case "h" -> "Hearts";
		case "S" -> "Spades";
		case "s" -> "Spades";
		case "C" -> "Clubs";
		case "c" -> "Clubs";
		case "1" -> "d1";
		case "2" -> "d2";
		case "3" -> "d3";
		case "4" -> "d4";
		case "5" -> "d5";
		case "6" -> "d6";
		case "7" -> "d7";
		default -> "error";
		};
		return deckName;
	}

	public String parseCommand(String playCommand) {
		String deckOne, deckTwo;
		if (playCommand.length() == 1) {
			if (playCommand.equalsIgnoreCase("d")) {
				return "deck-waste";
			} else if (playCommand.equalsIgnoreCase("s")) {
				return "shuffle-shuffle";
			} else {
				return "error";
			}
		} else if (playCommand.length() == 2) {
			String[] splitCommand = playCommand.split("");
			deckOne = whichDeckToMove(splitCommand[0]);
			deckTwo = whichDeckToMove(splitCommand[1]);
			return deckOne + "-" + deckTwo;
		} else if (playCommand.length() == 3) {
			String[] splitCommand = playCommand.split("");
			deckOne = whichDeckToMove(splitCommand[1]);
			deckTwo = whichDeckToMove(splitCommand[2]);
			return deckOne + "-" + deckTwo + "-" +splitCommand[0];
		} else if (playCommand.length() == 4) {
			String[] splitCommand = playCommand.split("");
			deckOne = whichDeckToMove(splitCommand[2]);
			deckTwo = whichDeckToMove(splitCommand[3]);
			return deckOne + "-" + deckTwo + "-" + splitCommand[0] + splitCommand[1];
		} else {
			return "error";
		}
	}
	
	public int[] makeMove(String[] commandSeparated, Deck deck, Deck waste, Tableau d1, Tableau d2, Tableau d3,
			Tableau d4, Tableau d5, Tableau d6, Tableau d7, Foundation Hearts, Foundation Clubs, Foundation Diamonds,
			Foundation Spades, int[] scoreBoard) {
		
		if (commandSeparated[0].equalsIgnoreCase("shuffle")) {
			scoreBoard = d1.deckShuffle(waste, deck, scoreBoard);
			return scoreBoard;
		}
		
		 ArrayList<Deck> allDecks = new ArrayList<Deck>();
		 allDecks.add(Spades);
		 allDecks.add(Hearts);
		 allDecks.add(Diamonds);
		 allDecks.add(Clubs);
		 allDecks.add(d1);
		 allDecks.add(d2);
		 allDecks.add(d3);
		 allDecks.add(d4);
		 allDecks.add(d5);
		 allDecks.add(d6);
		 allDecks.add(d7);
		 allDecks.add(deck);
		 allDecks.add(waste);
		 
		 Deck firstDeck = null;
		 Deck secondDeck = null;
		 
		 boolean isFirstDeckNumeric = false;
		 if (commandSeparated.length==3) {
			 isFirstDeckNumeric = isNumeric(commandSeparated[2]);
		 }
		 
		 for (Deck searchDeck:allDecks) {
			 if (commandSeparated[0].equalsIgnoreCase(searchDeck.getDeckName())) {
				 firstDeck = searchDeck;
			 }
		 }
		 for (Deck searchDeck2:allDecks) {
			 if (commandSeparated[1].equalsIgnoreCase(searchDeck2.getDeckName())) {
				 secondDeck = searchDeck2;
			 }
		 }

		 if (secondDeck==deck) {
			 System.out.println("Invalid Command!");
			 return scoreBoard;
		 } 
			
		 //Moving to a foundation pile
		 if (secondDeck.getDeckName().equalsIgnoreCase("Hearts") || secondDeck.getDeckName().equalsIgnoreCase("Clubs") || secondDeck.getDeckName().equalsIgnoreCase("Diamonds") || secondDeck.getDeckName().equalsIgnoreCase("Spades")) {
			 if (commandSeparated.length==2) {
				 scoreBoard = Hearts.moveCard(firstDeck, secondDeck, Hearts, Clubs, Diamonds, Spades, scoreBoard);
			 }  else {
				 System.out.println("Invalid command!");
			 }
			 return scoreBoard;
		 }
		 
		 //Moving from pile to waste
		 if (commandSeparated[0].equalsIgnoreCase("deck") && commandSeparated[1].equalsIgnoreCase("waste")) {
			 scoreBoard = deck.moveCard(deck, waste, scoreBoard);
			 return scoreBoard;
		 }
		 //Other movements
		 if (commandSeparated.length==2) {
			 scoreBoard = d1.moveCard(firstDeck, secondDeck, scoreBoard);
			 return scoreBoard;
			 
		 } else if (commandSeparated.length==3 && isFirstDeckNumeric==true) {
			 if (secondDeck!=waste) {
			 scoreBoard = d1.movePile(firstDeck, secondDeck, commandSeparated[2], scoreBoard);
			 return scoreBoard;
			 } else {
				 System.out.println("Cannot move cards to waste pile!");
			 }
	 }
		 return scoreBoard;
}

		public int errorCheck(String[] commandSeparated) {
			for (String element : commandSeparated) {
				if(element.equalsIgnoreCase("error")) {
					return 1;
				} 
			}
			return 0;
		}

public static boolean isNumeric(String str) { 
	  try {  
	    Double.parseDouble(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
}
