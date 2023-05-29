package gioco;

public class Player {

	private String nickname;
	public Library library = new Library();
	public PersonalObjective personalObjective;
	public boolean firstCommonObjectiveCompleted = false;
	public boolean secondCommonObjectiveCompleted = false;
	public ScoreTile scoreTile1;
	public ScoreTile scoreTile2;
	public int commonObjectivesScore = 0;
	

	public String getNickname() {
		return this.nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
