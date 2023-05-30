package gioco;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/**
 * It rapresents the object, objective 
 * common card
 * @author Locatelli Giacomo
 *
 */
public class CommonObjective {
	private static int COUNT=1;
	public final int id;
	
	public CommonObjective() {
		this.id = COUNT++;
	}
	/**
	 * draw the first objective common card
	 * @return the number of the common card
	 */
	public int draw_card() {	
		Random rand = new Random(); 	      
	    int upperbound = 12;    
	    int random = rand.nextInt(upperbound);
	    return random;
	}
	/**
	 * draw the second objective common card
	 * @param the number of the first common card
	 * @return the number of the second common card
	 */
	public int draw_card2(int random1) {	//pesca obiettivo comune 2
		int random2;
		Random rand = new Random(); 	      
	    int upperbound = 12;    
	    do {
	    	random2 = rand.nextInt(upperbound);
	    }while(random1 == random2);
	    return random2;
	}
	/**
	 * show the objective card goal
	 * @param the number of the common card you want to show
	 */
	public void show_objective(int a) {
		System.out.println("\033[0;32mCommon objective " + id + ":\033[0m");
		
	    switch(a) {
	    case 0: 
	    		System.out.println("Six groups each containing at least\r\n"
	    		+ "2 tiles of the same type (not necessarily\r\n"
	    		+ "in the depicted shape).\r\n"
	    		+ "The tiles of one group can be different\r\n"
	    		+ "from those of another group");
	    		System.out.println("[=]");
	    		System.out.println("[=]");
	    		System.out.println("x6");
	    		break;
	    
	    case 1: 
	    		System.out.println("Four groups each containing at least\r\n"
	    		+ "4 tiles of the same type (not necessarily\r\n"
	    		+ "in the depicted shape).\r\n"
	    		+ "The tiles of one group can be different\r\n"
	    		+ "from those of another group.");		
	    		System.out.println("[=]");
	    		System.out.println("[=]");
	    		System.out.println("[=]");
	    		System.out.println("[=]");
	    		System.out.println("x4");
	    		
	    		break;
	    		
	    case 2: 
	    		System.out.println("Four tiles of the same type in the four\r\n"
	    		+ "corners of the bookshelf.");
	    		System.out.println("[=][ ][ ][ ][=]");
	    		System.out.println("[ ][ ][ ][ ][ ]");
	    		System.out.println("[ ][ ][ ][ ][ ]");
	    		System.out.println("[ ][ ][ ][ ][ ]");
	    		System.out.println("[ ][ ][ ][ ][ ]");
	    		System.out.println("[=][ ][ ][ ][=]");
	    		break;
	    		
	    case 3: 
	    		System.out.println("Two groups each containing 4 tiles of\r\n"
	    		+ "the same type in a 2x2 square. The tiles\r\n"
	    		+ "of one square can be different from\r\n"
	    		+ "those of the other square.");
	    		System.out.println("[=][=]");
	    		System.out.println("[=][=]");
	    		System.out.println("  x2");
	    		break;
	    		
	    case 4: 
	    		System.out.println("Three columns each formed by 6 tiles\r\n"
	    		+ "of maximum three different types. One\r\n"
	    		+ "column can show the same or a different\r\n"
	    		+ "combination of another column.");
	    		System.out.println("[ ]");
	    		System.out.println("[ ]");
	    		System.out.println("[ ]" + "\tmax 3 [!=]");
	    		System.out.println("[ ]");
	    		System.out.println("[ ]");
	    		System.out.println("[ ]");
	    		System.out.println("x3");
	    	
	    		break;
	    		
	    case 5: 
	    		System.out.println("Eight tiles of the same type. There's no\r\n"
	    		+ "restriction about the position of these\r\n"
	    		+ "tiles.");
	    		System.out.println("  [=] [=]");
	    		System.out.println("[=] [=] [=]");
	    		System.out.println("[=] [=] [=]");
	    		break;
	    		
	    case 6: 
	    		System.out.println("Five tiles of the same type forming a\r\n"
	    		+ "diagonal. ");
	    		System.out.println("[=]");
	    		System.out.println("   [=]");
	    		System.out.println("      [=]");
	    		System.out.println("         [=]");
	    		System.out.println("            [=]");
	    	
	    		break;
	    		
	    case 7: 
	    		System.out.println("Four lines each formed by 5 tiles of\r\n"
	    		+ "maximum three different types. One\r\n"
	    		+ "line can show the same or a different\r\n"
	    		+ "combination of another line.");
	    		System.out.println("[ ][ ][ ][ ][ ]");
	    		System.out.println("     x4");
	    		System.out.println("  max 3 [!=]");
	    		
	    		break;
	    		
	    case 8: 
	    		System.out.println("Two columns each formed by 6\r\n"
	    		+ "different types of tiles. ");
	    		System.out.println("[!=]");
	    		System.out.println("[!=]");
	    		System.out.println("[!=]");
	    		System.out.println("[!=]");
	    		System.out.println("[!=]");
	    		System.out.println("[!=]");
	    		System.out.println("x2");
	    		break;
	    		
	    case 9: 
	    		System.out.println("Two lines each formed by 5 different\r\n"
	    		+ "types of tiles. One line can show the\r\n"
	    		+ "same or a different combination of the\r\n"
	    		+ "other line.");
	    		System.out.println("[!=][!=][!=][!=][!=]");
	    		System.out.println("         x2");
	    		break;
	    		
	    case 10: 
	    		 System.out.println("Five tiles of the same type forming an X.");
	    		 System.out.println("[=]   [=]");
	    		 System.out.println("   [=]");
		    	 System.out.println("[=]   [=]");
	    		 break;
	    		 
	    case 11: 
	    		 System.out.println("Five columns of increasing or decreasing\r\n"
	    		+ "height. Starting from the first column on\r\n"
	    		+ "the left or on the right, each next column\r\n"
	    		+ "must be made of exactly one more tile.\r\n"
	    		+ "Tiles can be of any type. ");
	    		System.out.println("[ ]");
	    		System.out.println("[ ][ ]");
	    		System.out.println("[ ][ ][ ]");
	    		System.out.println("[ ][ ][ ][ ]");
	    		System.out.println("[ ][ ][ ][ ][ ]");
	    		 break;
	    }
	}
	/**
	 * check if the common goal is verified
	 * @param the number of the objective card you want to check
	 * @param libreriaGiocatore
	 * @return true if the goal is verified, false if not
	 */
	public static boolean checkCommonGoals(int numeroTessera, Library libreriaGiocatore) {
		boolean check=false;
		int row=0;
		int col=0;
		int contatore=0;
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
					if(libreriaGiocatore.library[row][col] != null && libreriaGiocatore.library[row][col+1] != null) {
						currentTile=libreriaGiocatore.library[row][col].getType();
						nextTile=libreriaGiocatore.library[row][col+1].getType();
						if(currentTile!=null && nextTile!=null && currentTile.equals(nextTile)) {
							orizontalCount++;
							libreriaGiocatore.library[row][col]=null;
							libreriaGiocatore.library[row][col+1]=null;
							col++;
						}
					}
				}
			}
			if(orizontalCount>=6) {
				check=true;
			}
			
			if(!check) {
				for(row=0; row<5; row++) {
					for(col=0; col<5; col++) {
						if(libreriaGiocatore.library[row][col] != null && libreriaGiocatore.library[row+1][col] != null) {
							currentTile=libreriaGiocatore.library[row][col].getType();
							belowTile=libreriaGiocatore.library[row+1][col].getType();
							if(currentTile!=null && belowTile!=null && currentTile.equals(belowTile) && 
								!verticaleGiaControllato.contains(currentTile) &&
								!verticaleGiaControllato.contains(belowTile)) {
									verticalCount++;
									verticaleGiaControllato.add(currentTile);
									verticaleGiaControllato.add(belowTile);
							}
						}
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
			String nextTile1;
			String nextTile2;
			String nextTile3;
			String belowTile1;
			String belowTile2;
			String belowTile3;
			orizontalCount=0;
			verticalCount=0;
			
			for(row=0; row<6; row++) {
				for(col=0; col<2; col++) {
					if(libreriaGiocatore.library[row][col]!=null && libreriaGiocatore.library[row][col+1]!=null && 
						libreriaGiocatore.library[row][col+2]!=null && libreriaGiocatore.library[row][col+3]!=null) {
						currentTile=libreriaGiocatore.library[row][col].getType();
						nextTile1=libreriaGiocatore.library[row][col+1].getType();
						nextTile2=libreriaGiocatore.library[row][col+2].getType();
						nextTile3=libreriaGiocatore.library[row][col+3].getType();
						if(currentTile!=null && nextTile1!=null && nextTile2!=null && nextTile3!=null && 
							currentTile.equals(nextTile1) && currentTile.equals(nextTile2) && 
							currentTile.equals(nextTile3)) {
								orizontalCount++;
								libreriaGiocatore.library[row][col]=null;
								libreriaGiocatore.library[row][col+1]=null;
								libreriaGiocatore.library[row][col+2]=null;
								libreriaGiocatore.library[row][col+3]=null;				
						}	
					}				
				}
			}
			
			if(orizontalCount>=4) {
				check=true;
			}
			
			if(!check) {
				for(row=0; row<3; row++) {
					for(col=0; col<5; col++) {
						if(libreriaGiocatore.library[row][col]!=null && libreriaGiocatore.library[row+1][col]!=null && 
							libreriaGiocatore.library[row+2][col]!=null && libreriaGiocatore.library[row+3][col]!=null) {
							currentTile=libreriaGiocatore.library[row][col].getType();
							belowTile1=libreriaGiocatore.library[row+1][col].getType();
							belowTile2=libreriaGiocatore.library[row+2][col].getType();
							belowTile3=libreriaGiocatore.library[row+3][col].getType();
							if(currentTile!=null && belowTile1!=null && belowTile2!=null && belowTile3!=null && 
								currentTile.equals(belowTile1) && currentTile.equals(belowTile2) && 
								currentTile.equals(belowTile3)) {
										orizontalCount++;
										libreriaGiocatore.library[row][col]=null;
										libreriaGiocatore.library[row+1][col]=null;
										libreriaGiocatore.library[row+2][col]=null;
										libreriaGiocatore.library[row+3][col]=null;				
							}
						}
					}
				}
			}
			
			if((orizontalCount+verticalCount)>=4) {
				check=true;
			}else {
				check=false;
			}
			
			break;
			
		case 2:
			if(libreriaGiocatore.library[0][0]!=null && libreriaGiocatore.library[0][4]!=null 
			&& libreriaGiocatore.library[5][0]!=null && libreriaGiocatore.library[5][4]!=null) {
				if(libreriaGiocatore.library[0][0].getType().equals(libreriaGiocatore.library[0][4].getType()) && 
				   libreriaGiocatore.library[0][0].getType().equals(libreriaGiocatore.library[5][0].getType()) && 
				   libreriaGiocatore.library[0][0].getType().equals(libreriaGiocatore.library[5][4].getType())) {
					check=true;
				}else {
					check=false;
				}
			}
			
			break;
		
		case 3:
			int quadrato=0;
			String tileType1;
			String tileType2;
			String tileType3;
			String tileType4;
			String[] tileTypeBonus1=new String[6];
			Tile posizioneCopia[][]=new Tile[2][1];
			int k=0;
			
			
			
			for(row=5; row>0; row--) {
				for(col=0; col<4; col++) {
					if(libreriaGiocatore.library[row][col]!=null && libreriaGiocatore.library[row][col+1]!=null && 
						libreriaGiocatore.library[row-1][col]!=null && libreriaGiocatore.library[row-1][col+1]!=null) {
						tileType1=libreriaGiocatore.library[row][col].getType();
						tileType2=libreriaGiocatore.library[row][col+1].getType();
						tileType3=libreriaGiocatore.library[row-1][col].getType();
						tileType4=libreriaGiocatore.library[row-1][col+1].getType();
						if(tileType1.equals(tileType2) && tileType1.equals(tileType3) && tileType1.equals(tileType4)){			
							quadrato++;								
							if(quadrato==1) {
								tileTypeBonus1[k]=tileType1;
								k++;
								posizioneCopia[0][0]=libreriaGiocatore.library[row-1][col];
								posizioneCopia[1][0]=libreriaGiocatore.library[row-1][col+1];
							}
							if(quadrato>1 || !posizioneCopia[0][0].equals(libreriaGiocatore.library[row][col] )
							   || !posizioneCopia[1][0].equals(libreriaGiocatore.library[row][col+1])) {
								for(int r=0; r<6; r++) {
									if(!tileTypeBonus1[r].equals(tileType1)) {
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
			int[] c=new int[6];

			for(col=0; col<5; col++) {
				escludi=0;
				for(row=0; row<6; row++) {
					if(libreriaGiocatore.library[row][col] != null) {
						
						tileType=libreriaGiocatore.library[row][col].getType();
						
						if(tileType.equals("cat")) {
							c[0]++;
						}
						
						if(tileType.equals("book")) {
							c[1]++;
						}
						
						if(tileType.equals("game")) {
							c[2]++;
						}
						
						if(tileType.equals("frame")) {
							c[3]++;
						}
						
						if(tileType.equals("trophy")) {
							c[4]++;
						}
						
						if(tileType.equals("plant")) {
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
			if(libreriaGiocatore.library[row][col] != null) {
				for(row=0; row<6; row++) {
					for(col=0; col<5; col++) {
						tileType=libreriaGiocatore.library[row][col].getType();
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
				} else {
					check=false;
				}
			}
			break;
			
		case 6:
			if(libreriaGiocatore.library[0][0]!=null && libreriaGiocatore.library[1][1]!=null && libreriaGiocatore.library[2][2]!=null && 
			   libreriaGiocatore.library[3][3]!=null && libreriaGiocatore.library[4][4]!=null) {
				//controllo1 sx
				if(libreriaGiocatore.library[0][0].getType().equals(libreriaGiocatore.library[1][1].getType()) 
				&& libreriaGiocatore.library[0][0].getType().equals(libreriaGiocatore.library[2][2].getType()) 
				&& libreriaGiocatore.library[0][0].getType().equals(libreriaGiocatore.library[3][3].getType()) 
				&& libreriaGiocatore.library[0][0].getType().equals(libreriaGiocatore.library[4][4].getType())) {
					check=true;
				}else {
					check=false;
				}
			}
			
			if(libreriaGiocatore.library[1][0]!=null && libreriaGiocatore.library[2][1]!=null && libreriaGiocatore.library[3][2]!=null && 
			   libreriaGiocatore.library[4][3]!=null && libreriaGiocatore.library[5][4]!=null) {
				//controllo2 sx
				if(libreriaGiocatore.library[1][0].getType().equals(libreriaGiocatore.library[2][1].getType()) 
				&& libreriaGiocatore.library[1][0].getType().equals(libreriaGiocatore.library[3][2].getType()) 
				&& libreriaGiocatore.library[1][0].getType().equals(libreriaGiocatore.library[4][3].getType()) 
				&& libreriaGiocatore.library[1][0].getType().equals(libreriaGiocatore.library[5][4].getType())) {
					check=true;
				}else {
					check=false;
				}
			}
			
			if(libreriaGiocatore.library[0][4]!=null && libreriaGiocatore.library[1][3]!=null && libreriaGiocatore.library[2][2]!=null && 
			   libreriaGiocatore.library[3][1]!=null && libreriaGiocatore.library[4][0]!=null) {
				//controllo1 dx
				if(libreriaGiocatore.library[0][4].getType().equals(libreriaGiocatore.library[1][3].getType()) 
				&& libreriaGiocatore.library[0][4].getType().equals(libreriaGiocatore.library[2][2].getType()) 
				&& libreriaGiocatore.library[0][4].getType().equals(libreriaGiocatore.library[3][1].getType()) 
				&& libreriaGiocatore.library[0][4].getType().equals(libreriaGiocatore.library[4][0].getType())) {
					check=true;
				}else {
					check=false;
				}
			}
			
			if(libreriaGiocatore.library[1][4]!=null && libreriaGiocatore.library[2][3]!=null && libreriaGiocatore.library[3][2]!=null && 
			   libreriaGiocatore.library[4][1]!=null && libreriaGiocatore.library[5][0]!=null) {
				//controllo2 dx
				if(libreriaGiocatore.library[1][4].getType().equals(libreriaGiocatore.library[2][3].getType()) 
				&& libreriaGiocatore.library[1][4].getType().equals(libreriaGiocatore.library[3][2].getType()) 
				&& libreriaGiocatore.library[1][4].getType().equals(libreriaGiocatore.library[4][1].getType()) 
				&& libreriaGiocatore.library[1][4].getType().equals(libreriaGiocatore.library[5][0].getType())) {
					check=true;
				}else {
					check=false;
				}
			}
			break;
				
		case 7:
			int counter=0;
			for (Tile[] rowContr : libreriaGiocatore.library) {
				Set <String> rows = new HashSet<>();
				for (Tile tileContr : rowContr) {
					if(tileContr != null) {
						rows.add(String.valueOf(tileContr.getColor()));
					}
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
					if(libreriaGiocatore.library[countRow][countColumn] != null) {
						rows.add(String.valueOf(libreriaGiocatore.library[countRow][countColumn].getColor()));	
					}
				}
				if (rows.size()==6) {
					counter++;}
			}
			if (counter>=2) {
				return true;
			}
			if (counter<2) {
				return false;
			}
			break;
		case 9:
			counter=0;
			for (Tile[] rowContr : libreriaGiocatore.library) {
				Set <String> rows = new HashSet<>();	
				for (Tile tileContr : rowContr) {
					if(tileContr != null) {
						rows.add(String.valueOf(tileContr.getColor()));
					}
				}
				if (rows.size()==5) {
					counter++;}
			}
			if (counter>=2) {
				return true;
			}
			if (counter<2) {
				return false;
			}
			break;
		case 10:
			String librColor, librColorCh, librColorCh1, librColorCh2, librColorCh3= new String ();
			for (int contRow=0; contRow<4; contRow++) {
				for (int contCol=0; contCol<3; contCol++) {
					if(libreriaGiocatore.library[contRow][contCol]!=null && libreriaGiocatore.library[contRow][contCol+2]!=null 
					&& libreriaGiocatore.library[contRow+1][contCol+1]!=null && libreriaGiocatore.library[contRow+2][contCol]!=null 
					&&  libreriaGiocatore.library[contRow+2][contCol+2]!=null) {
						librColor=String.valueOf(libreriaGiocatore.library[contRow][contCol].getColor());
						librColorCh=String.valueOf(libreriaGiocatore.library[contRow][contCol+2].getColor());
						librColorCh1=String.valueOf(libreriaGiocatore.library[contRow+1][contCol+1].getColor());
						librColorCh2=String.valueOf(libreriaGiocatore.library[contRow+2][contCol].getColor());
						librColorCh3=String.valueOf(libreriaGiocatore.library[contRow+2][contCol+2].getColor());
						if (librColorCh.equals(librColor) && librColorCh1.equals(librColor) && librColorCh2.equals(librColor) && librColorCh3.equals(librColor)) {
						return true;
						}
					}
				}
			}
			return false;
		case 11:
			check=true;
			//controllo 1 sx
			k=-1;
			for(col=0; col<5; col++) {
				for(row=4; row>k; row--) {
					if(libreriaGiocatore.library[row][col]==null) {
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
						if(libreriaGiocatore.library[row][col]==null) {
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
						if(libreriaGiocatore.library[row][col]==null) {
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
						if(libreriaGiocatore.library[row][col]==null) {
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
	public static int assignScore(int nPlayers, int contatore) {
		
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
