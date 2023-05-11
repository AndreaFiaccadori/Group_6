package Gruppo_6;
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
	
}
