package Four;
import java.util.Scanner;

class Player {

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
		System.out.print(name+" enter your move: ");
		int move =scanner.nextInt();
		scanner.close();
		return move ;
	}
	
	
	public String toString() {
		return "Player " +this.playerNumber+" is " +name;
	}
}
