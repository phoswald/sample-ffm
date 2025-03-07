package com.github.phoswald.sample;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static org.sqlite.ffm.extracted.sqlite3_h.C_POINTER;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout.OfLong;

import org.sqlite.ffm.extracted.sqlite3_callback;
import org.sqlite.ffm.extracted.sqlite3_h;

class SqliteExtracted {
    
    private static final Arena arena = Arena.global();
    
    public String getVersion() {
        MemorySegment versionSegment = sqlite3_h.sqlite3_libversion();
        return versionSegment.getString(0); 
    }
    
    public boolean open(String filename) {

        MemorySegment filenameSegment = arena.allocateFrom(filename);
        MemorySegment dbPointerPointerSegement = arena.allocate(ADDRESS);
        int returnCode = sqlite3_h.sqlite3_open(filenameSegment, dbPointerPointerSegement);
        MemorySegment dbPointerSegement = dbPointerPointerSegement.get(ADDRESS, 0);
        if(returnCode != 0) {
            System.out.println("sqlite3_open() failed with " + returnCode);
            return false;
        }
        
        MemorySegment sqlSegement = arena.allocateFrom("SELECT * FROM person_;");
        MemorySegment zeroSegment = arena.allocateFrom(OfLong.JAVA_LONG, 0);
        MemorySegment callbackSegment = sqlite3_callback.allocate(this::callback, arena);
        MemorySegment errorMsgSegement = arena.allocate(ADDRESS);
        returnCode = sqlite3_h.sqlite3_exec(dbPointerSegement, sqlSegement, callbackSegment, zeroSegment, errorMsgSegement);
        if(returnCode != 0) {
            System.out.println("sqlite3_exec() failed with " + returnCode);
            return false;
        }
        
        returnCode = sqlite3_h.sqlite3_close(dbPointerSegement);
        if(returnCode != 0) {
            System.out.println("sqlite3_close() failed with " + returnCode);
            return false;
        }
        
        return true;
    }
    
    private int callback(MemorySegment unused, int columnCount, MemorySegment columnValues, MemorySegment columnNames) {
        System.out.println("callback(" + columnCount  + ")");
        for(int i = 0; i < columnCount; i++) {
            MemorySegment columnName = columnNames.getAtIndex(C_POINTER, i);
            MemorySegment columnValue = columnValues.getAtIndex(C_POINTER, i);
            System.out.println(" - " + columnName.getString(0) + " = " + columnValue.getString(0));
        }
        return 0;
    }
}
