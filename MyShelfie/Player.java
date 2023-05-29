package Myshelfie;

public class Player {

	private final String nickname;
	private final int order;
	private Tile[][] library;
	static private PersonalObjective personalObjective;
	static private ScoreTile scoreTile1;
	static private ScoreTile scoreTile2;
	public Player(String nickname, int order) {
		this.nickname = nickname;
		this.order = order;
	}
	
}
