package net.moddingplayground.toymaker.api.registry.generator;

import net.moddingplayground.toymaker.api.generator.tag.AbstractTagGenerator;
import net.moddingplayground.toymaker.api.registry.ToymakerRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TagGeneratorStore<T extends AbstractTagGenerator<?>> {
    private final Supplier<T> factory;

    public TagGeneratorStore(Supplier<T> factory) {
        this.factory = factory;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List<Supplier<AbstractTagGenerator<?>>> all() {
        List<Supplier<AbstractTagGenerator<?>>> list = new ArrayList<>();
        for (TagGeneratorStore store : ToymakerRegistry.TAG) list.add(store.factory);
        return list;
    }
}
