package com.github.budwing.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class DirFileDemo {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        root.add(new File("readme.txt", 100));
        Directory docs = new Directory("docs");
        docs.add(new File("manual.pdf", 2000));
        root.add(docs);

        root.print("");
    }
}

// Component
abstract class Entry {
    abstract String getName();
    abstract int getSize();
    void add(Entry entry) { throw new UnsupportedOperationException(); }
    abstract void print(String prefix);
}

// Leaf
class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        return size;
    }

    void print(String prefix) {
        System.out.println(prefix + "/" + name + " (" + size + ")");
    }
}

// Composite
class Directory extends Entry {
    private String name;
    private List<Entry> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    void add(Entry entry) {
        children.add(entry);
    }

    int getSize() {
        return children.stream().mapToInt(Entry::getSize).sum();
    }

    void print(String prefix) {
        System.out.println(prefix + "/" + name + " (" + getSize() + ")");
        for (Entry child : children) {
            child.print(prefix + "/" + name);
        }
    }
}
