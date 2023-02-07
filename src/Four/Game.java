package Four;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Game {

	private Player[] player;
	private Board board= new Board();
	private Scanner scan = new Scanner(System.in);

	public Game() { }

	public void setUpGame() {

		board.boardSetUp();
		int n;
		while(true) {
			System.out.print("enter the number of players at least 2: ");
			try {
				n = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("you didnt enter number in number format please enter the number of players at least 2: ");
				n = scan.nextInt();
			} 
			if (n<2) {
				continue;
			}else {
				break;
			}
		}
		scan.nextLine();
		String name="";
		Boolean check= false;
		int i=0;
		while( i<n) {
			System.out.print(" enter the player name it should be unique for player number "+(i+1)+" : ");
			name = scan.nextLine();
			for(Object each:player) {
				if (name.equals(each)) {
					check=true;
					continue;
				}
			}
			if (!check) {
				player[i]= new Player(name,Integer.toString(++i));
			}
			check=false;
		}
	}

	public void printWinner(Player player) {
		System.out.println(player.getName()+ " player number: "+player.getPlayerNumber()+" is the winner");
	}

	public void playerTurn(Player currentPlayer) {
		try {
			int move =currentPlayer.MakeMove();
			boolean check=false;
			try {
				check= board.addToken(move, currentPlayer.getName());

			}catch(GameExceptions e) {
				System.out.println(e.getMessage());

			}
			if (check) {
				board.printBoard();
			}
		} catch (Exception e) {
			System.out.println("Try again late");
		}
	}
	public void play() {

		boolean noWinner = true;
		setUpGame();
		int currentPlayerIndex=0;
		while(noWinner) {
			if(board.boardFull()) {
				System.out.println("Board is now full. Game Ends.");
			}else {
				Player currentPlayer = player[currentPlayerIndex];
				System.out.println("It is player"+ currentPlayer.getPlayerNumber()+"\'s turn."+currentPlayer.getName() );
				playerTurn(currentPlayer);
				if(board.checkIfPlayerIsTheWinner(currentPlayer.getPlayerNumber())) {
					printWinner(currentPlayer);
					noWinner=false;
				}else {
					currentPlayerIndex=(currentPlayerIndex+1)%player.length;
				}

			}
		}
	}
}


