package com.lothrazar.samsapples;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionCustom extends Potion
{ 
	ResourceLocation location;
	protected PotionCustom(int potionID, ResourceLocation loc,	boolean badEffect, int potionColor) 
	{
		super(false,potionColor); 
		location = loc;
		Potion.potionRegistry.register(potionID, location, this);
	} 

    @SideOnly(Side.CLIENT)
    public boolean hasStatusIcon()
    {
        return false;//whether or not to render in the top right.
    }
    
	@Override
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc) 
	{ 
		UtilItemRenderer.renderItemAt(location,x+6,y+6);
		
		super.renderInventoryEffect(x, y, effect, mc);
	}
}
