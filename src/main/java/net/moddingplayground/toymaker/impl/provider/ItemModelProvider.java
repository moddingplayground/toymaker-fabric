package net.moddingplayground.toymaker.impl.provider;

import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Identifier;
import net.moddingplayground.toymaker.api.generator.model.item.AbstractItemModelGenerator;
import net.moddingplayground.toymaker.api.registry.generator.ItemModelGeneratorStore;
import net.moddingplayground.toymaker.impl.DataType;

import java.util.Map;
import java.util.function.Supplier;

public class ItemModelProvider extends AbstractDataProvider<Supplier<AbstractItemModelGenerator>> {
    public ItemModelProvider(DataGenerator root) {
        super(root);
    }

    @Override
    public String getName() {
        return "Item Models";
    }

    @Override
    public String getFolder() {
        return "models/item";
    }

    @Override
    public DataType getDataType() {
        return DataType.ASSET;
    }

    @Override
    public Iterable<Supplier<AbstractItemModelGenerator>> getGenerators() {
        return ItemModelGeneratorStore.all();
    }

    @Override
    public Map<Identifier, JsonElement> createFileMap() {
        Map<Identifier, JsonElement> map = Maps.newHashMap();
        for (Supplier<AbstractItemModelGenerator> generator : this.getGenerators()) {
            generator.get().accept((id, modelGen) -> {
                if (map.put(id, modelGen.makeJson(id)) != null) throw new IllegalStateException("Duplicate model " + id);
            });
        }
        return map;
    }
}
