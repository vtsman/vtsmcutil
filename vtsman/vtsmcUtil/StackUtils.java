package vtsman.vtsmcUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class StackUtils {
	/**
	 * Puts array of ItemStacks to be of amount 'size'
	 * 
	 * @param input
	 *            array of ItemStacks
	 * @param size
	 * @return Array of ItemStacks with size
	 */
	public static ItemStack[] sizer(ItemStack[] input, int size) {
		ItemStack[] stack = input;
		if (input != null) {
			for (int i = 0; i < stack.length; i++) {
				if (stack[i] != null) {
					stack[i].stackSize = size;
				}
			}
		}
		return stack;
	}

	public static ItemStack[] sortGreatest(ItemStack[] in) {
		ItemStack[] s1 = in.clone();
		Arrays.sort(s1, new ItemComp());
		ItemStack[] s2 = new ItemStack[s1.length];
		for (int i = 0; i < s1.length; i++) {
			s2[s1.length - i - 1] = s1[i];
		}
		return s2;
	}

	public static ItemStack[] combine(ItemStack[] st1) {
		ItemStack[] st = getNonNull(st1);
		if (st.length == 0)
			return new ItemStack[] { new ItemStack(1, 1, 1) };
		Map<Integer, Map<Integer, Integer>> m = new HashMap<Integer, Map<Integer, Integer>>();
		List<Integer> ids = new ArrayList<Integer>();
		List<Integer> metas = new ArrayList<Integer>();
		for (ItemStack s : st) {
			if (!m.containsKey(s.itemID)) {
				m.put(s.itemID, new HashMap<Integer, Integer>());
			}
			if (!m.get(s.itemID).containsKey(s.getItemDamage())) {
				m.get(s.itemID).put(s.getItemDamage(), s.stackSize);
				ids.add(s.itemID);
				metas.add(s.getItemDamage());
			} else {
				Map<Integer, Integer> m2 = m.get(s.itemID);
				int i = s.getItemDamage();
				m2.put(i, m2.get(i) + s.stackSize);
			}
		}
		ItemStack[] out = new ItemStack[ids.size()];
		for (int i = 0; i < ids.size(); i++) {
			out[i] = new ItemStack(ids.get(i), m.get(ids.get(i)).get(
					metas.get(i)), metas.get(i));
		}
		return out;
	}

	/**
	 * Returns if stacks are equal
	 * 
	 * @param s1
	 *            -- stack 1
	 * @param s2
	 *            -- stack 2
	 * @return ItemStacks' equivalence
	 */
	public static boolean stackEquals(ItemStack s1, ItemStack s2) {
		boolean ids = s1.itemID == s2.itemID;
		boolean amount = s1.stackSize == s2.stackSize;
		boolean meta = s1.getItemDamage() == s2.getItemDamage();
		boolean nbt = MiscUtils.nbtMatch(s1.stackTagCompound,
				s2.stackTagCompound);
		return ids && amount && meta && nbt;
	}

	public static boolean canStack(ItemStack s1, ItemStack s2) {
		if (s1 == null && s2 == null) {
			return true;
		}

		if (s1 == null || s2 == null) {
			return false;
		}
		return s1.itemID == s2.itemID
				&& s1.getItemDamage() == s2.getItemDamage();

	}

	public static ItemStack[] getNonNull(ItemStack[] s) {
		int l = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] != null) {
				l++;
			}
		}
		ItemStack[] out = new ItemStack[l];
		int arrnum = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] != null) {
				out[arrnum] = s[i].copy();
				arrnum++;
			}
		}
		return out;
	}

	public static boolean hasBlock(ItemStack s) {
		String name = Item.itemsList[s.itemID].getUnlocalizedName();
		if (name.substring(0, 4).matches("item")) {
			return false;
		}
		return true;
	}
}
