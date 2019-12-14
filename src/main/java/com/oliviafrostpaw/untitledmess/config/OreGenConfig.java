package com.oliviafrostpaw.untitledmess.config;

import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig 
{
	public static ForgeConfigSpec.IntValue copper_chance;
	public static CountRangeConfig copper_height;
	
	public static ForgeConfigSpec.IntValue bismuth_chance;
	public static CountRangeConfig bismuth_height;
	
	public static ForgeConfigSpec.IntValue tin_chance;
	public static CountRangeConfig tin_height;
	
	public static ForgeConfigSpec.IntValue nickel_chance;
	public static CountRangeConfig nickel_height;
	
	public static ForgeConfigSpec.IntValue silver_chance;
	public static CountRangeConfig silver_height;
	
	public static ForgeConfigSpec.IntValue zinc_chance;
	public static CountRangeConfig zinc_height;
	
	public static ForgeConfigSpec.IntValue graphite_chance;
	public static CountRangeConfig graphite_height;
	
	public static ForgeConfigSpec.IntValue sulfur_chance;
	public static CountRangeConfig sulfur_height;
	
	public static ForgeConfigSpec.IntValue platinum_chance;
	public static CountRangeConfig platinum_height;
	
	public static ForgeConfigSpec.IntValue lead_chance;
	public static CountRangeConfig lead_height;
	
	public static ForgeConfigSpec.IntValue gypsum_chance;
	public static CountRangeConfig gypsum_height;
	
	public static ForgeConfigSpec.IntValue borax_chance;
	public static CountRangeConfig borax_height;
	
	public static ForgeConfigSpec.IntValue aluminium_chance;
	public static CountRangeConfig aluminium_height;
	
	public static ForgeConfigSpec.IntValue potasium_nitrate_chance;
	public static CountRangeConfig potasium_nitrate_height;
	
	public static ForgeConfigSpec.IntValue kaolinite_chance;
	public static CountRangeConfig kaolinite_height;
	
	
	public static ForgeConfigSpec.BooleanValue generate_overworld;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Oregen Config");
		
		copper_chance = server
				.comment("Maximum number of ore veins of the copper ore that can spawn in one chunk.")
				.defineInRange("oregen.copper_chance", 3, 1, 7); //path, default value, min value, max value - Number of veins in chunk
		copper_height = new CountRangeConfig(4, 30, 0, 50); //Max Count in Vein, BottomOffset, TopOffset, Maximum - Vein Statistics
		
		bismuth_chance = server.defineInRange("oregen.bismuth", 2, 1, 5);
		bismuth_height = new CountRangeConfig(3, 30, 0, 50);
		
		tin_chance = server.defineInRange("oregen.tin", 2, 1, 4);
		tin_height = new CountRangeConfig(5, 20, 0, 60);
		
		nickel_chance = server.defineInRange("oregen.nickel", 1, 0, 2);
		nickel_height = new CountRangeConfig(2, 0, 0, 20);
		
		silver_chance = server.defineInRange("oregen.silver", 1, 0, 2);
		silver_height = new CountRangeConfig(2, 0, 0, 16);
		
		zinc_chance = server.defineInRange("oregen.zinc", 2, 1, 5);
		zinc_height = new CountRangeConfig(3, 30, 0, 50);
		
		graphite_chance = server.defineInRange("oregen.graphite", 3, 1, 5);
		graphite_height = new CountRangeConfig(10, 30, 0, 50);
		
		sulfur_chance = server.defineInRange("oregen.sulfur", 2, 0, 5);
		sulfur_height = new CountRangeConfig(6, 30, 0, 50);
		
		platinum_chance = server.defineInRange("oregen.platinum", 1, 0, 5);
		platinum_height = new CountRangeConfig(2, 0, 0, 16);
		
		lead_chance = server.defineInRange("oregen.lead", 3, 1, 5);
		lead_height = new CountRangeConfig(6, 20, 0, 60);
		
		gypsum_chance = server.defineInRange("oregen.gypsum", 2, 1, 5);
		gypsum_height = new CountRangeConfig(6, 30, 0, 60);
		
		borax_chance = server.defineInRange("oregen.borax", 2, 1, 5);
		borax_height = new CountRangeConfig(6, 30, 0, 60);
		
		aluminium_chance = server.defineInRange("oregen.aluminium", 3, 1, 5);
		aluminium_height = new CountRangeConfig(3, 25, 0, 40);
		
		potasium_nitrate_chance = server.defineInRange("oregen.potasium_nitrate", 3, 1, 3);
		potasium_nitrate_height = new CountRangeConfig(7, 40, 0, 60);
		
		kaolinite_chance = server.defineInRange("oregen.kaolinite", 1, 0, 2);
		kaolinite_height = new CountRangeConfig(2, 20, 0, 35);
		
		
		generate_overworld = server
				.comment("Decide if you want Mod ores to spawn in the overworld")
				.define("oregen.generate_overworld", true);
	}
}
