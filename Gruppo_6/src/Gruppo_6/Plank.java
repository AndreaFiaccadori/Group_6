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
}
