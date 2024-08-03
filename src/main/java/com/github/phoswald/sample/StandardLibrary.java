package com.github.phoswald.sample;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

class StandardLibrary {

    private static final Arena arena = Arena.global();
    private static final Linker linker = Linker.nativeLinker();
    private static final SymbolLookup lookup = linker.defaultLookup();

    private final MethodHandle strlen = linker.downcallHandle( //
            lookup.find("strlen").get(), FunctionDescriptor.of(JAVA_LONG, ADDRESS));

    int strlen(String s) {
        try {
            MemorySegment segment = arena.allocateFrom(s);
            long len = (long) strlen.invokeExact(segment);
            return (int) len;

        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
