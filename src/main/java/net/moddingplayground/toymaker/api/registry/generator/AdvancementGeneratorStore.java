package net.moddingplayground.toymaker.api.registry.generator;

import net.moddingplayground.toymaker.api.generator.advancement.AbstractAdvancementGenerator;
import net.moddingplayground.toymaker.api.registry.ToymakerRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AdvancementGeneratorStore {
    private final Supplier<AbstractAdvancementGenerator> factory;

    public AdvancementGeneratorStore(Supplier<AbstractAdvancementGenerator> factory) {
        this.factory = factory;
    }

    public static List<Supplier<AbstractAdvancementGenerator>> all() {
        List<Supplier<AbstractAdvancementGenerator>> list = new ArrayList<>();
        for (AdvancementGeneratorStore store : ToymakerRegistry.ADVANCEMENT) list.add(store.factory);
        return list;
    }
}
