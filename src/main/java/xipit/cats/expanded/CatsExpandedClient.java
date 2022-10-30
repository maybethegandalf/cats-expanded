package xipit.cats.expanded;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import xipit.cats.expanded.block.ModBlocks;
import xipit.cats.expanded.item.armor.CatearArmor;
import xipit.cats.expanded.util.ModelHandler;

@Environment(EnvType.CLIENT)
public class CatsExpandedClient implements ClientModInitializer {

    // copied from catfacts.json because i couldnt get json parsing with relative filePath to work ._.
    public static final String[] CATFACTS = {
            "More than Meow! Cats Can Make Over 90 Different Sounds",
            "Lions, Tigers, Jaguars, and Leopards Purr Too",
            "Cats Can Move Their Ears 180 Degrees",
            "Milk Is Not Good For Cats! Most Cats Are Lactose Intolerant (incl. the author of this mod, no milk chocolate for me ._.)",
            "There Are Exactly 24 Whiskers On Every Cat",
            "All House Cats are Descended from One Species, Felis Sylvestris",
            "The First Brand of Commercial Cat Litter Was Invented in 1947",
            "Cat’s Spend 2/3rds of Their Life Sleeping",
            "Snow Leopards, Cheetahs and More Big Cats are Endangered",
            "Owning a Cat Reduces Cardiovascular Disease and Lowers Cholesterol, this does not apply to playing a cat mod tho",
            "Unlike humans, cats cannot detect sweetness",
            "Ginger tabby cats can have freckles around their mouths and on their eyelids",
            "Domestic cat´s purr has a frequency around 25 and 150 Hertz, which helps muscles and bones to grow and repair themselves",
            "Cats only meow to talk to humans or, as a kitten to communicate with their mother",
            "The oldest known cat lived to be 38 years old and was called 'Creme Puff'",
            "The average cat can jump up to six times its body length high",
            "Cats can smell 14x better than us puny humans",
            "Cats can only move their jaw up and down, not side to side",
            "Cats have 3 eyelids",
            "A cats heartrate is about double of our own",
            "Cats prefer to remain non-confrontational",
            "A cats left paw is usually their dominant paw"
    };

    @Override
    public void onInitializeClient() {
        CatsExpandedMod.LOGGER.info("Registering client side custom rendering");

        // enables transparency
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CATNIP_BUSH, RenderLayer.getCutout());

        // enables custom 3D Model 
        ModelHandler.init((loc, def) -> EntityModelLayerRegistry.registerModelLayer(loc, () -> def));
        registerArmorRenderer();
    }

    private void registerArmorRenderer() {
        Item[] armors = Registry.ITEM.stream()
                .filter(i -> i instanceof CatearArmor
                        && Registry.ITEM.getKey(i).get().getValue().getNamespace().equals(CatsExpandedMod.MOD_ID))
                .toArray(Item[]::new);

        ArmorRenderer renderer = (matrices, vertexConsumer, stack, entity, slot, light, original) -> {
            CatearArmor armor = (CatearArmor) stack.getItem();
            var model = armor.getArmorModel();
            var texture = armor.getArmorTexture(stack, slot);
            original.setAttributes(model);
            ArmorRenderer.renderPart(matrices, vertexConsumer, light, stack, model, texture);
        };
        ArmorRenderer.register(renderer, armors);
    }
}
