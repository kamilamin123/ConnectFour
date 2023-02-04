package Four;
import java.util.Scanner;
import java.util.Arrays;

class Board {
	
	private String[][] board;
	private Scanner scan = new Scanner(System.in); 

	
	public void boardSetUp () {
		System.out.print("the number of rows in the board:");
		int rows = scan.nextInt();
		System.out.print("the number of columns in the board:");
		int columns = scan.nextInt();
		board = new String[rows][columns];
		Arrays.fill(board,"-");

	}

	
	public void  printBoard() {
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				System.out.print(" "+ board[i][j]);
			}
			System.out.println();
		}
	}


	public boolean columnFull(int col) {
		if (board[0][col].equals("-")) {
			return false;		
		} return true;
	}


	public boolean boardFull(){
		for (int col = 0; col < board[0].length; col++) { 
			if (board[0][col].equals("-")) {
				return false;
			}
		} return true;	
	}


	public boolean addToken(int colToAddToken, String playerName) {
		if (columnFull(colToAddToken)) {
			return false;
		}else {
			for (int row = board.length-1; row <=0 ; row--) {
				if (board[row][colToAddToken].equals("-")) {
					board[row][colToAddToken] = playerName;
					return true;
				}
			}return true;
		}
	}


	public boolean checkIfPlayerIsTheWinner (String playerNumber) {
		if (checkVertical(playerNumber) || checkHorizontal(playerNumber) || checkRightDiagonal(playerNumber) || checkLeftDiagonal(playerNumber)) {
			return true;
		}else {
			return false;
		}
	}


	public boolean checkVertical(String playerNumber) {
		for (int col = 0; col < board[0].length; col++) {
			String previousValue="";
			int numberCheck=0;
			for (int row = board.length-1; row >=0 ; row--) {
				if (board[row][col].equals("-")) {
					break;
				}
				if (board[row][col].equals(previousValue)) { 
					numberCheck++;
					if (numberCheck==3) {
						return true;
					}
				}else {
					numberCheck=0;
					previousValue=board[row][col];
				}
			}
		} 
		return false;
	}


	public boolean checkHorizontal(String playerNumber) {
		for (int row=0 ; row <= board.length-1 ; row++) {
			String previousvaule="";
			int numberCheck=0;
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col].equals(previousvaule)) { 
					numberCheck++;
					if (numberCheck==3) {
						return true;
					}
				} else {
					numberCheck=0;
					previousvaule=board[row][col];
				}
			}

		}
		return false;
	}


	public boolean checkRightDiagonal(String playerNumber) {
		for (int j = 0; j <= board.length + board[0].length - 1; j++) {
			String previousValue="";
			int numberCheck=0;
			for (int k = 0; k <= j; k++) { // cols
				int l = j - k; //  rows
				int mirror = board.length - l;
				if (mirror >= 0 && mirror < board.length && k < board[0].length) {
					if (board[mirror][k].equals(previousValue)) { 
						numberCheck++;
						if (numberCheck==3) {
							return true;
						}
					}else {
						numberCheck=0;
						previousValue=board[mirror][k];
					}
				}
			}

		}
		return false;
	}


	public boolean checkLeftDiagonal(String playerNumber) {
		for ( int k = 0 ; k < board.length + board[0].length ; k++ ) {
			String previousValue="";
			int numberCheck=0;
			for ( int j = 0 ; j <= k ; j++ ) {
				int i = k - j;
				if( i < board.length && j < board[0].length ) {
					if (board[i][j].equals(previousValue)) { 
						numberCheck++;
						if (numberCheck==3) {
							return true;
						}
					}else {
						numberCheck=0;
						previousValue=board[i][j];
					}
				}
			}
		}
		return false;
	}
}