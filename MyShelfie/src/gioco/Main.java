package gioco;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int players;
		System.out.print("Welcome to MyShelfie! How many people will be playing (2-4)? ");
		players = s.nextInt();
		while(players<2 || players>4) {
			System.out.print("There can only be 2, 3 or 4 players. How many people will be playing? ");
			players = s.nextInt();
		}
		
		Game game = new Game(players);
		game.start();
	}

}
