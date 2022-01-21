package net.moddingplayground.toymaker.api.registry;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.SimpleRegistry;
import net.moddingplayground.toymaker.Toymaker;
import net.moddingplayground.toymaker.api.registry.generator.AdvancementGeneratorStore;
import net.moddingplayground.toymaker.api.registry.generator.ItemModelGeneratorStore;
import net.moddingplayground.toymaker.api.registry.generator.LootGeneratorStore;
import net.moddingplayground.toymaker.api.registry.generator.RecipeGeneratorStore;
import net.moddingplayground.toymaker.api.registry.generator.StateModelGeneratorStore;
import net.moddingplayground.toymaker.api.registry.generator.TagGeneratorStore;

@SuppressWarnings("rawtypes")
public class ToymakerRegistry {
    public static final SimpleRegistry<AdvancementGeneratorStore> ADVANCEMENT = simple("advancement", AdvancementGeneratorStore.class);
    public static final SimpleRegistry<LootGeneratorStore> LOOT = simple("loot", LootGeneratorStore.class);
    public static final SimpleRegistry<StateModelGeneratorStore> STATE_MODEL = simple("state_model", StateModelGeneratorStore.class);
    public static final SimpleRegistry<ItemModelGeneratorStore> ITEM_MODEL = simple("item_model", ItemModelGeneratorStore.class);
    public static final SimpleRegistry<RecipeGeneratorStore> RECIPE = simple("recipe", RecipeGeneratorStore.class);
    public static final SimpleRegistry<TagGeneratorStore> TAG = simple("tag", TagGeneratorStore.class);

    private static <T> SimpleRegistry<T> simple(String id, Class<T> type) {
        return FabricRegistryBuilder.createSimple(type, id(id)).buildAndRegister();
    }

    private static Identifier id(String path) {
        return new Identifier(Toymaker.MOD_ID, path);
    }
}
