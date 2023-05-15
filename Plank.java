package Gruppo_6;

public class Plank {
	private static final int rows = 9;
	private static final int cols = 9;
	private int players;
	
	private Tile plank[][] = new Tile[rows][cols];

	private static final int[][] TILES_POSITIONS = {
			{9, 9, 9, 3, 4, 9, 9, 9, 9},
			{9, 9, 9, 2, 2, 4, 9, 9, 9},
			{9, 9, 3, 2, 2, 2, 3, 9, 9},
			{9, 4, 2, 2, 2, 2, 2, 2, 3},
			{4, 2, 2, 2, 2, 2, 2, 2, 4},
			{3, 2, 2, 2, 2, 2, 2, 4, 9},
			{9, 9, 3, 2, 2, 2, 3, 9, 9},
			{9, 9, 9, 4, 2, 2, 9, 9, 9},
			{9, 9, 9, 9, 4, 3, 9, 9, 9}
	};
	/*
	 *
	 *        0  1  2  3  4  5  6  7  8
	 *        
	 *    0            3  4
	 *    1            +  +  4
	 *    2         3  +  +  +  3
	 *    3      4  +  +  +  +  +  +  3
	 *    4   4  +  +  +  +  +  +  +  4
	 *    5   3  +  +  +  +  +  +  4
	 *    6         3  +  +  +  3
	 *    7            4  +  +
	 *    8               4  3
	 *
	 *
	 *    +: always fill
	 *    3: only fill with 3 or 4 players
	 *    4: only fill with 4 players
	 *    
	*/
	
	public Plank(int nPlayers) {
		players = nPlayers;
		fillPlank(); // Fills the plank, according to the number of players
	}
	
	// Randomly fills empty cells on the plank, according to the number of players
	public void fillPlank() {
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(TILES_POSITIONS[i][j] <= players && plank[i][j] == null) {
					plank[i][j] = new Tile();
				}
			}
		}
	}
	
	// Returns a string with the plank
	// Print the returned string to print the plank
	public String toString() {
		String s = "  ";
		for(int i=0; i<cols; i++) {
			s += (i + " ");
		}
		s += "\n";
		for(int i=0; i<rows; i++) {
			s += (i + " ");
			for(int j=0; j<cols; j++) {
				if(plank[i][j] != null) {
					s += (plank[i][j].getTypeId() + " ");
				} else {
					s += ("  ");
				}
			}
			s += ("\n");
		}
		return s;
	}
	
	/*
	public void printPlank() {
		System.out.print("  ");
		for(int i=0; i<cols; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i=0; i<rows; i++) {
			System.out.print(i + " ");
			for(int j=0; j<cols; j++) {
				if(plank[i][j] != null) {
					System.out.print(plank[i][j].getTypeId() + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	*/
	
	// Checks if the cell given is a valid choice
	public boolean isChoiceValid(int row1, int col1) {
		if(row1<0 || row1>=rows || col1<0 || col1>=cols) {
			return false;
		}
		if(plank[row1][col1] == null) {
			return false;
		}
		return false;
	}
	
	// Checks if the 2 cells given are a valid choice
	public boolean isChoiceValid(int row1, int col1, int row2, int col2) {
		if(row1<0 || row1>=rows || row2<0 || row2>=rows || col1<0 || col1>=cols || col2<0 || col2>=cols) {
			return false;
		}
		if(plank[row1][col1] == null || plank[row2][col2] == null) {
			return false;
		}
		if (row1 == row2 && (Math.abs(col1 - col2) == 1)) {
			return true;
		}
		if (col1 == col2 && (Math.abs(row1 - row2) == 1)) {
			return true;
		}
		return false;
	}
	
	// Checks if the 3 cells given are a valid choice
	public boolean isChoiceValid(int row1, int col1, int row2, int col2, int row3, int col3) {
		if(row1<0 || row1>=rows || row2<0 || row2>=rows || row3<0 || row3>=rows || col1<0 || col1>=cols || col2<0 || col2>=cols || col3<0 || col3>=cols) {
			return false;
		}
		if(plank[row1][col1] == null || plank[row2][col2] == null || plank[row3][col3] == null) {
			return false;
		}
		if (row1 == row2 && row2 == row3 && (Math.abs(col1 - col2) == 1 && Math.abs(col2 - col3) == 1)) {
			return true;
		}
		if (col1 == col2 && col2 == col3 && (Math.abs(row1 - row2) == 1 && Math.abs(row2 - row3) == 1)) {
			return true;
		}
		return false;
	}
	
	// Pick a tile, returns it and sets that tile's position to null on the plank
	public Tile takeTile(int row, int col) {
		if(isChoiceValid(row, col)) {
			throw new IllegalArgumentException("The chosen tile is not valid");
		} else {
			Tile t = plank[row][col];
			plank[row][col] = null;
			return t;
		}
	}
	
	// Returns true if the plank needs to be refilled, returns false otherwise
	public boolean isToFill() {
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(plank[i][j] == null) {
					continue;
				} else {
					if(j==8 && plank[i+1][j]!=null) {System.out.println("COL8"); return false;}
					if(i==8 && plank[i][j+1]!=null) {System.out.println("ROW8"); return false;}
					if(plank[i][j+1]!=null || plank[i+1][j]!=null) {
						System.out.println("Trovata: " + i + " " + j);
						return false;
					}
				}
			}
		}
		return true;
	}
}
