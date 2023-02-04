package Four;
import java.util.Scanner;

public class Game {
	private Player[] player;
	private Board board= new Board();
	private Scanner scan = new Scanner(System.in);

	public Game() {

	}
	public void setUpGame() {
		board.boardSetUp();
		int n;
		while(true) {
			System.out.print("enter the number of players at least 2: ");

			n = scan.nextInt();
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




}
