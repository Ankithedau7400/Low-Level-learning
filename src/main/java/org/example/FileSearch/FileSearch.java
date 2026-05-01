package org.example.FileSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {
    public List<File> search(final File root,final FileSearchCriteria criteria){
        final List<File> result = new ArrayList<>();
        // Stack to handle recursive traversal without actual recursion
        final ArrayDeque<File> recursionStack = new ArrayDeque<>();
        // Start with the root directory
        recursionStack.add(root);
        while(!recursionStack.isEmpty()){
            File next = recursionStack.pop();
            // Check if the file matches our criteria
            if (criteria.isMatch(next)) {
                result.add(next);
            }
            for(File entry: root.getEntries()){
                recursionStack.push(entry);
            }
        }

        return result;
    }
}
