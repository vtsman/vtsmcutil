package vtsman.vtsmcUtil.files;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class NBTTagFile {
	public static void saveTag(String path, NBTTagCompound tag, World w)
			throws IOException {
		File f = WorldFile.getWorldFile(path, w);
		DataOutput d = new DataOutputStream(new FileOutputStream(f));
		tag.writeNamedTag(tag, d);
	}

	public static NBTTagCompound getTag(String path, World w)
			throws IOException {
		return CompressedStreamTools.read(WorldFile.getWorldFile(path, w));
	}
}
