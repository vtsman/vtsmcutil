package vtsman.vtsmcUtil;

public class ColorUtils {
	/**
	 * Combines RBG values into a single number used in many minecraft color
	 * functions
	 * 
	 * @param r
	 * @param g
	 * @param b
	 * @return int of combined RBG
	 */
	public static int constColor(int r, int g, int b) {
		return r * 0x10000 + g * 0x100 + b;
	}

	/**
	 * Reverse of constColor, int[0] is red, int[1] is green, and int[2] is blue
	 * 
	 * @param color
	 * @return Array of ints
	 */
	public static int[] splitColor(int color) {
		int[] out = new int[3];
		out[2] = (color - color % 0x10000) / 0x10000;
		out[0] = color % 0x100;
		out[1] = (color - out[0]) / 0x100 % 0x100;

		return out;
	}

	/**
	 * Gets lumination of color
	 * 
	 * @param color
	 * @return int of lumination
	 */
	public static int getLum(int color) {
		int[] split = splitColor(color);
		return MathUtils.intAvg(split);
	}

	/**
	 * Inverts color
	 * 
	 * @param color
	 * @return inverted color
	 */
	public static int invertColor(int color) {
		int[] colors = splitColor(color);
		for (int i = 0; i < 3; i++) {
			colors[i] = 255 - colors[i];
		}
		return constColor(colors[2], colors[1], colors[0]);
	}

	/**
	 * Invert color lumination
	 * 
	 * @param color
	 * @return color with inverted lumination
	 */
	public static int revLum(int color) {
		int lum = getLum(color);
		int[] split = splitColor(color);
		float[] deconst = new float[3];
		for (int i = 0; i < 3; i++) {
			deconst[i] = (float) split[i] / lum;
		}
		int[] out = new int[3];
		for (int i = 0; i < 3; i++) {
			out[i] = (int) (deconst[i] * (255 - lum));
		}
		return constColor(out[2], out[1], out[0]);
	}
}
