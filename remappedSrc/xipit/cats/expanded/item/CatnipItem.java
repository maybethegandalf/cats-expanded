package xipit.cats.expanded.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.*;

import net.minecraft.text.TranslatableTextContent;
import net.minecraft.world.World;

public class CatnipItem 
extends AliasedBlockItem{

    public CatnipItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext){
        tooltip.add()
        tooltip.add(new TranslatableTextContent("item.catsexpanded.catnip.tooltip"));
    }
    
}
