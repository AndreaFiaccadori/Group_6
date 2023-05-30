package gioco;

import java.util.ArrayList;

public class ScoreTile {
	private final String value;
	// private final Player assigendPlayer;
	private static ArrayList<String> possibleValues1 = new ArrayList<String>();
	private static ArrayList<String> possibleValues2 = new ArrayList<String>();
	private static int scoreIndex1;
	private static int scoreIndex2;

	public ScoreTile(CommonObjective commonObjective/* , Player assignedPlayer */) {
		// this.assigendPlayer = assignedPlayer;
		if (commonObjective.id == 1) {
			this.value = possibleValues1.get(scoreIndex1);
			scoreIndex1--;

		} else {
			this.value = possibleValues2.get(scoreIndex2);
			scoreIndex2--;
		}
	}

	public String getValue() {
		return value;
	}

	/*
	 * public Player getAssigendPlayer() { return assigendPlayer; }
	 */

	public static void createScoreTiles(int nPlayers) {
		switch (nPlayers) {
		case 2:
			possibleValues1.add("4");
			possibleValues1.add("8");
			possibleValues2.add("4");
			possibleValues2.add("8");
			scoreIndex1 = 1;
			scoreIndex2 = 1;
			break;
		case 3:
			possibleValues1.add("4");
			possibleValues1.add("6");
			possibleValues1.add("8");
			possibleValues2.add("4");
			possibleValues2.add("6");
			possibleValues2.add("8");
			scoreIndex1 = 2;
			scoreIndex2 = 2;
			break;
		case 4:
			possibleValues1.add("2");
			possibleValues1.add("4");
			possibleValues1.add("6");
			possibleValues1.add("8");
			possibleValues2.add("2");
			possibleValues2.add("4");
			possibleValues2.add("6");
			possibleValues2.add("8");
			scoreIndex1 = 3;
			scoreIndex2 = 3;
		}
	}

}
