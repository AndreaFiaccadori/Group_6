package gioco;

import java.util.Random;

public class PersonalObjective {
		
		//ESTRAZIONE CARTA
		public int [] drawCard (int numPlayer) {
			int [] extractions=new int [numPlayer];
			
			int [] cardNotDraw =new int [12];		//array di numeri che posso estrarre
			for (int cont=0; cont<12; cont++) {
				cardNotDraw [cont]=cont;
			}
			
			Random random = new Random();
			for (int contExtraction=0; contExtraction<numPlayer; contExtraction++) {
				int randNum;
				do{
					randNum=random.nextInt(11);
				}
				while (cardNotDraw[randNum]==15);
				cardNotDraw[randNum]=15;
				extractions [contExtraction]=randNum;
			}
			return extractions;
		}// fine metodo drawCard
		
		
		//CONTATORE PUNTEGGIO
		public int PlayerScore (Library personalLibrary, Card personalCard) {
			int score=0;
			String cardColor=new String();
			String libraryColor=new String();
			for (int contRow=0; contRow<6;contRow++) {
				for(int contColumn=0; contColumn<5; contColumn++) {
					cardColor=personalCard.getColor(contRow, contColumn);
					if (cardColor.equals("null")) {
						continue;
					}
					else {
						libraryColor=String.valueOf(personalLibrary[contRow][contColumn].getColor);
						if (str.equals(str1)) {
							score++;
						}
						continue;
					}
				}
			}//fine controllo libreria e carta obbiettivo personale
	
			//attribuzione punti
			switch(score) {
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					score=4;
					break;
				case 4:
					score=6;
					break;
				case 5:
					score=9;
					break;
				case 6:
					score=12;
					break;
			}
			
			return score;
			//tile.getColor==colore;
		}//fine metodo 
		
		
		
	}//fine classe

