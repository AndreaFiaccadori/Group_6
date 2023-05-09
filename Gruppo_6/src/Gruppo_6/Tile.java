import java.util.Random;

public class Tile {
	private static final String types[]  = {"Cat",   "Book",  "Game",   "Frame", "Trophy", "Plant"};
	private static final String colors[] = {"green", "white", "yellow", "blue",  "cyan",   "pink"};
	public int type;
	public Tile() {
		Random r = new Random();
		type = r.nextInt(6);
	}
	
	public String getType() {
		return types[type];
	}
	public String getColor() {
		return colors[type];
	}
}
