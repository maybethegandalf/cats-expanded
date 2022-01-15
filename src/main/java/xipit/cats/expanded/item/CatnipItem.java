package xipit.cats.expanded.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class CatnipItem 
extends AliasedBlockItem{

    public CatnipItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext){
        tooltip.add(new TranslatableText("item.catsexpanded.catnip.tooltip"));

        //tooltip.add(new TranslatableText("item.simplecatears.catears.tooltip").formatted((Formatting.RED)));
    }
    
}