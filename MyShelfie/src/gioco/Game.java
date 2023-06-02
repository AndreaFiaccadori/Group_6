package gioco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
	// private static final int NUMERO_CARTE_OBBIETTIVO_COMUNE = ;
	// private static final int NUMERO_CARTE_OBBIETTIVO_PERSONALE = ;

	// Line to print before printing the plank
	public static String legend = "Legend: \033[0;32mcat\033[0m, \033[0;37mbook\033[0m, \033[0;33mgame\033[0m, \033[0;94mframe\033[0m, \033[0;96mtrophy\033[0m, \033[0;95mplant\033[0m";

	private ArrayList<Player> playersList;
	private Scanner scanner;

	public Game() {
		this.playersList = new ArrayList<Player>();
		this.scanner = new Scanner(System.in);
	}

	/**
	 * @return the number of players
	 */
	public int askNumberOfPlayers() {
		int players = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.print("Insert the number of players (2-4): ");
			String input = scanner.nextLine();
			try {
				players = Integer.parseInt(input);
				if (players >= 2 && players <= 4) {
					isValidInput = true;
				} else {
					System.out.print("Invalid number of players. ");
				}
			} catch (NumberFormatException e) {
				System.out.print("The input is not valid. ");
			}
		}
		return players;
	}

	public void createPlayers(int playersNumber) {
		for (int i = 1; i <= playersNumber; i++) {
			Player player = new Player();
			playersList.add(player);
		}
	}

	public void executeGame() {
		System.out.println("Welcome to MyShelfie! Let's begin the game!");

		int playersNumber = askNumberOfPlayers();
		createPlayers(playersNumber);
		int[] objectives = PersonalObjective.drawCard(playersNumber);

		// It asks the nickname to each player
		for (int i = 0; i < playersNumber; i++) {
			System.out.print("Insert nickname for player " + (i + 1) + ": ");
			String nickname = scanner.nextLine();
			while (nickname.length() < 1) {
				System.out.print(
						"\033[0;31mA player's nickname cannot be empty.\033[0m Please insert a nickname for player "
								+ (i + 1) + ": ");
				nickname = scanner.nextLine();
			}
			playersList.get(i).setNickname(nickname);
			playersList.get(i).personalObjective = new PersonalObjective(objectives[i]);
		}
		Collections.shuffle(playersList);

		// It extract the common objective cards
		CommonObjective commonObjective1 = new CommonObjective();
		CommonObjective commonObjective2 = new CommonObjective();
		int n1 = commonObjective1.drawCard();
		int n2 = commonObjective1.drawCard2(n1);

		// It picks who starts by random

		// Player currentPlayer = players.get(indice_Giocatore_Iniziale);

		// It fills the plank
		Plank plank = new Plank(playersNumber);

		boolean gameEnded = false;
		ScoreTile.createScoreTiles(playersNumber);

		int commonObjective1Counter = 0;
		int commonObjective2Counter = 0;

		while (!gameEnded) {
			for (int p = 0; p < playersNumber; p++) {
				// Fills the plank if it has to refilled
				if (plank.isToFill() == true) {
					plank.fillPlank();
				}

				// Cicle 1 - Turn of the current player
				System.out.println("\n\nIt's " + playersList.get(p).getNickname() + "'s turn");
				System.out.println("--------------------------------------");

				commonObjective1.showObjective(n1);

				System.out.println();
				System.out.println("--------------------------------------");
				System.out.println();

				commonObjective2.showObjective(n2);

				System.out.println();
				System.out.println("--------------------------------------");
				System.out.println();

				playersList.get(p).library.printLibrary();

				System.out.println();
				System.out.println("--------------------------------------");
				System.out.println();

				playersList.get(p).personalObjective.printCard();

				System.out.println();
				System.out.println("--------------------------------------");
				System.out.println();

				System.out.println(legend);

				System.out.println();

				System.out.println(plank);

				/*
				 * System.out.print("Quante tessere oggetto desideri prendere? "); int
				 * numeroTessereOggetto = scanner.nextInt(); scanner.nextLine();
				 */

				// handling ArrayInedexOutOfBoundsException and NumberFormatException
				// if the player entered an invalid input he has to restart by the first tile
				ArrayList<Tile> pickedTiles;
				int numOfTiles = 0;
				String line = null;

				// Input for the tiles to pick
				while (true) {
					try {
						System.out.print(playersList.get(p).getNickname()
								+ ", write the row and the column of the tile you want to pick, separated by a space, and press enter: ");
						line = scanner.nextLine();
						String[] coords = line.trim().split(" ");
						int row1 = Integer.parseInt(coords[0]);
						int col1 = Integer.parseInt(coords[1]);
						while (!plank.isChoiceValid(row1, col1)) {
							System.out.print(
									"\033[0;31mThe given coordinates are invalid.\033[0m Please write the row, followed by a space, and then the column of the tile you want to pick: ");
							line = scanner.nextLine();
							coords = line.trim().split(" ");
							row1 = Integer.parseInt(coords[0]);
							col1 = Integer.parseInt(coords[1]);
						}

						pickedTiles = new ArrayList<Tile>();
						numOfTiles = 1;
						
						String choice;
						if(playersList.get(p).library.tooManyTiles(2)) {
							choice = "N";
						} else {
							System.out.print("Do you want to pick a second tile (y/n)? ");
							choice = scanner.nextLine();
							while (choice.length() < 1 || (choice.charAt(0) != 'y' && choice.charAt(0) != 'n')) {
								System.out.print(
										"\033[0;31mI did not understand.\033[0m Do you want to pick a second tile (y/n)? ");
								choice = scanner.nextLine();
							}
						}

						if (choice.equalsIgnoreCase("Y")) {
							numOfTiles = 2;
							System.out.print(
									"Write the row and the column of the second tile you want to pick, separated by a space, and press enter (or write \"\033[0;96mundo\033[0m\" to cancel the selection): ");
							line = scanner.nextLine();
							coords = line.trim().split(" ");
							int row2 = Integer.parseInt(coords[0]);
							int col2 = Integer.parseInt(coords[1]);
							while (!plank.isChoiceValid(row1, col1, row2, col2)) {
								System.out.print(
										"\033[0;31mThe given coordinates are invalid.\033[0m Please write the row, followed by a space, and then the column of the tile you want to pick: ");
								line = scanner.nextLine();
								coords = line.trim().split(" ");
								row2 = Integer.parseInt(coords[0]);
								col2 = Integer.parseInt(coords[1]);
							}
							
							if(playersList.get(p).library.tooManyTiles(3)) {
								choice = "N";
							} else {
								System.out.print("Do you want to pick a third tile (y/n)? ");
								choice = scanner.nextLine();
								while (choice.length() < 1 || (choice.charAt(0) != 'y' && choice.charAt(0) != 'n')) {
									System.out.print(
											"\033[0;31mI did not understand.\033[0m Do you want to pick a second tile (y/n)? ");
									choice = scanner.nextLine();
								}
							}

							if (choice.equalsIgnoreCase("Y")) {
								numOfTiles = 3;
								System.out.print(
										"Write the row and the column of the third tile you want to pick, separated by a space, and press enter (or write \"undo\" to cancel the selection): ");
								line = scanner.nextLine();
								coords = line.trim().split(" ");
								int row3 = Integer.parseInt(coords[0]);
								int col3 = Integer.parseInt(coords[1]);
								while (!plank.isChoiceValid(row1, col1, row2, col2, row3, col3)) {
									System.out.print(
											"\033[0;31mThe given coordinates are invalid.\033[0m\nPlease write the row, followed by a space, and then the column of the tile you want to pick: ");
									line = scanner.nextLine();
									coords = line.trim().split(" ");
									row3 = Integer.parseInt(coords[0]);
									col3 = Integer.parseInt(coords[1]);
								}
								pickedTiles.add(plank.takeTile(row1, col1));
								pickedTiles.add(plank.takeTile(row2, col2));
								pickedTiles.add(plank.takeTile(row3, col3));
								break;
							} else {
								pickedTiles.add(plank.takeTile(row1, col1));
								pickedTiles.add(plank.takeTile(row2, col2));
								break;
							}
						} else {
							pickedTiles.add(plank.takeTile(row1, col1));
							break;
						}
					} catch (NumberFormatException e) {
						if (line.equals("undo")) {
							System.out.println("\033[0;96mLet's undo your tile selection.\033[0m");
							continue;
						}
						System.out.println(
								"\033[0;31mYou put words instead of the numbers for the row and the column of a tile. Let's undo your tile selection.\033[0m");
						continue;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out
								.println("\033[0;31mThe numbers are not valid. Let's undo your tile selection.\033[0m");
						continue;
					}
				}

				// Input for the column where to put picked tiles
				int column = 0;
				while (true) {
					try {
						playersList.get(p).library.printLibrary();
						System.out.print("In which column do you want to put the tiles (0-4)? ");
						line = scanner.nextLine();
						column = Integer.parseInt(line);
						while (column < 0 || column > 4) {
							System.out.print(
									"\033[0;31mYou have chosen an invalid column.\033[0m Please choose a valid column: ");
							line = scanner.nextLine();
							column = Integer.parseInt(line);
							
							
						}
						if (playersList.get(p).library.isColumnFull(numOfTiles, column) == true) {
							System.out.println(
									"\033[0;31mThe column you have chosen is already full or cannot contain that many tiles.\033[0m");
							continue;
						}
						break;
					} catch (NumberFormatException e) {
						System.out.println(
								"\033[0;31mYou put words instead of the numbers for the column of the library's column.\033[0m");
						continue;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("\033[0;31mThe number is not valid.\033[0m");
						continue;
					}
				}

				// Input for the tiles to put in selected column
				while (true) {
					try {
						while (pickedTiles.size() > 1) {
							System.out.print("Here are your tiles:     ");
							for (int i = 0; i < pickedTiles.size(); i++) {
								System.out.print(i + ": " + pickedTiles.get(i).getFirstTypeChar() + "  ");
							}
							System.out.println();
							System.out.print("Which tile do you want to insert? ");
							line = scanner.nextLine();
							int tileToInsert = Integer.parseInt(line);
							//int tileToInsert = scanner.nextInt();
							while (tileToInsert < 0 || tileToInsert > pickedTiles.size()) {
								System.out.print(
										"\033[0;96mYou have chosen an invalid tile.\033[0m Please pick a valid one: ");
								tileToInsert = scanner.nextInt();
							}
							playersList.get(p).library.libraryFilling(pickedTiles.get(tileToInsert), column);
							pickedTiles.remove(tileToInsert);
						}
						playersList.get(p).library.libraryFilling(pickedTiles.get(0), column);
						pickedTiles.remove(0);
						break;
					} catch (NumberFormatException e) {
						System.out.println(
								"\033[0;96mYou put words instead of the number of tile you want to insert.\033[0m");
						continue;
					} catch (IndexOutOfBoundsException e) {
						System.out.println("\033[0;96mYou chose an invalid number of tile to insert.\033[0m");
						continue;
					}
				}

				// Checks for completion of common objectives and assigns score to player
				if (!playersList.get(p).firstCommonObjectiveCompleted
						&& CommonObjective.checkCommonGoals(n1, playersList.get(p).library)) {
					playersList.get(p).commonObjectivesScore += CommonObjective.assignScore(playersNumber,
							commonObjective1Counter++);
					playersList.get(p).firstCommonObjectiveCompleted = true;
					System.out.println(playersList.get(p).getNickname() + " has completed the first common objective! Press enter to continue...");
					scanner.nextLine();
				}
				if (!playersList.get(p).secondCommonObjectiveCompleted
						&& CommonObjective.checkCommonGoals(n2, playersList.get(p).library)) {
					playersList.get(p).commonObjectivesScore += CommonObjective.assignScore(playersNumber,
							commonObjective2Counter++);
					playersList.get(p).secondCommonObjectiveCompleted = true;
					System.out
							.println(playersList.get(p).getNickname() + " has completed the second common objective! Press enter to continue...");
					scanner.nextLine();
				}

				// End game control
				if (playersList.get(p).library.isFull()) {
					playersList.get(p).commonObjectivesScore += 1;
					gameEnded = true;
					System.out.println(playersList.get(p).getNickname() + " has completed their library, and they got a bonus point! This is the last round. Press enter to continue...");
					scanner.nextLine();
				}
			}
		}

		// Final score calculation and declaration of the winner
		int maxScore = 0;
		Player winner = null;

		for (Player player : playersList) {
			int score = player.library.score()
					+ player.personalObjective.playerScore(player.library, player.personalObjective)
					+ player.commonObjectivesScore;
			System.out.println(player.getNickname() + " obtained a score of " + score + " points.");

			if (score > maxScore) {
				maxScore = score;
				winner = player;
			}
		}

		System.out.println("The winner is " + winner.getNickname() + "!");

		// It asks at the user if he wants to play another game
		System.out.print("Do you want to play another game (yes/no)? ");
		String answer = scanner.nextLine();
		if (answer.equalsIgnoreCase("yes")) {
			executeGame();
		} else {
			System.out.println("Thanks for playing MyShelfie! Bye bye!");
		}
	}
}
