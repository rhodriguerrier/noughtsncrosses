import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleGame {
	
	static String winningPlayer;
	static String morePl = "";
	static ArrayList<Integer> player1Pos = new ArrayList<Integer>();
	static ArrayList<Integer> player2Pos = new ArrayList<Integer>();
	
	public static void printBoard(char[][] board) {
		for(int i = 0; i <= 4; i++) {
			for(int j = 0; j <= 4; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static Boolean gameWonCheck(ArrayList<Integer> tiles) {
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List leftCross = Arrays.asList(3, 5, 7);
		List rightCross = Arrays.asList(1, 5, 9);
		List<List> winCombos = new ArrayList<List>();
		winCombos.add(topRow);
		winCombos.add(midRow);
		winCombos.add(botRow);
		winCombos.add(leftCol);
		winCombos.add(midCol);
		winCombos.add(rightCol);
		winCombos.add(leftCross);
		winCombos.add(rightCross);
		int counter = 0;
		for(List l : winCombos) {
			if(tiles.containsAll(l)) {
				counter++;
				break;
			}else {
				counter = 0;
			}
		}
		
		if(counter > 0) {
			return(true);
		}else {
			return(false);
		}
	}

	public static void main(String[] args) {
		Scanner continuePlaying = new Scanner(System.in);
		while(!(morePl.equals("q"))) {
			player1Pos.clear();
			player2Pos.clear();
			char[][] keyBoard = {{'1','|','2','|','3'},
					{'-','+','-','+','-'},
					{'4','|','5','|','6'},
					{'-','+','-','+','-'},
					{'7','|','8','|','9'}};
			
			char[][] gameBoard = {{' ','|',' ','|',' '},
					{'-','+','-','+','-'},
					{' ','|',' ','|',' '},
					{'-','+','-','+','-'},
					{' ','|',' ','|',' '}};
			
			Boolean gameWon = false;
			
			int turnCount = 1;
			int pl1Slot = 0;
			int pl2Slot = 0;
			int chosen;
			
			System.out.println("Please refer to the below key when choosing square:");
			for(int i = 0; i <= 4; i++) {
				for(int j = 0; j <= 4; j++) {
					System.out.print(keyBoard[i][j]);
				}
				System.out.println();
			}
			
			System.out.println("Player 1: Naughts");
			System.out.println("Player 2: Crosses");
			Scanner tileChoice = new Scanner(System.in);
			
			while(gameWon == false) {
				if(turnCount % 2 == 0) {
					System.out.println("Player 2 choose a number tile:");
					chosen = tileChoice.nextInt();
					while(player1Pos.contains(chosen) || player2Pos.contains(chosen)) {
						System.out.println("Player 2 please choose an unused tile:");
						chosen = tileChoice.nextInt();
					}
					switch(chosen) {
						case 1:
							gameBoard[0][0] = 'X';
							break;
						case 2:
							gameBoard[0][2] = 'X';
							break;
						case 3:
							gameBoard[0][4] = 'X';
							break;
						case 4:
							gameBoard[2][0] = 'X';
							break;
						case 5:
							gameBoard[2][2] = 'X';
							break;
						case 6:
							gameBoard[2][4] = 'X';
							break;
						case 7:
							gameBoard[4][0] = 'X';
							break;
						case 8:
							gameBoard[4][2] = 'X';
							break;
						case 9:
							gameBoard[4][4] = 'X';
							break;
					}
					printBoard(gameBoard);
					//player2[pl2Slot] = chosen;
					player2Pos.add(chosen);
					System.out.println(player2Pos);
					//pl2Slot++;
					turnCount++;
					if(gameWonCheck(player2Pos) == true) {
						gameWon = true;
						winningPlayer = "Player 2";
					}else {
						gameWon = false;
					}
					
				}else if(turnCount % 2 != 0) {
					System.out.println("Player 1 choose a number tile:");
					chosen = tileChoice.nextInt();
					while(player1Pos.contains(chosen) || player2Pos.contains(chosen)) {
						System.out.println("Player 1 please choose an unused tile:");
						chosen = tileChoice.nextInt();
					}
					switch(chosen) {
						case 1:
							gameBoard[0][0] = 'O';
							break;
						case 2:
							gameBoard[0][2] = 'O';
							break;
						case 3:
							gameBoard[0][4] = 'O';
							break;
						case 4:
							gameBoard[2][0] = 'O';
							break;
						case 5:
							gameBoard[2][2] = 'O';
							break;
						case 6:
							gameBoard[2][4] = 'O';
							break;
						case 7:
							gameBoard[4][0] = 'O';
							break;
						case 8:
							gameBoard[4][2] = 'O';
							break;
						case 9:
							gameBoard[4][4] = 'O';
							break;
					}
					printBoard(gameBoard);
					//player1[pl1Slot] = chosen;
					player1Pos.add(chosen);
					System.out.println(player1Pos);
					//pl1Slot++;
					turnCount++;
					if(gameWonCheck(player1Pos) == true) {
						gameWon = true;
						winningPlayer = "Player 1";
					}else {
						gameWon = false;
					}
				}
			}
			
			System.out.println("Congratulations " + winningPlayer + ", you have won!");
			System.out.println("Type y to play again or q to quit:");
			morePl = continuePlaying.nextLine();
		}
	}

}