package com.github.phoswald.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqliteExtractedTest {
    
    private final SqliteExtracted testee = new SqliteExtracted();
    
    @Test
    void getVersion_valid_success() {
        assertEquals("3.37.2", testee.getVersion());
    }
    
    @Test
    void open_valid_success() {
        boolean success = testee.open("testdata.db");
        assertTrue(success);
    }
}
