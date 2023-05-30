package gioco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
	//private static final int NUMERO_CARTE_OBBIETTIVO_COMUNE = ;
    //private static final int NUMERO_CARTE_OBBIETTIVO_PERSONALE = ;
	
	public static String legend = "Legend: \033[0;32mcat\033[0m, \033[0;37mbook\033[0m, \033[0;33mgame\033[0m, \033[0;94mframe\033[0m, \033[0;96mtrophy\033[0m, \033[0;95mplant\033[0m";

    private ArrayList<Player> players;
    private Random random;
    private Scanner scanner;

    public Game() {
        this.players = new ArrayList<Player>();
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }
    
    public int askNumberOfPlayers() {
        System.out.print("Insert the number of players (2-4): ");
        int players = scanner.nextInt();
		while(players<2 || players>4) {
			System.out.print("There can only be 2, 3 or 4 players. How many people will be playing? ");
			players = scanner.nextInt();
		}
		return players;
    }

    public void createPlayers(int playersNumber) {
        for (int i = 1; i <= playersNumber; i++) {
        	Player player = new Player();
            players.add(player);
        }
        Collections.shuffle(players);
    }
    
    public void executeGame() {
        System.out.println("Welcome to MyShelfie! Let's begin the game!");

        int playersNumber = askNumberOfPlayers();
        createPlayers(playersNumber);
        int[] objectives = PersonalObjective.drawCard(playersNumber);
        
        scanner.nextLine();

        // Chiedi il nickname a ciascun giocatore
        for (int i=0; i<playersNumber; i++) {
            System.out.print("Insert nickname for player " + (i+1) + ": ");
            String nickname = scanner.nextLine();
            players.get(i).setNickname(nickname);
            players.get(i).personalObjective = new PersonalObjective(objectives[i]);
        }

        // Estrai le carte obiettivo comune
        CommonObjective commonObjective1=new CommonObjective();
        CommonObjective commonObjective2=new CommonObjective();
        int n1 = commonObjective1.draw_card();
        int n2 = commonObjective1.draw_card2(n1);

        // Scegli casualmente chi inizia
        
        //Player currentPlayer = players.get(indice_Giocatore_Iniziale);
        
        

        // Riempi la plancia 
        Plank plank=new Plank(playersNumber);

        boolean gameEnded = false;
        ScoreTile.createScoreTiles(playersNumber);

        int commonObjective1Counter = 0;
        int commonObjective2Counter = 0;
        
        while (!gameEnded) {
        	for(int p=0; p<playersNumber; p++) {// Controlla se la plancia deve essere riempita
                if(plank.isToFill()==true) {
                    plank.fillPlank();
                }
                
                // Ciclo 1 - Turno del giocatore corrente
                System.out.println("\n\nIt's " + players.get(p).getNickname() + "'s turn");
                System.out.println("--------------------------------------");

                commonObjective1.show_objective(n1);
                
                System.out.println();
                System.out.println("--------------------------------------");
                System.out.println();
                
                commonObjective2.show_objective(n2);
                
                System.out.println();
                System.out.println("--------------------------------------");
                System.out.println();
                
                players.get(p).library.printLibrary();
                                
                System.out.println();
                System.out.println("--------------------------------------");
                System.out.println();
                
                players.get(p).personalObjective.printCard();
                
                System.out.println();
                System.out.println("--------------------------------------");
                System.out.println();
                
                System.out.println(legend);
                
                System.out.println();
                
                System.out.println(plank);

                /*
                System.out.print("Quante tessere oggetto desideri prendere? ");
                int numeroTessereOggetto = scanner.nextInt();
                scanner.nextLine();
                */
                
                
                System.out.print(players.get(p).getNickname() + ", write the row and the column of the tile you want to pick, separated by a space, and press enter: ");
    			String line = scanner.nextLine();
    			String[] coords = line.trim().split(" ");
    			int row1 = Integer.parseInt(coords[0]);
    			int col1 = Integer.parseInt(coords[1]);
    			while(!plank.isChoiceValid(row1, col1)) {
    				System.out.print("The given coordinates are invalid. Please write the row, followed by a space, and then the column of the tile you want to pick: ");
    				line = scanner.nextLine();
    				coords = line.trim().split(" ");
    				row1 = Integer.parseInt(coords[0]);
    				col1 = Integer.parseInt(coords[1]);
    			}

    			ArrayList<Tile> pickedTiles = new ArrayList<Tile>();
    			int numOfTiles = 1;

    			System.out.print("Do you want to pick a second tile (y/n)? ");
    			char choice = scanner.nextLine().charAt(0);
    			while(choice != 'y' && choice != 'n') {
    				System.out.print("I did not understand. Do you want to pick a second tile (y/n)? ");
    				choice = scanner.nextLine().charAt(0);
    			}
    			if(choice == 'y') {
    				numOfTiles = 2;
    				System.out.print("Write the row and the column of the second tile you want to pick, separated by a space, and press enter: ");
    				line = scanner.nextLine();
    				coords = line.trim().split(" ");
    				int row2 = Integer.parseInt(coords[0]);
    				int col2 = Integer.parseInt(coords[1]);
    				while(!plank.isChoiceValid(row1, col1, row2, col2)) {
    					System.out.print("The given coordinates are invalid. Please write the row, followed by a space, and then the column of the tile you want to pick: ");
    					line = scanner.nextLine();
    					coords = line.trim().split(" ");
    					row2 = Integer.parseInt(coords[0]);
    					col2 = Integer.parseInt(coords[1]);
    				}

    				System.out.print("Do you want to pick a third tile (y/n)? ");
    				choice = scanner.nextLine().charAt(0);
    				while(choice != 'y' && choice != 'n') {
    					System.out.print("I did not understand. Do you want to pick a third tile (y/n)? ");
    					choice = scanner.nextLine().charAt(0);
    				}
    				if(choice == 'y') {
    					numOfTiles = 3;
    					System.out.print("Write the row and the column of the third tile you want to pick, separated by a space, and press enter: ");
    					line = scanner.nextLine();
    					coords = line.trim().split(" ");
    					int row3 = Integer.parseInt(coords[0]);
    					int col3 = Integer.parseInt(coords[1]);
    					while(!plank.isChoiceValid(row3, col3)) {
    						System.out.print("The given coordinates are invalid. Please write the row, followed by a space, and then the column of the tile you want to pick: ");
    						line = scanner.nextLine();
    						coords = line.trim().split(" ");
    						row3 = Integer.parseInt(coords[0]);
    						col3 = Integer.parseInt(coords[1]);
    					}
    					pickedTiles.add(plank.takeTile(row1, col1));
    					pickedTiles.add(plank.takeTile(row2, col2));
    					pickedTiles.add(plank.takeTile(row3, col3));
    				} else {
    					pickedTiles.add(plank.takeTile(row1, col1));
    					pickedTiles.add(plank.takeTile(row2, col2));
    				}
    			} else {
    				pickedTiles.add(plank.takeTile(row1, col1));
    			}
    			
    			players.get(p).library.printLibrary();
    			System.out.print("In which column do you want to put the tiles (0-4)? ");
    			int column = scanner.nextInt();
    			boolean full = false;
    			while(column<0 || column>4 || full==true) {
    				full=false;
    				System.out.print("You have chosen an invalid column. Please choose a valid column: ");
    				column=scanner.nextInt();
    				if(column<1||column>4) {
    					System.out.println("You have chosen a not existing column!!");
    				}
    				else if(players.get(p).library.isColumnFull(numOfTiles,--column)==true) {
    					System.out.println("The column you have chosen is already full or cannot contain that many tiles");
    					full=true;
    				}
    			}
    			
    			while(pickedTiles.size() > 1) {
    				System.out.print("Here are your tiles:   ");
    				for(int i=0; i<pickedTiles.size(); i++) {
    					System.out.print(i + ": " + pickedTiles.get(i).getFirstTypeChar() + "  ");
    				}
    				System.out.println();
    				System.out.print("Which tile do you want to insert? ");
    				int tileToInsert = scanner.nextInt();
    				while(tileToInsert < 0 || tileToInsert > pickedTiles.size()) {
    					System.out.print("You have chosen an invalid tile. Please pick a valid one: ");
    					tileToInsert = scanner.nextInt();
    				}
    				players.get(p).library.libraryFilling(pickedTiles.get(tileToInsert), column);
    				pickedTiles.remove(tileToInsert);
    			}
    			players.get(p).library.libraryFilling(pickedTiles.get(0), column);
    			pickedTiles.remove(0);
    			scanner.nextLine();

    			if(!players.get(p).firstCommonObjectiveCompleted && CommonObjective.checkCommonGoals(n1, players.get(p).library)) {
    				players.get(p).commonObjectivesScore += CommonObjective.assignScore(playersNumber, commonObjective1Counter++);
    				players.get(p).firstCommonObjectiveCompleted = true;
    				System.out.println(players.get(p).getNickname() + " has completed the first common objective!");
    			}
    			if(!players.get(p).secondCommonObjectiveCompleted && CommonObjective.checkCommonGoals(n2, players.get(p).library)) {
    				players.get(p).commonObjectivesScore += CommonObjective.assignScore(playersNumber, commonObjective2Counter++);
    				players.get(p).secondCommonObjectiveCompleted = true;
    				System.out.println(players.get(p).getNickname() + " has completed the second common objective!");
    			}

                // Controlli e gestione del turno

                // Controlla se il giocatore ha completato qualche obiettivo comune
                //if(.checkCommonGoals()==true)
                	//ScoreTile.assegnaPunteggio

                // Controllo fine gioco
                if(players.get(p).library.isFull()) {
                    gameEnded = true;
                }
        	}
        }

        // Calcola punteggio finale e dichiara il vincitore
        int punteggio_Massimo = 0;
        Player winner = null;

        for (Player player : players) {
            int punteggio = player.library.score() + player.personalObjective.playerScore(player.library, player.personalObjective) + player.commonObjectivesScore;
            System.out.println(player.getNickname() + " obtained a score of " + punteggio + " points.");

            if (punteggio > punteggio_Massimo) {
                punteggio_Massimo = punteggio;
                winner = player;
            }
        }

        System.out.println("The winner is " + winner.getNickname() + "!");

        // Chiedi all'utente se vuole giocare un'altra partita
        System.out.print("Do you want to play another game (yes/no)? ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
        	executeGame();
        } else {
            System.out.println("Thanks for playing MyShelfie! Bye bye!");
        }
    }
}






