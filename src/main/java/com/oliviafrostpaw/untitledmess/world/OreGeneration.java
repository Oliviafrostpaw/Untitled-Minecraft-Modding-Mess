package com.oliviafrostpaw.untitledmess.world;

import com.oliviafrostpaw.untitledmess.config.OreGenConfig;
import com.oliviafrostpaw.untitledmess.lists.BlockList;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration 
{
	public static void setupOreGeneration()
	{
		if(OreGenConfig.generate_overworld.get())
		{
			for(Biome biome : ForgeRegistries.BIOMES)
			{
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.copper_ore.getDefaultState(),OreGenConfig.copper_chance.get(), OreGenConfig.copper_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.bismuth_ore.getDefaultState(),OreGenConfig.bismuth_chance.get(), OreGenConfig.bismuth_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.tin_ore.getDefaultState(),OreGenConfig.tin_chance.get(), OreGenConfig.tin_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.nickel_ore.getDefaultState(),OreGenConfig.nickel_chance.get(), OreGenConfig.nickel_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.silver_ore.getDefaultState(),OreGenConfig.silver_chance.get(), OreGenConfig.silver_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.zinc_ore.getDefaultState(),OreGenConfig.zinc_chance.get(), OreGenConfig.zinc_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.graphite_ore.getDefaultState(),OreGenConfig.graphite_chance.get(), OreGenConfig.graphite_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.sulfur_ore.getDefaultState(),OreGenConfig.sulfur_chance.get(), OreGenConfig.sulfur_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.platinum_ore.getDefaultState(),OreGenConfig.platinum_chance.get(), OreGenConfig.platinum_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.lead_ore.getDefaultState(),OreGenConfig.lead_chance.get(), OreGenConfig.lead_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.gypsum_ore.getDefaultState(),OreGenConfig.gypsum_chance.get(), OreGenConfig.gypsum_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.borax_ore.getDefaultState(),OreGenConfig.borax_chance.get(), OreGenConfig.borax_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.aluminium_ore.getDefaultState(),OreGenConfig.aluminium_chance.get(), OreGenConfig.aluminium_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.potasium_nitrate_ore.getDefaultState(),OreGenConfig.potasium_nitrate_chance.get(), OreGenConfig.potasium_nitrate_height));
				biome.addFeature(Decoration.UNDERGROUND_ORES, setupFeaturesOre(BlockList.kaolinite_ore.getDefaultState(),OreGenConfig.kaolinite_chance.get(), OreGenConfig.kaolinite_height));
				
			}
		}
	}
	
	public static ConfiguredFeature<?> setupFeaturesOre(BlockState block, int chance, CountRangeConfig config)
	{
		return Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, block, chance), Placement.COUNT_RANGE, config);
	}
}
