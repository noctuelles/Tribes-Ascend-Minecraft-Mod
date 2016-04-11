package com.multi7200.tam.sounds;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SoundHandler {

    public static void onEntityPlay(String name, World world,Entity entityName, float volume , float pitch){
        world.playSoundAtEntity(entityName,("tam:" + name), (float)volume, (float) pitch);
    }
}
