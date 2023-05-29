package gioco;

public class Player {

	private String nickname;
	public Library library = new Library();
	private int order;
	public PersonalObjective personalObjective;
	static private ScoreTile scoreTile1;
	static private ScoreTile scoreTile2;
	public Player(int order) {
		this.order = order;
	}

	public String getNickname() {
		return this.nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getOrder() {
		return this.order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
}
