package vtsman.vtsmcUtil.base;

import vtsman.vtsmcUtil.SyncTE;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;

@Mod(modid = "vtsmcUtil", name = "vtsman Minecraft utility", version = "1.0.0")
@NetworkMod(channels = { "vtsmcutilte" }, clientSideRequired = true, serverSideRequired = false, clientPacketHandlerSpec = @SidedPacketHandler(channels = { "vtsmcutilte" }, packetHandler = SyncTE.class))
public class BaseMod {
	public static final String TILEPACKET = "vtsmcutilete";
	@Instance("vtsmcUtil")
	public static BaseMod instance = new BaseMod();

	@SidedProxy(clientSide = "vtsman.vtsmcUtil.base.ClientProxy", serverSide = "vtsman.vtsmcUtil.base.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		System.out.println("base");
		proxy.init();
	}

}
