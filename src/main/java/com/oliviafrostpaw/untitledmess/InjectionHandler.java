package com.oliviafrostpaw.untitledmess;

import java.io.IOException;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class InjectionHandler 
{
	@SubscribeEvent
	public static void onLootLoad(LootTableLoadEvent event) throws IOException
	{
		UntitledMess.ownFileWriter("Doing something");
		if(event.getName().equals(new ResourceLocation("minecraft", "grass")))
		{
			UntitledMess.ownFileWriter("Finally");
			event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(UntitledMess.modid, "grass"))).build());
		}
	}
}
