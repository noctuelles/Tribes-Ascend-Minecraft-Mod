package com.multi7200.tam.event;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LivingEventHandler
{
	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event)
	{

	}

	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event)
	{
		event.distance = 0F;
	}
}