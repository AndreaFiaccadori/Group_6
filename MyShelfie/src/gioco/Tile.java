package gioco;

import java.util.Random;

public class Tile {
	private static final String types[]  = {"cat",   "book",  "game",   "frame", "trophy", "plant"};
	private static final String colors[] = {"green", "white", "yellow", "blue",  "cyan",   "pink"};
	private static final String colorCodes[] = {"\033[0;32m", "\033[0;37m", "\033[0;33m", "\033[0;34m",  "\033[0;36m",   "\033[0;95m"};
	private static final String reset = "\033[0m";
	private final int type;
	public Tile() {
		Random r = new Random();
		type = r.nextInt(6);
	}
	
	public int getTypeId() {
		return type;
	}
	
	public String getType() {
		return types[type];
	}
	public String getColor() {
		return colors[type];
	}

	public String getFirstTypeChar() {
		return  colorCodes[type] + types[type].charAt(0) + reset;
	}
}
