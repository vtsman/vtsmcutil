package vtsman.vtsmcUtil;

public class MathUtils {
	/**
	 * Averages integers
	 * 
	 * @param in
	 *            -- array of ints
	 * @return int average
	 */
	public static int intAvg(int[] in) {
		int out = 0;
		for (int i : in) {
			out += i;
		}
		return out / in.length;
	}

	/**
	 * Divides and rounds up
	 * 
	 * @param in
	 * @param div
	 * @return
	 */
	public static int divUp(int in, int div) {
		return (in + in % div) / div;
	}

	/**
	 * Averages array of floats
	 * 
	 * @param in
	 *            -- array of floats
	 * @return float average
	 */
	public static float floatAvg(float[] in) {
		float out = 0;
		for (float i : in) {
			out += i;
		}
		return out / in.length;
	}

	/**
	 * Calculates diagonal
	 * 
	 * @param in1
	 *            -- length of vert line
	 * @param in2
	 *            -- length of horz line
	 * @return length of diagonal
	 */
	public static float py(float in1, float in2) {
		return (float) Math.pow(in1 * in1 + in2 * in2, 0.f);
	}
}
