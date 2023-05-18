package gioco;

public class Card extends PersonalObjective {
	
	final int row=6;
	final int column=5;
	String [][] cardGeneral= new String [row][column];
	
	/**
	 * @param numCard numero della carta che si vuole creare
	 */
	public Card (int numCard) {
		String [][] card=this.cardGeneral;
		switch (numCard) {
		
			case 0:
				card [0][4]="blue";
				card [1][1]="green";
				card [2][2]="cyan";
				card [3][0]="pink";
				card [4][3]="white";
				card [5][3]="yellow";
				break;
				
			case 1:
				card [0][0]="pink";
				card [0][2]="blue";
				card [1][4]="green";
				card [2][3]="white";
				card [3][1]="yellow";
				card [5][2]="cyan";
				break;
		
			case 2:
				card [0][0]="green";
				card [1][3]="blue";
				card [2][1]="pink";
				card [3][0]="cyan";
				card [4][4]="yellow";
				card [5][2]="white";
				break;
				
			case 3:
				card [0][2]="cyan";
				card [0][4]="green";
				card [2][3]="white";
				card [4][1]="yellow";
				card [4][3]="blue";
				card [5][2]="white";
				break;
				
			case 4:
				card [0][2]="white";
				card [1][1]="pink";
				card [2][2]="blue";
				card [3][3]="cyan";
				card [4][4]="yellow";
				card [5][0]="green";
				break;
				
			case 5:
				card [0][2]="pink";
				card [1][1]="white";
				card [2][0]="yellow";
				card [3][2]="blue";
				card [4][4]="green";
				card [5][3]="cyan";
				break;
				
			case 6:
				card [1][1]="cyan";
				card [3][1]="blue";
				card [3][2]="white";
				card [4][4]="pink";
				card [5][0]="yellow";
				card [5][3]="green";
				break;
				
			case 7:
				card [0][4]="yellow";
				card [2][0]="cyan";
				card [2][2]="blue";
				card [3][3]="pink";
				card [4][1]="white";
				card [4][2]="green";
				break;
				
			case 8:
				card [0][4]="cyan";
				card [1][1]="yellow";
				card [2][0]="white";
				card [3][3]="green";
				card [4][1]="blue";
				card [3][3]="pink";
				break;
				
			case 9:
				card [0][2]="yellow";
				card [2][2]="green";
				card [3][4]="white";
				card [4][1]="cyan";
				card [4][4]="pink";
				card [5][0]="blue";
				break;
			
			case 10:
				card [1][0]="blue";
				card [1][3]="yellow";
				card [2][2]="pink";
				card [3][1]="green";
				card [3][4]="cyan";
				card [5][0]="white";
				break;
				
			case 11:
				card [1][1]="pink";
				card [2][0]="green";
				card [2][2]="yellow";
				card [3][4]="white";
				card [4][3]="cyan";
				card [5][4]="blue";
				break;
		}//fine case
			
	}// fine costruttore Card
	
	/**
	 * @param row numero di riga
	 * @param column numero di colonna
	 * @return ritorna il colore di una cella all'interno della carta obbiettivo personale
	 */
	public String getColor(int row, int column) {
		return String.valueOf(this.cardGeneral[row][column]);
	}
	
	
	//STAMPARE OBIETTIVO PERSONALE
	public void printCard () {
		for (int contRow=0; contRow<6;contRow++) {
			for(int contColumn=0; contColumn<5; contColumn++) {
				System.out.print(this.cardGeneral[contRow][contColumn]+" ");
			}
			System.out.println();
		}
	}// fine metodo printCard
}
