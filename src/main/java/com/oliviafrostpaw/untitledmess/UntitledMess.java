package com.oliviafrostpaw.untitledmess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.*;

import com.oliviafrostpaw.untitledmess.config.Config;
import com.oliviafrostpaw.untitledmess.groups.TestItemGroup;
import com.oliviafrostpaw.untitledmess.lists.ArmorMaterialList;
import com.oliviafrostpaw.untitledmess.lists.BlockList;
import com.oliviafrostpaw.untitledmess.lists.FoodList;
import com.oliviafrostpaw.untitledmess.lists.ItemList;
import com.oliviafrostpaw.untitledmess.lists.ToolMaterialList;
import com.oliviafrostpaw.untitledmess.world.OreGeneration;

import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.config.ModConfig;

@Mod("untitledmess")
public class UntitledMess
{
	
	public static UntitledMess instance;
	public static final String modid = "untitledmess";
	public static final Logger logger = LogManager.getLogger(UntitledMess.class);
	
	public static final ItemGroup test = new TestItemGroup();
	
	public UntitledMess()//TODO
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "tutorialmod-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "tutorialmod-client.toml");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("tutorialmod-client.toml").toString());
		Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("tutorialmod-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
//	@SubscribeEvent
//	public static void onLootTablesLoaded(LootTableLoadEvent event) //throws IOException 
//	{
//		//ownFileWriter("I hit this");
//	    if (event.getName().equals(new ResourceLocation("minecraft","grass"))) 
//	    {
//	    	//ownFileWriter("I hit this Inside");
//	       event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(modid,"grass"))).build());
//	    }
//	}
	
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		
	}
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) throws IOException
		{
			//Foods
			FoodList.test_food = (new Food.Builder()).hunger(4).saturation(0.6F).build();
			
			event.getRegistry().registerAll
			(
				//Items
				ItemList.test_item = new Item(new Item.Properties().group(test)).setRegistryName(location("test_item")),
				ItemList.fiber = new Item(new Item.Properties().group(test)).setRegistryName(location("grass_fiber")),
				ItemList.lashing = new Item(new Item.Properties().group(test)).setRegistryName(location("lashing")),
				ItemList.limestone_ground = new Item(new Item.Properties().group(test)).setRegistryName(location("limestone_ground")),
				
				
				//Tools
				ItemList.wooden_needle = new Item(new Item.Properties().group(test)).setRegistryName(location("needle_wooden")),
				ItemList.metal_needle = new Item(new Item.Properties().group(test)).setRegistryName(location("needle_metal")),
				ItemList.copper_axe = new AxeItem(ToolMaterialList.copper, -1.0f, 0.8f, new Item.Properties().group(test)).setRegistryName(location("copper_axe")),
				ItemList.copper_hoe = new HoeItem(ToolMaterialList.copper, 2.8f, new Item.Properties().group(test)).setRegistryName(location("copper_hoe")),
				ItemList.copper_pickaxe = new PickaxeItem(ToolMaterialList.copper, -1, 1.2f, new Item.Properties().group(test)).setRegistryName(location("copper_pickaxe")),
				ItemList.copper_shovel = new ShovelItem(ToolMaterialList.copper, -1.0f, 0.8f, new Item.Properties().group(test)).setRegistryName(location("copper_shovel")),
				ItemList.copper_sword = new SwordItem(ToolMaterialList.copper, 0, 1.6f, new Item.Properties().group(test)).setRegistryName(location("copper_sword")),
				
				//Armor
				ItemList.copper_helm = new ArmorItem(ArmorMaterialList.copper, EquipmentSlotType.HEAD, new Item.Properties().group(test)).setRegistryName(location("copper_helmet")),
				ItemList.copper_chestplate = new ArmorItem(ArmorMaterialList.copper, EquipmentSlotType.CHEST, new Item.Properties().group(test)).setRegistryName(location("copper_chestplate")),
				ItemList.copper_leggings = new ArmorItem(ArmorMaterialList.copper, EquipmentSlotType.LEGS, new Item.Properties().group(test)).setRegistryName(location("copper_leggings")),
				ItemList.copper_boots = new ArmorItem(ArmorMaterialList.copper, EquipmentSlotType.FEET, new Item.Properties().group(test)).setRegistryName(location("copper_boots")),
				
				//Ore Items
				ItemList.stone_pebble = new Item(new Item.Properties().group(test)).setRegistryName(location("stone_pebble")),
				ItemList.graphite = new Item(new Item.Properties().group(test)).setRegistryName(location("graphite")),
				ItemList.sulfur = new Item(new Item.Properties().group(test)).setRegistryName(location("sulfur")),
				ItemList.gypsum = new Item(new Item.Properties().group(test)).setRegistryName(location("gypsum")),
				ItemList.borax = new Item(new Item.Properties().group(test)).setRegistryName(location("borax")),
				ItemList.limestone_pebble = new Item(new Item.Properties().group(test)).setRegistryName(location("limestone_pebble")),
				ItemList.potasium_nitrate = new Item(new Item.Properties().group(test)).setRegistryName(location("potasium_nitrate")),
				ItemList.kaolinite = new Item(new Item.Properties().group(test)).setRegistryName(location("kaolinite")),
				
				ItemList.bismuth_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("bismuth_chunk")),
				ItemList.bismuth_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("bismuth_chunk_small")),
				ItemList.bismuth_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("bismuth_chunk_large")),
				
				ItemList.tin_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("tin_chunk")),
				ItemList.tin_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("tin_chunk_small")),
				ItemList.tin_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("tin_chunk_large")),
				
				
				ItemList.nickel_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("nickel_chunk")),
				ItemList.nickel_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("nickel_chunk_small")),
				ItemList.nickel_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("nickel_chunk_large")),
				
				ItemList.copper_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("copper_chunk")),
				ItemList.copper_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("copper_chunk_small")),
				ItemList.copper_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("copper_chunk_large")),
				
				ItemList.silver_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("silver_chunk")),
				ItemList.silver_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("silver_chunk_small")),
				ItemList.silver_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("silver_chunk_large")),
				
				ItemList.zinc_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("zinc_chunk")),
				ItemList.zinc_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("zinc_chunk_small")),
				ItemList.zinc_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("zinc_chunk_large")),
				
				ItemList.platinum_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("platinum_chunk")),
				ItemList.platinum_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("platinum_chunk_small")),
				ItemList.platinum_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("platinum_chunk_large")),
				
				ItemList.lead_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("lead_chunk")),
				ItemList.lead_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("lead_chunk_small")),
				ItemList.lead_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("lead_chunk_large")),
				
				ItemList.aluminium_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("aluminium_chunk")),
				ItemList.aluminium_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("aluminium_chunk_small")),
				ItemList.aluminium_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("aluminium_chunk_large")),
				
				ItemList.iron_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("iron_chunk")),
				ItemList.iron_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("iron_chunk_small")),
				ItemList.iron_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("iron_chunk_large")),
				
				ItemList.gold_chunk = new Item(new Item.Properties().group(test)).setRegistryName(location("gold_chunk")),
				ItemList.gold_chunk_small = new Item(new Item.Properties().group(test)).setRegistryName(location("gold_chunk_small")),
				ItemList.gold_chunk_large = new Item(new Item.Properties().group(test)).setRegistryName(location("gold_chunk_large")),
				
				
				
				//Ingots
				ItemList.bismuth_ingot = new Item(new Item.Properties().group(test)).setRegistryName(location("bismuth_ingot")),
				ItemList.tin_ingot = new Item(new Item.Properties().group(test)).setRegistryName(location("tin_ingot")),
				ItemList.nickel_ingot = new Item(new Item.Properties().group(test)).setRegistryName(location("nickel_ingot")),
				ItemList.copper_ingot = new Item(new Item.Properties().group(test)).setRegistryName(location("copper_ingot")),
				ItemList.silver_ingot = new Item(new Item.Properties().group(test)).setRegistryName(location("silver_ingot")),
				ItemList.zinc_ingot = new Item(new Item.Properties().group(test)).setRegistryName(location("zinc_ingot")),
				ItemList.platinum_ingot = new Item(new Item.Properties().group(test)).setRegistryName(location("platinum_ingot")),
				ItemList.lead_ingot = new Item(new Item.Properties().group(test)).setRegistryName(location("lead_ingot")),
				ItemList.aluminium_ingot = new Item(new Item.Properties().group(test)).setRegistryName(location("aluminium_ingot")),
				
				//Foods
				ItemList.test_food = (new Item(new Item.Properties().group(test).food(FoodList.test_food)).setRegistryName(location("test_food"))),
				
				//Blocks
				ItemList.test_block = new BlockItem(BlockList.test_block, new Item.Properties().group(test)).setRegistryName(BlockList.test_block.getRegistryName()),
				ItemList.aluminium_ore = new BlockItem(BlockList.aluminium_ore, new Item.Properties().group(test)).setRegistryName(BlockList.aluminium_ore.getRegistryName()),
				ItemList.bismuth_ore = new BlockItem(BlockList.bismuth_ore, new Item.Properties().group(test)).setRegistryName(BlockList.bismuth_ore.getRegistryName()),
				ItemList.tin_ore = new BlockItem(BlockList.tin_ore, new Item.Properties().group(test)).setRegistryName(BlockList.tin_ore.getRegistryName()),
				ItemList.nickel_ore = new BlockItem(BlockList.nickel_ore, new Item.Properties().group(test)).setRegistryName(BlockList.nickel_ore.getRegistryName()),
				ItemList.copper_ore = new BlockItem(BlockList.copper_ore, new Item.Properties().group(test)).setRegistryName(BlockList.copper_ore.getRegistryName()),
				ItemList.silver_ore = new BlockItem(BlockList.silver_ore, new Item.Properties().group(test)).setRegistryName(BlockList.silver_ore.getRegistryName()),
				ItemList.zinc_ore = new BlockItem(BlockList.zinc_ore, new Item.Properties().group(test)).setRegistryName(BlockList.zinc_ore.getRegistryName()),
				ItemList.graphite_ore = new BlockItem(BlockList.graphite_ore, new Item.Properties().group(test)).setRegistryName(BlockList.graphite_ore.getRegistryName()),
				ItemList.sulfur_ore = new BlockItem(BlockList.sulfur_ore, new Item.Properties().group(test)).setRegistryName(BlockList.sulfur_ore.getRegistryName()),
				ItemList.platinum_ore = new BlockItem(BlockList.platinum_ore, new Item.Properties().group(test)).setRegistryName(BlockList.platinum_ore.getRegistryName()),
				ItemList.lead_ore = new BlockItem(BlockList.lead_ore, new Item.Properties().group(test)).setRegistryName(BlockList.lead_ore.getRegistryName()),
				ItemList.gypsum_ore = new BlockItem(BlockList.gypsum_ore, new Item.Properties().group(test)).setRegistryName(BlockList.gypsum_ore.getRegistryName()),
				ItemList.borax_ore = new BlockItem(BlockList.borax_ore, new Item.Properties().group(test)).setRegistryName(BlockList.borax_ore.getRegistryName()),
				ItemList.potasium_nitrate_ore = new BlockItem(BlockList.potasium_nitrate_ore, new Item.Properties().group(test)).setRegistryName(BlockList.potasium_nitrate_ore.getRegistryName()),
				ItemList.kaolinite_ore = new BlockItem(BlockList.kaolinite_ore, new Item.Properties().group(test)).setRegistryName(BlockList.kaolinite_ore.getRegistryName()),
				ItemList.limestone = new BlockItem(BlockList.limestone, new Item.Properties().group(test)).setRegistryName(BlockList.limestone.getRegistryName())
			);
			
			logger.info("Items Registerd.");
		}
		
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
					BlockList.test_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("test_block")),
					
					//Ore
					BlockList.aluminium_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("aluminium_ore")),
					BlockList.bismuth_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("bismuth_ore")),
					BlockList.tin_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("tin_ore")),
					BlockList.nickel_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("nickel_ore")),
					BlockList.copper_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("copper_ore")),
					BlockList.silver_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("silver_ore")),
					BlockList.zinc_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("zinc_ore")),
					BlockList.graphite_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("graphite_ore")),
					BlockList.sulfur_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("sulfur_ore")),
					BlockList.platinum_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("platinum_ore")),
					BlockList.lead_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("lead_ore")),
					BlockList.gypsum_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("gypsum_ore")),
					BlockList.borax_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("borax_ore")),
					BlockList.potasium_nitrate_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("potasium_nitrate_ore")),
					BlockList.limestone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("limestone")),
					BlockList.kaolinite_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("kaolinite_ore"))
			);
			
			logger.info("Blocks Registered");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}


	}
	
	public static void ownFileWriter(String str) throws IOException
	{
			FileWriter fw = new FileWriter(new File("C:/Users/Olivia/eclipse-workspace/Minecraft Mod Untitled/MyLogs.txt"), true);
			BufferedWriter out = new BufferedWriter(fw);
			out.write(str);
			out.close();
	}
}