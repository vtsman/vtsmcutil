package vtsman.vtsmcUtil;

import java.util.Comparator;

import net.minecraft.item.ItemStack;

public class ItemComp implements Comparator<ItemStack> {

	@Override
	public int compare(ItemStack i1, ItemStack i2) {
		int s1 = i1.stackSize;
		int s2 = i2.stackSize;
		if (s1 > s2)
			return 1;
		if (s1 < s2)
			return -1;
		return 0;
	}

}
