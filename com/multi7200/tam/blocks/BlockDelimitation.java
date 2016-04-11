package com.multi7200.tam.blocks;

import com.multi7200.tam.TribesAscendMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDelimitation extends Block {

	public BlockDelimitation(Material material) {
		super(material);
		
		this.setBlockUnbreakable();
		this.setHardness(600000F);
	}
}
