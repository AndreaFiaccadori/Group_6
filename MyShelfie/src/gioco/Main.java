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


//Codice Nuovo.

package Gioco

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gioco {
	//private static final int NUMERO_CARTE_OBBIETTIVO_COMUNE = ;
    //private static final int NUMERO_CARTE_OBBIETTIVO_PERSONALE = ;

    private List<Giocatore> giocatori;
    private Random random;
    private Scanner scanner;

    public Gioco() {
        this.giocatori = new ArrayList<>();
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }
    
    public int chiediNumeroGiocatori() {
        System.out.print("Inserisci il numero di giocatori: ");
        return scanner.nextInt();
    }

    public void creaGiocatori(int numeroGiocatori) {
        for (int i = 1; i <= numeroGiocatori; i++) {
            Giocatore giocatore = new Giocatore(i);
            giocatori.add(giocatore);
        }
    }
    
    public Giocatore prossimoGiocatore(Giocatore giocatoreCorrente) {
        int indiceCorrente = giocatori.indexOf(giocatoreCorrente);
        int indiceSuccessivo = (indiceCorrente + 1) % giocatori.size();
        return giocatori.get(indiceSuccessivo);
    }
    
    public void esegui_Gioco() {
        System.out.println("Benvenuti! Iniziamo il gioco!");

        int numero_Giocatori = chiediNumeroGiocatori();
        creaGiocatori(numero_Giocatori);

        // Chiedi il nickname a ciascun giocatore
        for (Giocatore giocatore : giocatori) 
        {
            System.out.println("Inserisci il nickname per il giocatore " + giocatore.getOrdine() + ": ");
            String nickname = scanner.nextLine();
            giocatore.setNickname(nickname);
        }

        // Estrai le carte obiettivo comune
        CommonObjective carte_Obiettivo_Comune1=new CommonObjective();
        CommonObjective carte_Obiettivo_Comune2=new CommonObjective();
        int n1 = carte_Obiettivo_Comune1.draw_card();
        int n2 = carte_Obiettivo_Comune1.draw_card2(n1);

        // Scegli casualmente chi inizia
        int indice_Giocatore_Iniziale = random.nextInt(numero_Giocatori);
        Giocatore giocatoreCorrente = giocatori.get(indice_Giocatore_Iniziale);

        // Riempi la plancia 
        Plank plank=new Plank(numero_Giocatori);

        boolean fine_Gioco = false;

        while (!fine_Gioco) 
        {
            // Ciclo 1 - Turno del giocatore corrente
            System.out.println("Turno di " + giocatoreCorrente.getNickname());
            System.out.println("-----");

            giocatoreCorrente.libreria.printLibrary();
            giocatoreCorrente.tesseraPersonale.showObjective();

            System.out.print("Quante tessere oggetto desideri prendere? ");
            int numeroTessereOggetto = scanner.nextInt();
            scanner.nextLine();

            //codice di Falconi dalla riga 33 

            // Controlli e gestione del turno

            // Controlla se il giocatore ha completato qualche obiettivo comune
            //if(.checkCommonGoals()==true)
            	//ScoreTile.assegnaPunteggio
            // Controlla se la plancia deve essere riempita
            if (plank.isToFill()==true) 
            {
                plank.fillPlank();
            }

            // Controllo fine gioco
            if (giocatoreCorrente.libreria.isFull()) 
            {
                fine_Gioco = true;
            } else 
            {
                // Passa al prossimo giocatore
                giocatoreCorrente = prossimoGiocatore(giocatoreCorrente);
            }
        }

        // Calcola punteggio finale e dichiara il vincitore
        int punteggio_Massimo = 0;
        Giocatore vincitore = null;

        for (Giocatore giocatore : giocatori) {
            int punteggio = giocatoreCorrente.libreria.score()/*+giocatoreCorrente.assegnaPunteggio()*/+giocatoreCorrente.tesseraPersonale.playerScore(giocatoreCorrente.libreria);
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
            esegui_Gioco();
        } else {
            System.out.println("Grazie per aver giocato! Arrivederci!");
        }
    }
}






