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
	 *    +: cella da riempire sempre
	 *    3: cella da riempire solo con 2 o 3 giocatori
	 *    4: cella da riempire con 2, 3 o 4 giocatori
	 *    
	*/
	
	public Plank(int nPlayers) {
		players = nPlayers;
		fillPlank();
	}
	
	public void fillPlank() {
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(TILES_POSITIONS[i][j] <= players) {
					plank[i][j] = new Tile();
				}
			}
		}
	}
	
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
	
	public Tile takeTile(int col, int row) {
		if(row<0 || row>rows || col<0 || col > cols) {
			throw new IllegalArgumentException("The coordinates are invalid");
		} else if(plank[col][row]!=null) {
			throw new IllegalArgumentException("There is no tile at given coordinates");
		} else {
			Tile t = plank[row][col];
			plank[row][col] = null;
			return t;
		}
		
	}

}
