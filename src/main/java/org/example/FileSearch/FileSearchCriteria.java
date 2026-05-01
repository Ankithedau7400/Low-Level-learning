package org.example.FileSearch;

public class FileSearchCriteria {
    public final Predicate predicate;

    public FileSearchCriteria(Predicate predicate) {
        this.predicate = predicate;
    }
    public boolean isMatch(final File inputFile){
        return predicate.isMatch(inputFile);
    }
}
