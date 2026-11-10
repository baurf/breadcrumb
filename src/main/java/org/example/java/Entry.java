package org.example.java;

import java.util.List;

public class Entry {

    public String name;
    public List<Entry> entries;

    public Entry(String name) {
        this.name = name;
    }

    public Entry(String name, List<Entry> entries) {
        this.name = name;
        this.entries = entries;
    }
}
