import java.util.Scanner;

public class Patience {

	public static void main(String[] args) {
		/*
		 * Setting up the decks, shuffling them and dealing the cards out
		 */
		Deck deck = new Deck("deck");
		Deck waste = new Deck("waste");
		
		deck.deckSetup();
		deck.shuffle();
		
		Tableau d1 = new Tableau(deck.getDeck(), 1, "d1");
		Tableau d2 = new Tableau(deck.getDeck(), 2, "d2");
		Tableau d3 = new Tableau(deck.getDeck(), 3, "d3");
		Tableau d4 = new Tableau(deck.getDeck(), 4, "d4");
		Tableau d5 = new Tableau(deck.getDeck(), 5, "d5");
		Tableau d6 = new Tableau(deck.getDeck(), 6, "d6");
		Tableau d7 = new Tableau(deck.getDeck(), 7, "d7");
		
		Foundation Hearts = new Foundation("Hearts");
		Foundation Clubs = new Foundation("Clubs");
		Foundation Diamonds = new Foundation("Diamonds");
		Foundation Spades = new Foundation("Spades");
		
		int[] scoreBoard = new int[] {0, 0};
		
		/*
		 * Starting the game
		 */
		
		UserInput userInput = new UserInput();
		while (Hearts.length()!=13 && Clubs.length()!=13 && Diamonds.length()!=13 && Spades.length()!=13) {
			
			Draw.textBasedInterface(d1, d2, d3, d4, d5, d6, d7, waste, Hearts, Clubs, Diamonds, Spades, scoreBoard);
			Scanner in = new Scanner(System.in);
			System.out.print("\nEnter your command: ");
			String playCommand = in.nextLine();
			
			if (playCommand.equalsIgnoreCase("Q")) {
				break;
			}
			
			String parsedUserInput = userInput.parseCommand(playCommand);
			String[] commandSeparated = parsedUserInput.split("-");

			if (userInput.errorCheck(commandSeparated)==1) {
				System.out.println("Invalid Command!");
				continue;
			}
			scoreBoard = userInput.makeMove(commandSeparated, deck, waste, d1, d2, d3, d4, d5, d6, d7, Hearts, Clubs, Diamonds, Spades, scoreBoard);
		}
		if (Hearts.length()==13 && Clubs.length()==13 && Diamonds.length()==13 && Spades.length()==13) {
		System.out.println("Game over, you have won, congratulations!");
		} else {
			System.out.println("You have exited the game");
		}
	}

}