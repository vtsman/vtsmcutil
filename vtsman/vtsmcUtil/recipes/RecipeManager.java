package vtsman.vtsmcUtil.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class RecipeManager {
	private final IRecipe def;
	private final List<IRecipe> recipes = new ArrayList<IRecipe>();

	public RecipeManager(IRecipe d) {
		this.def = d;
	}

	public IRecipe getResult(ItemStack[] inv) {
		for (IRecipe r : recipes) {
			if (r.isValid(inv))
				return r;
		}
		return this.def;
	}

	public void addRecipe(IRecipe r) {
		recipes.add(r);
	}
}
