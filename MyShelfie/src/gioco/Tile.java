package gioco;

import java.util.Random;

/**
 * The Tile class represents a tile in a game. Each tile has a type, which
 * corresponds to a color.
 * 
 * @author Davide Falconi
 *
 */
public class Tile {
	private static final int TYPES_COUNT = 6;
	private static final String TYPES[] = { "cat", "book", "game", "frame", "trophy", "plant" };
	private static final String COLORS[] = { "green", "white", "yellow", "blue", "cyan", "pink" };
	private static final String COLOR_CODES[] = { "\033[0;32m", "\033[0;37m", "\033[0;33m", "\033[0;94m", "\033[0;96m", "\033[0;95m" };
	private final int type;

	/**
	 * Constructs a new Tile object with a random type.
	 */
	public Tile() {
		Random random = new Random();
		type = random.nextInt(TYPES_COUNT);
	}

	/**
	 * @return Numeric type of the tile (0-5)
	 */
	public int getTypeId() {
		return type;
	}

	/**
	 * @return Type of the tile
	 */
	public String getType() {
		return TYPES[type];
	}

	/**
	 * @return Color of the tile
	 */
	public String getColor() {
		return COLORS[type];
	}

	/**
	 * @return The first character of the type of tile, colored according to its type
	 */
	public String getFirstTypeChar() {
		return COLOR_CODES[type] + TYPES[type].charAt(0) + "\033[0m";
	}
}
