package Gruppo_6;

import java.util.Random;

public class TesseraObiettivoComune {
	
	
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
	
	public void show_objective() { //mostra l'obiettivo 1 e 2
		int i=0;
		int a=0, b=0;
		a=draw_card();
		b=draw_card2(a);
		do {	
		if(a==b) {
			System.out.println("Obiettivo 2:\n");
		}
		
	    switch(a) {
	    case 0: System.out.println("Obiettivo 1:\n");
	    		System.out.println("Six groups each containing at least\r\n"
	    		+ "2 tiles of the same type (not necessarily\r\n"
	    		+ "in the depicted shape).\r\n"
	    		+ "The tiles of one group can be different\r\n"
	    		+ "from those of another group");
	    		System.out.println("\n\t*****\n"+"\t*   *\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"+"\t*   *\n"
				+"\t*****\n"+"\t*   *\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"+"\t*   *\n"+"\t*****\n");
	    
	    case 1: System.out.println("Obiettivo 1:\n");
	    		System.out.println("Four groups each containing at least\r\n"
	    		+ "4 tiles of the same type (not necessarily\r\n"
	    		+ "in the depicted shape).\r\n"
	    		+ "The tiles of one group can be different\r\n"
	    		+ "from those of another group.");		
	    		System.out.println("\n\t*****\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"
				+"\t*****\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"+"\t*****\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"
				+"\t*****\n"+"\t*   *\n"+"\t* = *\n"+"\t*   *\n"+"\t*****\n");
	    		
	    case 2: System.out.println("Obiettivo 1:\n");
	    		System.out.println("Four tiles of the same type in the four\r\n"
	    		+ "corners of the bookshelf.");
	    
	    case 3: System.out.println("Obiettivo 1:\n");
	    		System.out.println("Two groups each containing 4 tiles of\r\n"
	    		+ "the same type in a 2x2 square. The tiles\r\n"
	    		+ "of one square can be different from\r\n"
	    		+ "those of the other square.");
	    
	    case 4: System.out.println("Obiettivo 1:\n");
	    		System.out.println("Three columns each formed by 6 tiles Five tiles of the same type forming an X.\r\n"
	    		+ "of maximum three different types. One\r\n"
	    		+ "column can show the same or a different\r\n"
	    		+ "combination of another column.");
	    
	    case 5: System.out.println("Obiettivo 1:\n");
	    		System.out.println("Eight tiles of the same type. There’s no\r\n"
	    		+ "restriction about the position of these\r\n"
	    		+ "tiles.");
	    
	    case 6: System.out.println("Obiettivo 1:\n");
	    		System.out.println("Five tiles of the same type forming a\r\n"
	    		+ "diagonal. ");
	    
	    case 7: System.out.println("Obiettivo 1:\n");
	    		System.out.println("Four lines each formed by 5 tiles of\r\n"
	    		+ "maximum three different types. One\r\n"
	    		+ "line can show the same or a different\r\n"
	    		+ "combination of another line.");
	    
	    case 8: System.out.println("Obiettivo 1:\n");
	    		System.out.println("Two columns each formed by 6\r\n"
	    		+ "different types of tiles. ");
	    
	    case 9: System.out.println("Obiettivo 1:\n");
	    		System.out.println("Two lines each formed by 5 different\r\n"
	    		+ "types of tiles. One line can show the\r\n"
	    		+ "same or a different combination of the\r\n"
	    		+ "other line.");
	    
	    case 10: System.out.println("Obiettivo 1:\n");
	    		 System.out.println("Five tiles of the same type forming an X.");
	    
	    case 11: System.out.println("Obiettivo 1:\n");
	    		 System.out.println("Five columns of increasing or decreasing\r\n"
	    		+ "height. Starting from the first column on\r\n"
	    		+ "the left or on the right, each next column\r\n"
	    		+ "must be made of exactly one more tile.\r\n"
	    		+ "Tiles can be of any type. ");
	    }
	    i++;
	    a=b;
		}while(i != 2);
	}
	
	

}
