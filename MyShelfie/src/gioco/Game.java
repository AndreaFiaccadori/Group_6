package gioco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	//private static final int NUMERO_CARTE_OBBIETTIVO_COMUNE = ;
    //private static final int NUMERO_CARTE_OBBIETTIVO_PERSONALE = ;
	
	public static String legend = "Legend: \033[0;32mcat\033[0m, \033[0;37mbook\033[0m, \033[0;33mgame\033[0m, \033[0;94mframe\033[0m, \033[0;96mtrophy\033[0m, \033[0;95mplant\033[0m";

    private List<Player> players;
    private Random random;
    private Scanner scanner;

    public Game() {
        this.players = new ArrayList<>();
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
        	Player player = new Player(i);
            players.add(player);
        }
    }
    
    public Player nextPlayer(Player currentPlayer) {
        int currentIndex = players.indexOf(currentPlayer);
        int nextIndex = (currentIndex + 1) % players.size();
        return players.get(nextIndex);
    }
    
    public void executeGame() {
        System.out.println("Welcome to MyShelfie! Let's begin the game!");

        int playersNumber = askNumberOfPlayers();
        createPlayers(playersNumber);
        int[] objectives = PersonalObjective.drawCard(playersNumber);
        
        scanner.nextLine();

        // Chiedi il nickname a ciascun giocatore
        for (int i=0; i<playersNumber; i++) {
            System.out.print("Insert nickname for player  " + players.get(i).getOrder() + ": ");
            String nickname = scanner.nextLine();
            players.get(i).setNickname(nickname);
            players.get(i).personalObjective = new PersonalObjective(i);
        }

        // Estrai le carte obiettivo comune
        CommonObjective commonObjective1=new CommonObjective();
        CommonObjective commonObjective2=new CommonObjective();
        int n1 = commonObjective1.draw_card();
        int n2 = commonObjective1.draw_card2(n1);

        // Scegli casualmente chi inizia
        int indice_Giocatore_Iniziale = random.nextInt(playersNumber);
        Player currentPlayer = players.get(indice_Giocatore_Iniziale);
        
        

        // Riempi la plancia 
        Plank plank=new Plank(playersNumber);

        boolean gameEnded = false;

        while (!gameEnded) 
        {
            // Controlla se la plancia deve essere riempita
            if (plank.isToFill()==true) 
            {
                plank.fillPlank();
            }
            
            // Ciclo 1 - Turno del giocatore corrente
            System.out.println("It's " + currentPlayer.getNickname() + "'s turn");
            System.out.println("-----");

            currentPlayer.library.printLibrary();
            currentPlayer.personalObjective.printCard();
            commonObjective1.show_objective(n1);
            commonObjective2.show_objective(n2);
            
            System.out.println(legend);
            System.out.println(plank);

            /*
            System.out.print("Quante tessere oggetto desideri prendere? ");
            int numeroTessereOggetto = scanner.nextInt();
            scanner.nextLine();
            */
            
            
            System.out.print(currentPlayer.getNickname() + ", write the row and the column of the tile you want to pick, separated by a space, and press enter: ");
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
			
			currentPlayer.library.printLibrary();
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
				else if(currentPlayer.library.isColumnFull(numOfTiles,--column)==true) {
					System.out.println("The column you have chosen is already full or cannot contain that many tiles");
					full=true;
				}
			}
			
			while(pickedTiles.size() > 0) {
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
				currentPlayer.library.libraryFilling(pickedTiles.get(tileToInsert), column);
				pickedTiles.remove(tileToInsert);
			}
			scanner.nextLine();

            // Controlli e gestione del turno

            // Controlla se il giocatore ha completato qualche obiettivo comune
            //if(.checkCommonGoals()==true)
            	//ScoreTile.assegnaPunteggio

            // Controllo fine gioco
            if (currentPlayer.library.isFull()) 
            {
                gameEnded = true;
            } else 
            {
                // Passa al prossimo giocatore
                currentPlayer = nextPlayer(currentPlayer);
            }
        }

        // Calcola punteggio finale e dichiara il vincitore
        int punteggio_Massimo = 0;
        Player vincitore = null;

        for (Player giocatore : players) {
            int punteggio = currentPlayer.library.score()/*+giocatoreCorrente.assegnaPunteggio()*/+currentPlayer.personalObjective.playerScore(currentPlayer.library, currentPlayer.personalObjective);
            System.out.println(giocatore.getNickname() + " ha ottenuto un punteggio di " + punteggio);

            if (punteggio > punteggio_Massimo) {
                punteggio_Massimo = punteggio;
                vincitore = giocatore;
            }
        }

        System.out.println("Il vincitore e " + vincitore.getNickname() + "!");

        // Chiedi all'utente se vuole giocare un'altra partita
        System.out.print("Desideri giocare un'altra partita? (sì/no) ");
        String risposta = scanner.nextLine();
        if (risposta.equalsIgnoreCase("sì")) {
        	executeGame();
        } else {
            System.out.println("Grazie per aver giocato! Arrivederci!");
        }
    }
}






