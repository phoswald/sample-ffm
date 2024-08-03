package com.github.phoswald.sample;

import static java.lang.foreign.ValueLayout.JAVA_BYTE;

import java.lang.foreign.AddressLayout;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

class SqliteManual {

    private static final Arena arena = Arena.global();
    private static final Linker linker = Linker.nativeLinker();
    private static final SymbolLookup lookup = SymbolLookup.libraryLookup(System.mapLibraryName("sqlite3"), arena);

    private final MethodHandle sqlite3_libversion = linker.downcallHandle( //
            lookup.find("sqlite3_libversion").get(), FunctionDescriptor.of(Layouts.STRING));

    public String getVersion() {
        MemorySegment versionSegment;
        try {
            versionSegment = (MemorySegment) sqlite3_libversion.invokeExact();
            return versionSegment.getString(0);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static class Layouts {

        private static final AddressLayout STRING = ValueLayout.ADDRESS
                .withTargetLayout(MemoryLayout.sequenceLayout(java.lang.Long.MAX_VALUE, JAVA_BYTE));
    }
}
