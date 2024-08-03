package com.github.phoswald.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StandardLibraryTest {

    private final StandardLibrary testee = new StandardLibrary();

    @Test
    void strlen_valid_success() {
        assertEquals(6, testee.strlen("foobar"));
    }
}
