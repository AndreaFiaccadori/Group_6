package gioco;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	/*
	 * TODO
	 * Let player undo the decision to pick another tile
	*/
	public static final String typesLine = "Legend: \033[0;32mcat\033[0m, \033[0;37mbook\033[0m, \033[0;33mgame\033[0m, \033[0;34mframe\033[0m, \033[0;36mtrophy\033[0m, \033[0;95mplant\033[0m";
	private Plank p;
	private final int players;
	private Library[] libraries;
	
	public Game(int players) {
		this.players = players;
		p = new Plank(players);
		libraries = new Library[players];
		for(int i=0; i<players; i++) {
			libraries[i] = new Library();
		}
	}
	
	public int start() {
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println(typesLine);
			System.out.println(p);
			
			for(int playerNum=0; playerNum<players; playerNum++) {
				
				System.out.print("Player " + (playerNum+1) + ", write the row and the column of the tile you want to pick, separated by a space, and press enter: ");
				String line = s.nextLine();
				String[] coords = line.trim().split(" ");
				int row1 = Integer.parseInt(coords[0]);
				int col1 = Integer.parseInt(coords[1]);
				while(!p.isChoiceValid(row1, col1)) {
					System.out.print("The given coordinates are invalid. Please write the row, followed by a space, and then the column of the tile you want to pick: ");
					line = s.nextLine();
					coords = line.trim().split(" ");
					row1 = Integer.parseInt(coords[0]);
					col1 = Integer.parseInt(coords[1]);
				}
				
				ArrayList<Tile> pickedTiles = new ArrayList<Tile>();
				
				System.out.print("Do you want to pick a second tile (y/n)? ");
				char choice = s.nextLine().charAt(0);
				while(choice != 'y' && choice != 'n') {
					System.out.print("I did not understand. Do you want to pick a second tile (y/n)? ");
					choice = s.nextLine().charAt(0);
				}
				if(choice == 'y') {
					System.out.print("Write the row and the column of the second tile you want to pick, separated by a space, and press enter: ");
					line = s.nextLine();
					coords = line.trim().split(" ");
					int row2 = Integer.parseInt(coords[0]);
					int col2 = Integer.parseInt(coords[1]);
					while(!p.isChoiceValid(row1, col1, row2, col2)) {
						System.out.print("The given coordinates are invalid. Please write the row, followed by a space, and then the column of the tile you want to pick: ");
						line = s.nextLine();
						coords = line.trim().split(" ");
						row2 = Integer.parseInt(coords[0]);
						col2 = Integer.parseInt(coords[1]);
					}
					
					System.out.print("Do you want to pick a third tile (y/n)? ");
					choice = s.nextLine().charAt(0);
					while(choice != 'y' && choice != 'n') {
						System.out.print("I did not understand. Do you want to pick a third tile (y/n)? ");
						choice = s.nextLine().charAt(0);
					}
					if(choice == 'y') {
						System.out.print("Write the row and the column of the second tile you want to pick, separated by a space, and press enter: ");
						line = s.nextLine();
						coords = line.trim().split(" ");
						int row3 = Integer.parseInt(coords[0]);
						int col3 = Integer.parseInt(coords[1]);
						while(!p.isChoiceValid(row3, col3)) {
							System.out.print("The given coordinates are invalid. Please write the row, followed by a space, and then the column of the tile you want to pick: ");
							line = s.nextLine();
							coords = line.trim().split(" ");
							row3 = Integer.parseInt(coords[0]);
							col3 = Integer.parseInt(coords[1]);
						}
						pickedTiles.add(p.takeTile(row1, col1));
						pickedTiles.add(p.takeTile(row2, col2));
						pickedTiles.add(p.takeTile(row3, col3));
					} else {
						pickedTiles.add(p.takeTile(row1, col1));
						pickedTiles.add(p.takeTile(row2, col2));
					}
				} else {
					pickedTiles.add(p.takeTile(row1, col1));
				}
				System.out.println("Here's you current library:");
				// TODO write method to print library (with columns from 1 to 5, not from 0 to 4)
				//libraries[i].printLibrary();
				System.out.print("Choose the column where you want to put the tiles you've chosen: ");
				int column = s.nextInt();
				while(column<1 || column>5 || libraries[playerNum].tooManyTiles(pickedTiles.size())) {
					System.out.print("Sorry, you can't put your tiles there. Please choose a valid column: ");
					column = s.nextInt();
				}
				int tileChoice = 1;
				if(pickedTiles.size() == 3) {
					System.out.println("Here's the tiles you've chosen:");
					for(int i=0; i<pickedTiles.size(); i++) {
						System.out.print("  " + (i+1) + ": " + pickedTiles.get(i).getFirstTypeChar());
					}
					System.out.println("Which one of these tiles do you want to put in first (1, 2 or 3)? ");
					tileChoice = s.nextInt();
					while(tileChoice<1 || tileChoice>3) {
						System.out.println("Please write a valid tile (1, 2 or 3): ");
						tileChoice = s.nextInt();
					}
					// TODO put tiles in library
					pickedTiles.remove(tileChoice-1);
				}
				if(pickedTiles.size() == 2) {
					System.out.println("Here's the tiles you've chosen:");
					for(int i=0; i<pickedTiles.size(); i++) {
						System.out.print("  " + (i+1) + ": " + pickedTiles.get(i).getFirstTypeChar());
					}
					System.out.println();
					System.out.println("Which one of these tiles do you want to put in first (1 or 2)? ");
					tileChoice = s.nextInt();
					while(tileChoice<1 || tileChoice>2) {
						System.out.println("Please write a valid tile (1 or 2): ");
						tileChoice = s.nextInt();
					}
					// TODO put tiles in library
					pickedTiles.remove(tileChoice-1);
				}
				// TODO logic for 1 tile to insert
			}
			
			for(int i=0; i<players; i++) {
				if(libraries[i].isFull()) {
					return i; // Returns the winner's player number when he's won the game, and stops the game
				}
			}
		}
	}
}
