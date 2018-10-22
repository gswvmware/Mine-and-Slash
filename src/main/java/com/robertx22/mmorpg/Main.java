package com.robertx22.mmorpg;

import java.io.IOException;
import java.util.Arrays;

import com.robertx22.customitems.oldreplacesoon.MyItems;
import com.robertx22.customitems.oldreplacesoon.NewBlocks;
import com.robertx22.spells.projectile.acidbolt.EntityAcidBolt;
import com.robertx22.spells.projectile.firebolt.EntityFireBolt;
import com.robertx22.spells.projectile.frostbolt.EntityFrostBolt;
import com.robertx22.spells.projectile.thunderbolt.EntityThunderBolt;
import com.robertx22.uncommon.capability.EntityData;
import com.robertx22.uncommon.commands.GiveGear;
import com.robertx22.uncommon.commands.GiveSpell;
import com.robertx22.uncommon.oregen.OreGen;
import com.robertx22.uncommon.utilityclasses.RegisterUtils;

import net.minecraft.init.Items;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
@Mod(modid = Ref.MODID, version = Ref.VERSION, name = Ref.NAME, dependencies = "required-after:baubles;")
public class Main {

	@Instance(value = Ref.MODID)
	public static Main instance;

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {

	}

	@EventHandler
	public void start(FMLServerStartingEvent event) {
		event.registerServerCommand(new GiveGear());
		event.registerServerCommand(new GiveSpell());

	}

	@EventHandler
	public static void onWorldLoad(FMLServerStartedEvent event) {
		WorldServer world = DimensionManager.getWorld(0); // default world

		world.getGameRules().setOrCreateGameRule("mobGriefing", "false");
		world.getGameRules().setOrCreateGameRule("keepInventory", "true");
		world.getGameRules().setOrCreateGameRule("naturalRegeneration", "false");

		// TestManager.RunAllTests();

	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException {

		RegisterUtils.RegisterModEntity(Items.SNOWBALL, EntityFrostBolt.class);
		RegisterUtils.RegisterModEntity(Items.MAGMA_CREAM, EntityFireBolt.class);
		RegisterUtils.RegisterModEntity(Items.SLIME_BALL, EntityAcidBolt.class);
		RegisterUtils.RegisterModEntity(Items.GLOWSTONE_DUST, EntityThunderBolt.class);

		// GenJsonFiles.Gen();
		CapabilityManager.INSTANCE.register(EntityData.IEntityData.class, new EntityData.Storage(),
				EntityData.DefaultImpl.class);

		ModMetadata modMeta = event.getModMetadata();
		modMeta.name = Ref.NAME;
		modMeta.version = Ref.VERSION;
		modMeta.authorList = Arrays.asList("robertx22");
		modMeta.autogenerated = false;
		modMeta.description = Ref.DESC;

		NewBlocks.createCustomItems();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		GameRegistry.registerWorldGenerator(new OreGen(MyItems.magic_ore_block, 7, 10, 50, 7), 0);
		GameRegistry.registerWorldGenerator(new OreGen(MyItems.rare_ore_block, 6, 10, 40, 5), 0);
		GameRegistry.registerWorldGenerator(new OreGen(MyItems.epic_ore_block, 5, 10, 35, 3), 0);
		GameRegistry.registerWorldGenerator(new OreGen(MyItems.legendary_ore_block, 5, 10, 30, 2), 0);
		GameRegistry.registerWorldGenerator(new OreGen(MyItems.mythical_ore_block, 4, 10, 30, 1), 0);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

}
