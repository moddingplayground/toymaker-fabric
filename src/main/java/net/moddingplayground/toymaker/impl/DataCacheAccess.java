package net.moddingplayground.toymaker.impl;

import java.nio.file.Path;

@SuppressWarnings("unused")
public interface DataCacheAccess {
    void addCopyPath(Path out);
    void keepFiles(Path... keep);
}
