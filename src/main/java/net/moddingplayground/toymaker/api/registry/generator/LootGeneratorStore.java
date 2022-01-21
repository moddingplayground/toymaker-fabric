package net.moddingplayground.toymaker.api.registry.generator;

import net.minecraft.loot.context.LootContextType;
import net.minecraft.util.Pair;
import net.moddingplayground.toymaker.api.generator.loot.AbstractLootTableGenerator;
import net.moddingplayground.toymaker.api.registry.ToymakerRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LootGeneratorStore<T extends AbstractLootTableGenerator<?>> {
    private final Supplier<T> factory;
    private final LootContextType context;

    public LootGeneratorStore(Supplier<T> factory, LootContextType context) {
        this.factory = factory;
        this.context = context;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List<Pair<Supplier<AbstractLootTableGenerator<?>>, LootContextType>> all() {
        List<Pair<Supplier<AbstractLootTableGenerator<?>>, LootContextType>> list = new ArrayList<>();
        for (LootGeneratorStore<?> store : ToymakerRegistry.LOOT) list.add(new Pair(store.factory, store.context));
        return list;
    }
}
