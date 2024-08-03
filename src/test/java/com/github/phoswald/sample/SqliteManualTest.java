package com.github.phoswald.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SqliteManualTest {

    private final SqliteManual testee = new SqliteManual();

    @Test
    void getVersion_valid_success() {
        assertEquals("3.37.2", testee.getVersion());
    }
}
