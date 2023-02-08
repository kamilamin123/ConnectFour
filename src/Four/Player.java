package Four;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

	private String name;
	private String playerNumber;
	private static Scanner scanner = new Scanner(System.in);


	public Player (String name1, String number) {

		this.name = name1;
		this.playerNumber = number;    
	} 



	public String getName() { return this.name;}


	public String getPlayerNumber() { return this.playerNumber;}


	public int MakeMove() {

		System.out.print(this.name+" enter your column number move: ");
		int move ;
		try {
			move =scanner.nextInt();
		} catch (InputMismatchException e){
			System.out.print(this.name+"you didnt enter number in number format please enter your column number move: ");
			move =scanner.nextInt();
		}
		
		return move-1 ;
	}


	public String toString() {
		return "Player " +this.playerNumber+" is " +name;
	}
}
