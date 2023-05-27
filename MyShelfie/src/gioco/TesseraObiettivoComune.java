package gioco;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TesseraObiettivoComune {
	private static int COUNT=1;
	public final int id;
	
	public TesseraObiettivoComune() {
		this.id = COUNT++;
	}
	
	public int draw_card() {	//pesca obiettivo comune 1
		Random rand = new Random(); 	      
	    int upperbound = 12;    
	    int random = rand.nextInt(upperbound);
	    return random;
	}
	
	public int draw_card2(int random1) {	//pesca obiettivo comune 2
		int random2;
		Random rand = new Random(); 	      
	    int upperbound = 12;    
	    do {
	    	random2 = rand.nextInt(upperbound);
	    }while(random1 == random2);
	    return random2;
	}
	
	public void show_objective(int a, int b) { //mostra l'obiettivo 1-->a e 2-->b
		int i=0;
		System.out.println("Obiettivo 1:\n");
		do {	
		if(a==b) {
			System.out.println("Obiettivo 2:\n");
		}
		
	    switch(a) {
	    case 0: 
	    		System.out.println("Six groups each containing at least\r\n"
	    		+ "2 tiles of the same type (not necessarily\r\n"
	    		+ "in the depicted shape).\r\n"
	    		+ "The tiles of one group can be different\r\n"
	    		+ "from those of another group");
	    		System.out.println("\n\t*****\n"+"\t*   *\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"+"\t*   *\n"
				+"\t*****\n"+"\t*   *\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"+"\t*   *\n"+"\t*****\n");
	    		break;
	    
	    case 1: 
	    		System.out.println("Four groups each containing at least\r\n"
	    		+ "4 tiles of the same type (not necessarily\r\n"
	    		+ "in the depicted shape).\r\n"
	    		+ "The tiles of one group can be different\r\n"
	    		+ "from those of another group.");		
	    		System.out.println("\n\t*****\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"
				+"\t*****\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"+"\t*****\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"
				+"\t*****\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"+"\t*****\n");
	    		break;
	    		
	    case 2: 
	    		System.out.println("Four tiles of the same type in the four\r\n"
	    		+ "corners of the bookshelf.");
	    		break;
	    		
	    case 3: 
	    		System.out.println("Two groups each containing 4 tiles of\r\n"
	    		+ "the same type in a 2x2 square. The tiles\r\n"
	    		+ "of one square can be different from\r\n"
	    		+ "those of the other square.");
	    		break;
	    		
	    case 4: 
	    		System.out.println("Three columns each formed by 6 tiles Five tiles of the same type forming an X.\r\n"
	    		+ "of maximum three different types. One\r\n"
	    		+ "column can show the same or a different\r\n"
	    		+ "combination of another column.");
	    		break;
	    		
	    case 5: 
	    		System.out.println("Eight tiles of the same type. There’s no\r\n"
	    		+ "restriction about the position of these\r\n"
	    		+ "tiles.");
	    		break;
	    		
	    case 6: 
	    		System.out.println("Five tiles of the same type forming a\r\n"
	    		+ "diagonal. ");
	    		break;
	    		
	    case 7: 
	    		System.out.println("Four lines each formed by 5 tiles of\r\n"
	    		+ "maximum three different types. One\r\n"
	    		+ "line can show the same or a different\r\n"
	    		+ "combination of another line.");
	    		break;
	    		
	    case 8: 
	    		System.out.println("Two columns each formed by 6\r\n"
	    		+ "different types of tiles. ");
	    		break;
	    		
	    case 9: 
	    		System.out.println("Two lines each formed by 5 different\r\n"
	    		+ "types of tiles. One line can show the\r\n"
	    		+ "same or a different combination of the\r\n"
	    		+ "other line.");
	    		break;
	    		
	    case 10: 
	    		 System.out.println("Five tiles of the same type forming an X.");
	    		 break;
	    		 
	    case 11: 
	    		 System.out.println("Five columns of increasing or decreasing\r\n"
	    		+ "height. Starting from the first column on\r\n"
	    		+ "the left or on the right, each next column\r\n"
	    		+ "must be made of exactly one more tile.\r\n"
	    		+ "Tiles can be of any type. ");
	    		 break;
	    }
	    i++;
	    a=b;
		}while(i != 2);
	}
	
	public boolean checkCommonGoals(int numeroTessera, Library libreriaGiocatore) {
		boolean check=false;
		int row=0;
		int col=0;
		int contatore=0;		
		Tile libraryCopy[][]=new Tile[row][col];
		String tileType;
		switch(numeroTessera){
		case 0:
			String currentTile;
			String nextTile;
			String belowTile;
			int orizontalCount=0;
			int verticalCount=0;
			Set<String> verticaleGiaControllato= new HashSet<>();
			
			for(row=0; row<6; row++) {
				for(col=0; col<5; col++) {
					currentTile=libreriaGiocatore.library[row][col].getType();
					nextTile=libreriaGiocatore.library[row][col+1].getType();
					if(currentTile!=null && nextTile!=null && currentTile==nextTile) {
						orizontalCount++;
						libreriaGiocatore.library[row][col]=null;
						libreriaGiocatore.library[row][col+1]=null;
						col++;
					}
				}
			}
			if(orizontalCount>=6) {
				check=true;
			}
			
			if(!check) {
				for(col=0; col<5; col++) {
					currentTile=libreriaGiocatore.library[row][col].getType();
					belowTile=libreriaGiocatore.library[row+1][col].getType();
					if(currentTile!=null && nextTile!=null && currentTile==nextTile && 
						!verticaleGiaControllato.contains(currentTile) &&
						!verticaleGiaControllato.contains(belowTile)) {
							verticalCount++;
							verticaleGiaControllato.add(currentTile);
							verticaleGiaControllato.add(belowTile);
					}
				}
			}
			if((orizontalCount+verticalCount)>=6) {
				check=true;
			}else {
				check=false;
			}
			break;
			
		case 1:
			break;
			
		case 2:
			if(libreriaGiocatore.library[0][0].getType()==libreriaGiocatore.library[0][4].getType() && 
			libreriaGiocatore.library[0][0].getType()==libreriaGiocatore.library[5][0].getType() && 
			libreriaGiocatore.library[0][0].getType()==libreriaGiocatore.library[5][4].getType()) {
				check=true;
			}else {
				check=false;
			}
			break;
		
		case 3:
			int quadrato=0;
			String tileType1;
			String tileType2;
			String tileType3;
			String tileType4;
			String[] tileTypeBonus1=new String[5];
			Tile posizioneCopia[][]=new Tile[0][1];
			int k=0;
			
			
			
			for(row=5; row>0; row--) {
				for(col=0; col<4; col++) {					
						if(libreriaGiocatore.library[row][col].getType()!=null) {
						tileType1=libraryCopy[row][col].getType();
						tileType2=libraryCopy[row][col+1].getType();
						tileType3=libraryCopy[row-1][col].getType();
						tileType4=libraryCopy[row-1][col+1].getType();
							if(tileType1==tileType2 && tileType1==tileType3 && tileType1==tileType4){			
									quadrato++;								
									if(quadrato==1) {
										tileTypeBonus1[k]=tileType1;
										k++;
										posizioneCopia[0][0]=libraryCopy[row-1][col];
										posizioneCopia[0][1]=libraryCopy[row-1][col+1];
									}
									
									if(quadrato>1 || posizioneCopia[0][0]!=libraryCopy[row][col] 
										|| posizioneCopia[0][1]!=libraryCopy[row][col+1]) {
										for(int r=0; r<6; r++) {
											if(tileTypeBonus1[r]!=tileType1) {
												quadrato=1;
											}												
										}										
									}
									col=col+2;
							}						
						}					
				}	
			}
			if(quadrato>=2) {
				check=true;
			}else {
				check=false;
			}			
			break;
			
		case 4:
			int escludi=0;
			contatore=0;
			int[] c=new int[5];

			for(col=0; col<5; col++) {
				escludi=0;
				for(row=0; row<6; row++) {
					if(libreriaGiocatore.library[row][col].getType() != null) {
						
						tileType=libraryCopy[row][col].getType();
						
						if(tileType.contentEquals("cat")) {
							c[0]++;
						}
						
						if(tileType.contentEquals("book")) {
							c[1]++;
						}
						
						if(tileType.contentEquals("game")) {
							c[2]++;
						}
						
						if(tileType.contentEquals("frame")) {
							c[3]++;
						}
						
						if(tileType.contentEquals("trophy")) {
							c[4]++;
						}
						
						if(tileType.contentEquals("plant")) {
							c[5]++;
						}
						
					}else {
						escludi=1;
					}
				}
				if(escludi!=1) {
					if(c[0]<=3 && c[1]<=3 && c[2]<=3 && c[3]<=3 && c[4]<=3 && c[5]<=3) {
						contatore++;
					}
				}
			}
			
			if(contatore>=3) {
				check=true;
			}else {
				check=false;
			}

			break;
			
		case 5:
			int contatoreCat=0;
			int contatoreBook=0;
			int contatoreGame=0;
			int contatoreFrame=0;
			int contatoreTrophy=0;
			int contatorePlant=0;			
			tileType=libraryCopy[row][col].getType();
			
				for(row=0; row<6; row++) { 
					for(col=0; col<5; col++) {
						if(tileType.equals("cat")) {
							contatoreCat++;
						}
						if(tileType.equals("book")) {
							contatoreBook++;
						}
						if(tileType.equals("game")) {
							contatoreGame++;
						}
						if(tileType.equals("frame")) {
							contatoreFrame++;
						}
						if(tileType.equals("trophy")) {
							contatoreTrophy++;
						}
						if(tileType.equals("plant")) {
							contatorePlant++;
						}
					}
				}
				
				if(contatoreCat>=8 || contatoreBook>=8 || contatoreGame>=8 || contatoreFrame>=8 || contatoreTrophy>=8 || contatorePlant>=8) {
					check=true;
				}else {
					check=false;
				}	
						
			break;
			
		case 6:
			//controllo1 sx
			if(libreriaGiocatore.library[0][0].getType()==libreriaGiocatore.library[1][1].getType() 
			&& libreriaGiocatore.library[0][0].getType()==libreriaGiocatore.library[2][2].getType() 
			&& libreriaGiocatore.library[0][0].getType()==libreriaGiocatore.library[3][3].getType() 
			&& libreriaGiocatore.library[0][0].getType()==libreriaGiocatore.library[4][4].getType()) {
				check=true;
			}else {
				check=false;
			}
			//controllo2 sx
			if(libreriaGiocatore.library[1][0].getType()==libreriaGiocatore.library[2][1].getType() 
			&& libreriaGiocatore.library[1][0].getType()==libreriaGiocatore.library[3][2].getType() 
			&& libreriaGiocatore.library[1][0].getType()==libreriaGiocatore.library[4][3].getType() 
			&& libreriaGiocatore.library[1][0].getType()==libreriaGiocatore.library[5][4].getType()) {
				check=true;
			}else {
				check=false;
			}
			//controllo1 dx
			if(libreriaGiocatore.library[0][4].getType()==libreriaGiocatore.library[1][3].getType() 
			&& libreriaGiocatore.library[0][4].getType()==libreriaGiocatore.library[2][2].getType() 
			&& libreriaGiocatore.library[0][4].getType()==libreriaGiocatore.library[3][1].getType() 
			&& libreriaGiocatore.library[0][4].getType()==libreriaGiocatore.library[4][0].getType()) {
				check=true;
			}else {
				check=false;
			}
			//controllo2 dx
			if(libreriaGiocatore.library[1][4].getType()==libreriaGiocatore.library[2][3].getType() 
			&& libreriaGiocatore.library[1][4].getType()==libreriaGiocatore.library[3][2].getType() 
			&& libreriaGiocatore.library[1][4].getType()==libreriaGiocatore.library[4][1].getType() 
			&& libreriaGiocatore.library[1][4].getType()==libreriaGiocatore.library[5][0].getType()) {
				check=true;
			}else {
				check=false;
			}			
			break;
				
		case 7:
			int counter=0;
			for (Tile[] rowContr : libreriaGiocatore) {
				Set <String> rows = new HashSet<>();	
				for (Tile tileContr : rowContr) {	
					rows.add(String.valueOf(tileContr.getColor()));
				}
				if (rows.size()<=3) {
					counter++;
				}
			}
			if (counter>=4) {
				return true;}
			if (counter<4) {
				return false;}
			break;
			
		case 8:
			 counter=0;
			for (int countColumn=0; countColumn<5; countColumn++) {
				Set <String> rows = new HashSet<>();	
				for (int countRow=0; countRow<6; countRow++) {		
					rows.add(String.valueOf(libreriaGiocatore.library[countRow][countColumn].getColor()));	
				}
				if (rows.size()==6) {
					counter++;}
			}
			if (counter>=2) {
				return true;}
			if (counter<2) {
				return false;}
			break;
			
		case 9:	
			 counter=0;
			for (Tile[] rowContr : libreriaGiocatore) {
				Set <String> rows = new HashSet<>();	
				for (Tile tileContr : rowContr) {	
					rows.add(String.valueOf(tileContr.getColor()));
				}
				if (rows.size()==5) {
					counter++;}
			}
			if (counter>=2) {
				return true;}
			if (counter<2) {
				return false;}
			break;
			
		case 10:
			String librColor, librColorCh, librColorCh1, librColorCh2, librColorCh3= new String ();
			//controllo colonna centrale (2) a dx+1 e sx+1
			for (int contRow=0; contRow<4; contRow++) {
				librColor=String.valueOf(libreriaGiocatore.library[contRow][2].getColor());
				librColorCh=String.valueOf(libreriaGiocatore.library[contRow][0].getColor());
				librColorCh1=String.valueOf(libreriaGiocatore.library[contRow+2][2].getColor());
				librColorCh2=String.valueOf(libreriaGiocatore.library[contRow+2][0].getColor());
				librColorCh3=String.valueOf(libreriaGiocatore.library[contRow+1][1].getColor());
				if (librColor.equals("null") || librColorCh.equals("null") || librColorCh1.equals("null") || librColorCh2.equals("null") || librColorCh3.equals("null")) {
					continue;}
				if (librColor==librColorCh && librColor==librColorCh1 && librColor==librColorCh2 && librColor==librColorCh3) {
					return true;}
				else {
					librColorCh=String.valueOf(libreriaGiocatore.library[contRow][4].getColor());
					librColorCh2=String.valueOf(libreriaGiocatore.library[contRow+2][4].getColor());
					librColorCh3=String.valueOf(libreriaGiocatore.library[contRow+1][3].getColor());
					
					if (librColor.equals("null") || librColorCh.equals("null") || librColorCh1.equals("null") || librColorCh2.equals("null") || librColorCh3.equals("null")) {
						continue;}
					if (librColor==librColorCh && librColor==librColorCh1 && librColor==librColorCh2 && librColor==librColorCh3) {
						return true;}
				}
			}
			//controllo colonna centrale (2) e obliquo dx e sx
			for (int contRow=1; contRow<5; contRow++) {
				librColor=String.valueOf(libreriaGiocatore.library[contRow][2].getColor());
				librColorCh=String.valueOf(libreriaGiocatore.library[contRow-1][1].getColor());
				librColorCh1=String.valueOf(libreriaGiocatore.library[contRow-1][3].getColor());
				librColorCh2=String.valueOf(libreriaGiocatore.library[contRow+1][1].getColor());
				librColorCh3=String.valueOf(libreriaGiocatore.library[contRow+1][3].getColor());

				if (librColor.equals("null") || librColorCh.equals("null") || librColorCh1.equals("null") || librColorCh2.equals("null") || librColorCh3.equals("null")) {
					continue;}		
				if (librColor==librColorCh && librColor==librColorCh1 && librColor==librColorCh2 && librColor==librColorCh3) {
					return true;}
			}
			return false;
			break;
			
		case 11:
			check=true;
			//controllo 1 sx
			k=-1;
			for(col=0; col<5; col++) {
				for(row=4; row>k; row--) {
					if(libreriaGiocatore.library[row][col].getType()==null) {
						check=false;
					}
				}
				k++;		
			}
			
			//controllo 2 sx
			if(check) {
				k=0;
				for(col=0; col<5; col++) {
					for(row=5; row>k; row--) {
						if(libreriaGiocatore.library[row][col].getType()==null) {
							check=false;
						}
					}
					k++;		
				}
			}
			
			
			//controllo 1 dx
			if(check) {
				k=-1;
				for(col=4; col>-1; col--) {
					for(row=4; row>k; row--) {
						if(libreriaGiocatore.library[row][col].getType()==null) {
							check=false;
						}
					}
					k++;		
				}
			}
				
			//controllo 2 dx
			if(check) {
				k=0;
				for(col=4; col>-1; col--) {
					for(row=5; row>k; row--) {
						if(libreriaGiocatore.library[row][col].getType()==null) {
							check=false;
						}
					}
					k++;		
				}
			}
			
			break;
		}
		
	return check;
		
	}
	
	/*
	 * quando si chiama il metodo seguente dovremo dare alla variabile contatore un valore che
	 * aumenta ogni volta che un obiettivo viene completato
	 */
	public int assegnaPunteggio(int nPlayers, int contatore) { 
		
		if(nPlayers==2) {
			if(contatore==0) {
				return 8;
			}else {
				return 4;
			}
		}
		
		if(nPlayers==3) {
			if(contatore==0) {
				return 8;
			}
			if(contatore==1) {
				return 6;
			}else {
				return 4;
			}
		}
		
		if(nPlayers==4) {
			if(contatore==0) {
				return 8;
			}
			if(contatore==1) {
				return 6;
			}
			if(contatore==2) {
				return 4;
			}else {
				return 2;
			}
		}
		return 0;
		
	}

}
