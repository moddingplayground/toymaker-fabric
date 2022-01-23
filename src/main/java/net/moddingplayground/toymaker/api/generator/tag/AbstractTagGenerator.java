package net.moddingplayground.toymaker.api.generator.tag;

import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.moddingplayground.toymaker.api.generator.AbstractGenerator;

@SuppressWarnings("unused")
public abstract class AbstractTagGenerator<T> extends AbstractGenerator<Identifier, TagEntryFactory<T>> {
    protected final Registry<T> registry;
    protected final String tagDir;

    public AbstractTagGenerator(String modId, Registry<T> registry, String tagDir) {
        super(modId);
        this.registry = registry;
        this.tagDir = tagDir;
    }

    public AbstractTagGenerator(String modId, Registry<T> registry) {
        this(modId, registry, registry.getKey().getValue().getPath());
    }

    @SafeVarargs
    public final TagEntryFactory<T> add(Tag<T> tag, T... objects) {
        return this.getOrCreateFactory(tag).add(objects);
    }

    @SafeVarargs
    public final TagEntryFactory<T> add(Tag<T> tag, RegistryKey<T>... objects) {
        TagEntryFactory<T> factory = this.getOrCreateFactory(tag);
        for (RegistryKey<T> object : objects) factory.add(this.registry.get(object));
        return factory;
    }

    @SafeVarargs
    public final TagEntryFactory<T> add(Tag<T> tag, Tag<T>... tags) {
        return this.getOrCreateFactory(tag).add(tags);
    }

    public TagEntryFactory<T> getOrCreateFactory(Tag<T> tag) {
        if (tag instanceof Tag.Identified identified) {
            return this.getOrCreateFactory(identified.getId());
        } else {
            throw new RuntimeException("Cannot identify tag " + tag);
        }
    }

    public TagEntryFactory<T> getOrCreateFactory(Identifier id) {
        return this.map.computeIfAbsent(this.getId(id), i -> new TagEntryFactory<>(this.registry::getId));
    }

    public Identifier getId(Identifier id) {
        return new Identifier(id.getNamespace(), String.format("%ss/%s", this.tagDir, id.getPath()));
    }
}
