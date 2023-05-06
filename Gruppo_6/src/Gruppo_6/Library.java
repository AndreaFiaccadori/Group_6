package myshelf;
import java.util.Scanner;

public class Library {
	private Object_tile[][] library;
	private final int rows=6;
	private final int columns=5;
	Scanner in=new Scanner(System.in);
	public Library(Object_tile library) {
		this.library=new Object_tile[this.rows][this.columns];
	}
	//i can't change the value of a constant variable so i don't need setter methods
	public int getRows() {
		return this.rows;
	}
	public int getColumns() {
		return this.columns;
	}
	/**
	 * The main method to check if the library is being filled right; it checks:
	 * 1)the correct input of the number of tiles
	 * 2)the right column where to put the tiles 
	 * 3)if the library is all full
	 */
	public void libraryFillingChecks() {
		int column,n_tiles;
		boolean tooMany,full;//I use this two variables to don't call the methods two times
		//checking the input of the tiles the player wants to put in his library 
		do {
			tooMany=false;
			System.out.println("How many tiles do you want to put in your library?(from 1 to 3)");
			n_tiles=in.nextInt();
			if(n_tiles>3||n_tiles<1) 
				System.out.println("You have chosen an invalid value!!");
			if(tooManyTiles(n_tiles)==true) {
				System.out.println("You can't put that many tiles anywhere in your library");
				tooMany=true;
			}
				
		}while(n_tiles>3||n_tiles<1||tooMany);
		//checking if the player can put the tiles in the column he chose 
		do {
			full=false;
			System.out.println("In which column do you want to put your tiles?(from 1 to 6)");
			column=in.nextInt();
			if(column<1||column>5) 
				System.out.println("You have chosen a not existing column!!");
			else if(isColumnFull(n_tiles,--column)==true) {
				System.out.println("The column you have chosen is already full or cannot contain that many tiles");
				full=true;
			}
		}while(column<1||column>5||full==true);
	}
	/**
	 *This method count if there are as empty spaces as the tiles the player choose to put 
	 */
	public boolean isColumnFull(int tiles,int column) {
		for(int cont=0;cont<tiles;cont++)
			if(this.library[cont][column]!=null)
				return true;
		return false;
	}
	/**
	 * This method checks if the player can put n tiles in any of the library columns
	 */
	public boolean tooManyTiles(int tiles) {
		int null_counter=0;
		for(int row=0;row<this.rows;row++) {
			for(int col=0;col<this.columns;col++) {
				if(this.library[row][col]==null)
					null_counter++;
			}
			if(null_counter>tiles)
				return false;
			null_counter=0;
		}
		return true;
	}
	/**
	 *The column that the player has chosen is being filled bottom up
	 */
	public void libraryFilling(int tiles,int column) {
		int tiles_put=0;//it counts how many tiles are already been put
		for(int cont=this.rows-1;tiles_put<tiles;cont--)
			if(this.library[cont][column]==null) {
				//this.Object_tile.[...]==[...]
				tiles_put++;
			}
	}
	/**
	 * This method checks if the library is full after the player put the last tiles
	 */
	public boolean isFull() {
		for(int row=0;row<this.rows;row++) {
			for(int col=0;col<this.columns;col++)
				if(this.library[row][col]==null)
					return false;
		}
		return true;
	}
	/**
	 *Scorro da in alto a sinistra verso destra e poi in basso
	 *appena incontro una tessera inizia il controllo da tutti e quattro i lati(un metodo ogni lato)
	 *faccio la somma dei contatori in una variabile
	 *elimino la tessera nella posizione iniziale
	 *controllo (probabilmente con uno switch) il punteggio che devo aggiungere e aggiorno punteggio
	 *riparto a controllare da in alto a destra
	 *il ciclo finisce quando la libreria sarà completamente svuotata(le righe diventano maggiori di 6)
	 */
	public int score() {
		int score=0;
		int sum=0;//it's used to understand from how many points I have to increase the variable score
		String tile_type;//used to memorize the type of the tile that I find at the start of the cycle 
		Object_tile library_copy[][]=new Object_tile[this.rows][this.columns];
		copyLibrary(library_copy);
		for(int row=0;row<this.rows;row++) { 
			for(int col=0;col<this.columns;col++) {
				if(this.library[row][col]!=null) {
					this.method(row,col/*,tile_type*/);
					if(sum==3)
						score+=2;
					if(sum==3)
						score+=3;
					if(sum==3)
						score+=5;
					if(sum>=6)
						score+=8;
					this.library[row][col]=null;
					row=0;
					col=0;
				}
			}
		}
		return score;
	}
	public void copyLibrary(Object_tile library[][]) {
		for(int row=0;row<this.rows;row++) 
			for(int col=0;col<this.columns;col++) 
				library[row][col]=this.library[row][col];
		
	}
	//scrivo dopo
	public int method(int row,int col/*,String type*/) {
		int sum=1;
		int adjacent_tiles[]=new int[60];
		int checked_tiles[]=new int[60];
		int n_adjacent=1,n_checked=0;
		adjacent_tiles[0]=row;
		adjacent_tiles[1]=col;
		while(n_adjacent!=n_checked) {
			checked_tiles[n_checked*2]=row;
			checked_tiles[n_checked*2+1]=col;
			n_checked++;
			if(/*this.library[row-1][col].getType()*/1==1) 
				if(contains(adjacent_tiles,row-1,col)==false) {
					sum++;
					adjacent_tiles[n_adjacent*2]=row;
					adjacent_tiles[n_adjacent*2+1]=col;
				}
			if(/*this.library[row+1][col].getType()*/1==1) 
				if(contains(adjacent_tiles,row+1,col)==false) {
					sum++;
					adjacent_tiles[n_adjacent*2]=row;
					adjacent_tiles[n_adjacent*2+1]=col;
				}
							
			if(/*this.library[row][col-1].getType()*/1==1) 
				if(contains(adjacent_tiles,row,col-1)==false) {
					sum++;
					adjacent_tiles[n_adjacent*2]=row;
					adjacent_tiles[n_adjacent*2+1]=col;
				}
				
			if(/*this.library[row][col+1].getType()*/1==1) 
				if(contains(adjacent_tiles,row,col+1)==false) {
					sum++;
					adjacent_tiles[n_adjacent*2]=row;
					adjacent_tiles[n_adjacent*2+1]=col;
				}
			int val=whichTile(adjacent_tiles,checked_tiles);
			row=val/10;
			col=val-row;
		}
		for(int cont=0;cont<n_adjacent;cont+=2)
			this.library[cont][cont+1]=null;
		return sum;
	}
	public boolean contains(int array[],int n1,int n2) {
		for(int cont=0;cont<60;cont+=2)
			if(array[cont]==n1&&array[cont+1]==n2)
				return true;
		return false;
	}
	public int whichTile(int a1[],int a2[]) {
		for(int cont=0;cont<60;cont+=2) 
			if(a1[cont]!=a2[cont]||a1[cont+1]!=a2[cont+1])
				return cont*10+(cont+1);
		return 0;
	}
}
