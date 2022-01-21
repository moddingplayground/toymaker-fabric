package net.moddingplayground.toymaker.api.registry.generator;

import net.moddingplayground.toymaker.api.generator.recipe.AbstractRecipeGenerator;
import net.moddingplayground.toymaker.api.registry.ToymakerRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RecipeGeneratorStore {
    private final Supplier<AbstractRecipeGenerator> factory;

    public RecipeGeneratorStore(Supplier<AbstractRecipeGenerator> factory) {
        this.factory = factory;
    }

    public static List<Supplier<AbstractRecipeGenerator>> all() {
        List<Supplier<AbstractRecipeGenerator>> list = new ArrayList<>();
        for (RecipeGeneratorStore store : ToymakerRegistry.RECIPE) list.add(store.factory);
        return list;
    }
}
