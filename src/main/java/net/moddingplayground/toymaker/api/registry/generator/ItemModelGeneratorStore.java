package net.moddingplayground.toymaker.api.registry.generator;

import net.moddingplayground.toymaker.api.generator.model.item.AbstractItemModelGenerator;
import net.moddingplayground.toymaker.api.registry.ToymakerRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ItemModelGeneratorStore {
    private final Supplier<AbstractItemModelGenerator> factory;

    public ItemModelGeneratorStore(Supplier<AbstractItemModelGenerator> factory) {
        this.factory = factory;
    }

    public static List<Supplier<AbstractItemModelGenerator>> all() {
        List<Supplier<AbstractItemModelGenerator>> list = new ArrayList<>();
        for (ItemModelGeneratorStore store : ToymakerRegistry.ITEM_MODEL) list.add(store.factory);
        return list;
    }
}
