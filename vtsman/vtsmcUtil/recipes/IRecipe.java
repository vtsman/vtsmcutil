package vtsman.vtsmcUtil.recipes;

import net.minecraft.item.ItemStack;

public interface IRecipe {
	public boolean isValid(ItemStack[] inv);

	public ItemStack getResult(ItemStack[] inv);
}
