package com.oliviafrostpaw.untitledmess.lists;

import com.oliviafrostpaw.untitledmess.UntitledMess;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial
{
	copper("copper", 15, new int[] {2, 5, 5, 2}, 15, ItemList.copper_ingot, "item.armor.equip_iron", 0.0f);

	private String name, equipSound;
	private int durability, enchantability;
	private int[] damageReductionAmount;
	private Item repairItem;
	private float toughness;
	private static final int[] max_damage_array = new int[] {13, 15, 16, 11};
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmount, int enchantability, Item repairItem, String equipSound, float toughness)
	{
		this.name = name;
		this.durability = durability;
		this.equipSound = equipSound;
		this.enchantability = enchantability;
		this.damageReductionAmount = damageReductionAmount;
		this.repairItem = repairItem;
		this.toughness = toughness;
	}
	
	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{
		return this.damageReductionAmount[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return UntitledMess.modid + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}

}
