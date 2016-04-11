package com.multi7200.tam;

import java.awt.Color;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

import com.multi7200.tam.blocks.BlockDelimitation;
import com.multi7200.tam.entity.EntityBullet;
import com.multi7200.tam.entity.EntityDisk;
import com.multi7200.tam.entity.EntityNitron;
import com.multi7200.tam.event.LivingEventHandler;
import com.multi7200.tam.gui.TribesMainMenu;
import com.multi7200.tam.weapons.TABasicWeapon;
import com.multi7200.tam.weapons.TABxt1Rifle;
import com.multi7200.tam.weapons.TAExplosiveNitron;
import com.multi7200.tam.weapons.TALightSpinfusor;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "TAMod", version = "0.1")
public class TribesAscendMod {
	
	public static final String modID = "tam:";
	
	public static boolean zoom;
	public static Item lightSpinfusor, explosiveNitron, jetpack, bxt1Rifle;
	public static Block MapDelimitation;
	public static ArmorMaterial armorJetpack = EnumHelper.addArmorMaterial("armorJetpack", 25, new int[] {4, 50, 5, 4}, 0);
	@Instance("TAMod")
	public static TribesAscendMod instance;
	
	@SidedProxy(clientSide = "com.multi7200.tam.ClientProxy", serverSide = "com.multi7200.tam.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		this.lightSpinfusor = new TALightSpinfusor("lighspin", 40, "Light Spinfusor").setCreativeTab(CreativeTabs.tabTools);
		this.MapDelimitation = new BlockDelimitation(Material.rock).setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(this.modID + "mapdel");
		this.explosiveNitron = new TAExplosiveNitron().setUnlocalizedName("explosive_nitron").setFull3D().setTextureName(this.modID + "explosivenitron").setCreativeTab(CreativeTabs.tabTools);
		this.bxt1Rifle = new TABxt1Rifle("bxtrifle", 37, "BXT1 Rifle").setCreativeTab(CreativeTabs.tabTools);
		
		((TABasicWeapon) lightSpinfusor).setWeaponTexture("lightspin");
		((TABasicWeapon) bxt1Rifle).setWeaponTexture("sniper");
		
		GameRegistry.registerItem(lightSpinfusor, "tam_lightspin");
		GameRegistry.registerItem(bxt1Rifle, "tam_bxtrifle");
		GameRegistry.registerItem(explosiveNitron, "tam_explosivenitron");
		GameRegistry.registerBlock(MapDelimitation, "block_mapdel");
		
		LanguageRegistry.addName(MapDelimitation, "Map Delimitation block DEV");
		LanguageRegistry.addName(explosiveNitron, "Explosive Nitorn");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		EntityRegistry.registerGlobalEntityID(EntityNitron.class, "nitron", EntityRegistry.findGlobalUniqueEntityId(), new Color(0, 255, 0).getRGB(), new Color(255, 0, 0).getRGB());
		EntityRegistry.registerGlobalEntityID(EntityDisk.class, "disk", EntityRegistry.findGlobalUniqueEntityId(), new Color(0, 255, 0).getRGB(), new Color(255, 0, 0).getRGB());
		EntityRegistry.registerGlobalEntityID(EntityBullet.class, "bullet", EntityRegistry.findGlobalUniqueEntityId(), new Color(0, 255, 0).getRGB(), new Color(255, 0, 0).getRGB());
		
		EntityRegistry.registerModEntity(EntityDisk.class, "disk", 420, this.instance, 120, 3, true);
		EntityRegistry.registerModEntity(EntityNitron.class, "nitron", 500, this.instance, 40, 1, true);
		EntityRegistry.registerModEntity(EntityBullet.class, "bullet", 503, this.instance, 130, 1, true);
		
		proxy.registerRender();
		
		MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
		
		FMLCommonHandler.instance().bus().register(this);
	}
	
	// @EventHandler
	// public void postInit(FMLPostInitializationEvent event) {
		//  MinecraftForge.EVENT_BUS.register(new GuiTribesAscendGameOverlay(FMLClientHandler.instance().getClient()));
	// }
	
	public static void print(String s) {
		System.out.println("[TAMOD] : " + s);
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onTickClient(TickEvent.ClientTickEvent event)
	{
		if(event.phase == Phase.START )
		{
				Minecraft mc = Minecraft.getMinecraft();
				GuiScreen currentScreen = mc.currentScreen;
				TribesMainMenu customMenu = new TribesMainMenu();

				if(currentScreen instanceof GuiMainMenu && !currentScreen.equals(customMenu))
				{
					mc.displayGuiScreen(customMenu);
				}
		}
	}	
}

