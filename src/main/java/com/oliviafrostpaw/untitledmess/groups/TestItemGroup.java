package com.oliviafrostpaw.untitledmess.groups;

import com.oliviafrostpaw.untitledmess.lists.BlockList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TestItemGroup extends ItemGroup
{

	public TestItemGroup() 
	{
		super("untitledmess");
	}

	@Override
	public ItemStack createIcon() 
	{
		//return new ItemStack(ItemList.test_item);
		return new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.test_block));
	}

}
