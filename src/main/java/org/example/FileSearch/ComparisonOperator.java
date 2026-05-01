package org.example.FileSearch;

public interface ComparisonOperator<T> {
    boolean isMatch(final T attributeValue, final T expectedValue);
}
