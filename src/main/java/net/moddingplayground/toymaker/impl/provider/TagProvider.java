package net.moddingplayground.toymaker.impl.provider;

import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Identifier;
import net.moddingplayground.toymaker.api.generator.tag.AbstractTagGenerator;
import net.moddingplayground.toymaker.api.registry.generator.TagGeneratorStore;
import net.moddingplayground.toymaker.impl.DataType;

import java.util.Map;
import java.util.function.Supplier;

public class TagProvider extends AbstractDataProvider<Supplier<AbstractTagGenerator<?>>> {
    public TagProvider(DataGenerator root) {
        super(root);
    }

    @Override
    public String getName() {
        return "Tag";
    }

    @Override
    public String getFolder() {
        return "tags";
    }

    @Override
    public DataType getDataType() {
        return DataType.DATA;
    }

    @Override
    public Iterable<Supplier<AbstractTagGenerator<?>>> getGenerators() {
        return TagGeneratorStore.all();
    }

    @Override
    public Map<Identifier, JsonElement> createFileMap() {
        Map<Identifier, JsonElement> map = Maps.newHashMap();
        for (Supplier<AbstractTagGenerator<?>> generator : this.getGenerators()) {
            generator.get().accept((id, factory) -> {
                if (map.put(id, factory.createJson()) != null) {
                    throw new IllegalStateException("Duplicate tag " + id);
                }
            });
        }
        return map;
    }
}
