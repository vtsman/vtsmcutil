package vtsman.vtsmcUtil;

import net.minecraft.nbt.NBTTagCompound;

public class MiscUtils {
	/**
	 * Returns an array of non null Objects
	 * 
	 * @param <K>
	 * 
	 * @param s
	 *            -- Input Objects
	 * @return Input array without null entries
	 */
	public static <K> K[] getNonNull(K[] s) {
		int l = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] != null) {
				l++;
			}
		}
		K[] out = (K[]) new Object[l];
		int arrnum = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] != null) {
				out[arrnum] = s[i];
				arrnum++;
			}
		}
		return out;
	}

	/**
	 * Compares 2 NBTTagCompounds
	 * 
	 * @param t1
	 *            -- Tag 1
	 * @param t2
	 *            -- Tag 2
	 * @return Tags are equal
	 */
	public static boolean nbtMatch(NBTTagCompound t1, NBTTagCompound t2) {
		if (t1 == null) {
			if (t2 == null)
				return true;
			return false;
		}
		if (t2 == null)
			return false;
		return t1.equals(t2);
	}
}
