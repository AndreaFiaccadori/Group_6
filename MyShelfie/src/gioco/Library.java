package gioco;
import java.util.Scanner;

public class Library {
	//remember to change all of the variables into private after the checks
	//remember to change library into Tile after the check
	protected Tile[][] library;
	protected final int rows=6;
	protected final int columns=5;
	Scanner in=new Scanner(System.in);
	public Library() {
		this.library=new Tile[this.rows][this.columns];
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
		int column,nTiles;
		boolean tooMany,full;//I use this two variables to don't call the methods two times
		//checking the input of the tiles the player wants to put in his library 
		do {
			tooMany=false;
			System.out.println("How many tiles do you want to put in your library?(from 1 to 3)");
			nTiles=in.nextInt();
			if(nTiles>3||nTiles<1) {
				System.out.println("You have chosen an invalid value!!");
			}
			if(tooManyTiles(nTiles)==true) {
				System.out.println("You can't put that many tiles anywhere in your library");
				tooMany=true;
			}
				
		}while(nTiles>3||nTiles<1||tooMany);
		//checking if the player can put the tiles in the column he chose 
		do {
			full=false;
			System.out.println("In which column do you want to put your tiles?(from 1 to 6)");
			column=in.nextInt();
			if(column<1||column>5) {
				System.out.println("You have chosen a not existing column!!");
			}
			else if(isColumnFull(nTiles,--column)==true) {
				System.out.println("The column you have chosen is already full or cannot contain that many tiles");
				full=true;
			}
		}while(column<1||column>5||full==true);
	}
	/**
	 *This method count if there are as empty spaces as the tiles the player choose to put 
	 */
	public boolean isColumnFull(int tiles,int column) {
		for(int cont=0;cont<tiles;cont++) {
			if(this.library[cont][column]!=null) {
				return true;
			}
		}
		return false;
	}
	/**
	 * This method checks if the player can put n tiles in any of the library columns
	 */
	public boolean tooManyTiles(int tiles) {
		int nullCounter=0;
		for(int row=0;row<this.rows;row++) {
			for(int col=0;col<this.columns;col++) {
				if(this.library[row][col]==null) {
					nullCounter++;
				}
			}
			if(nullCounter>tiles) {
				return false;
			}
				
			nullCounter=0;
		}
		return true;
	}
	/**
	 *The column that the player has chosen is being filled bottom up
	 */
	public void libraryFilling(int tiles,int column) {
		int tilesPut=0;//it counts how many tiles are already been put
		for(int cont=this.rows-1;tilesPut<tiles;cont--) {
			if(this.library[cont][column]==null) {
				//this.Object_tile.[...]==[...]
				tilesPut++;
			}
		}
	}
	/**
	 * This method checks if the library is full after the player put the last tiles
	 */
	public boolean isFull() {
		for(int row=0;row<this.rows;row++) {
			for(int col=0;col<this.columns;col++) {
				if(this.library[row][col]==null) {
					return false;
				}
			}		
		}
		return true;
	}
	public int score() {
		int score=0;
		int sum=0;//it's used to understand from how many points I have to increase the variable score
		String tile_type;//used to memorize the type of the tile that I find at the start of the cycle 
		Tile libraryCopy[][]=new Tile[this.rows][this.columns];
		copyLibrary(libraryCopy);
		for(int row=0;row<this.rows;row++) { 
			for(int col=0;col<this.columns;col++) {
				if(this.library[row][col]!=null) {
					tile_type=this.library[row][col].getType();
					this.method(row,col,tile_type);
					if(sum==3) {
						score+=2;
					}
					if(sum==3) {
						score+=3;
					}
					if(sum==3) {
						score+=5;
					}
					if(sum>=6) {
						score+=8;
					}
					this.library[row][col]=null;
					row=0;
					col=0;
				}
			}
		}
		return score;
	}
	public void copyLibrary(Tile library[][]) {
		for(int row=0;row<this.rows;row++) {
			for(int col=0;col<this.columns;col++) {
				library[row][col]=this.library[row][col];
			}
		}

	}
	//scrivo dopo
	public int method(int row,int col,String type) {
		int sum=1;
		int adjacentTiles[]=new int[60];
		int checkedTiles[]=new int[60];
		int nAdjacent=1,nChecked=0;
		adjacentTiles[0]=row;
		adjacentTiles[1]=col;
		while(nAdjacent!=nChecked) {
			checkedTiles[nChecked*2]=row;
			checkedTiles[nChecked*2+1]=col;
			nChecked++;
			if(this.library[row-1][col].getType()==type) { 
				if(contains(adjacentTiles,row-1,col)==false) {
					sum++;
					adjacentTiles[nAdjacent*2]=row;
					adjacentTiles[nAdjacent*2+1]=col;
				}
			}
			if(this.library[row+1][col].getType()==type) {
				if(contains(adjacentTiles,row+1,col)==false) {
					sum++;
					adjacentTiles[nAdjacent*2]=row;
					adjacentTiles[nAdjacent*2+1]=col;
				}
			}
			if(this.library[row][col-1].getType()==type) 
				if(contains(adjacentTiles,row,col-1)==false) {
					sum++;
					adjacentTiles[nAdjacent*2]=row;
					adjacentTiles[nAdjacent*2+1]=col;
				}

			if(this.library[row][col+1].getType()==type) {
				if(contains(adjacentTiles,row,col+1)==false) {
					sum++;
					adjacentTiles[nAdjacent*2]=row;
					adjacentTiles[nAdjacent*2+1]=col;
				}
			}
			int val=whichTile(adjacentTiles,checkedTiles);
			row=val/10;
			col=val-row;
		}
		for(int cont=0;cont<nAdjacent;cont+=2) {
			this.library[cont][cont+1]=null;
		}
		return sum;
	}
	public boolean contains(int array[],int n1,int n2) {
		for(int cont=0;cont<60;cont+=2) {
			if(array[cont]==n1&&array[cont+1]==n2) {
				return true;
			}
		}
		return false;
	}
	public int whichTile(int a1[],int a2[]) {
		for(int cont=0;cont<60;cont+=2) {
			if(a1[cont]!=a2[cont]||a1[cont+1]!=a2[cont+1]) {
				return cont*10+(cont+1);
			}
		}
		return 0;
	}
}
