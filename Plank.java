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
	 *    3: cella da riempire solo con 3 o 4 giocatori
	 *    4: cella da riempire solo con 4 giocatori
	 *    
	*/
	
	public Plank(int nPlayers) {
		players = nPlayers;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(TILES_POSITIONS[i][j] <= players) {
					plank[i][j] = new Tile();
				}
			}
		}
	}
	
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
	
	public boolean isChoiceValid(int row1, int col1, int row2, int col2, int row3, int col3) {
	    // Check that all three tiles are in the same row or column
	    if (row1 != row2 || row1 != row3 || col1 != col2 || col1 != col3) {
	        return false;
	    }

	    // Check that all three tiles have at least one neighboring tile that is empty
	    boolean hasEmptyNeighbor = false;
	    if (row1 > 0) {
	        hasEmptyNeighbor |= (plank[row1-1][col1] == null);
	    }
	    if (row1 < rows-1) {
	        hasEmptyNeighbor |= (plank[row1+1][col1] == null);
	    }
	    if (col1 > 0) {
	        hasEmptyNeighbor |= (plank[row1][col1-1] == null);
	    }
	    if (col1 < cols-1) {
	        hasEmptyNeighbor |= (plank[row1][col1+1] == null);
	    }
	    if (!hasEmptyNeighbor) {
	        return false;
	    }

	    if (row2 > 0) {
	        hasEmptyNeighbor |= (plank[row2-1][col2] == null);
	    }
	    if (row2 < rows-1) {
	        hasEmptyNeighbor |= (plank[row2+1][col2] == null);
	    }
	    if (col2 > 0) {
	        hasEmptyNeighbor |= (plank[row2][col2-1] == null);
	    }
	    if (col2 < cols-1) {
	        hasEmptyNeighbor |= (plank[row2][col2+1] == null);
	    }
	    if (!hasEmptyNeighbor) {
	        return false;
	    }

	    if (row3 > 0) {
	        hasEmptyNeighbor |= (plank[row3-1][col3] == null);
	    }
	    if (row3 < rows-1) {
	        hasEmptyNeighbor |= (plank[row3+1][col3] == null);
	    }
	    if (col3 > 0) {
	        hasEmptyNeighbor |= (plank[row3][col3-1] == null);
	    }
	    if (col3 < cols-1) {
	        hasEmptyNeighbor |= (plank[row3][col3+1] == null);
	    }
	    if (!hasEmptyNeighbor) {
	        return false;
	    }

	    return true;
	}

}
