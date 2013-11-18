package vtsman.vtsmcUtil.files;

import java.io.File;

import net.minecraft.world.World;

public class WorldFile {
	public static File getWorldFile(String file, World w) {
		String f = w.getSaveHandler().getWorldDirectoryName();
		File out = new File(f.concat("/").concat(file));
		return out;
	}
}
