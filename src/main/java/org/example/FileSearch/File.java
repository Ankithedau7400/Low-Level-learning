package org.example.FileSearch;

import java.util.HashSet;
import java.util.Set;

public class File {
    private final boolean isDirectory;
    private final int size;
    private final String owner;
    private final String filename;
    private final Set<File> entries = new HashSet<>();

    public File(
            final boolean isDirectory,
            final int size,
            final String owner,
            final String filename) {
        this.isDirectory = isDirectory;
        this.size = size;
        this.owner = owner;
        this.filename = filename;
    }


    // Extracts the value of a specified file attribute
    public Object extract(final FileAttribute attributeName) {
        switch (attributeName) {
            case IS_DIRECTORY:
                return isDirectory;
            case SIZE:
                return size;
            case OWNER:
                return owner;
            case FILENAME:
                return filename;
            default:
                throw new IllegalArgumentException("Unknown attribute: " + attributeName);
        }
    }

    public void addEntry(final File entry) {
        entries.add(entry);
    }

    public Set<File> getEntries(){
        return entries;
    }



}
