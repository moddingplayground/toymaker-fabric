package net.moddingplayground.toymaker.api.registry.generator;

import net.moddingplayground.toymaker.api.generator.model.block.AbstractStateModelGenerator;
import net.moddingplayground.toymaker.api.registry.ToymakerRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class StateModelGeneratorStore {
    private final Supplier<AbstractStateModelGenerator> factory;

    public StateModelGeneratorStore(Supplier<AbstractStateModelGenerator> factory) {
        this.factory = factory;
    }

    public static List<Supplier<AbstractStateModelGenerator>> all() {
        List<Supplier<AbstractStateModelGenerator>> list = new ArrayList<>();
        for (StateModelGeneratorStore store : ToymakerRegistry.STATE_MODEL) list.add(store.factory);
        return list;
    }
}
