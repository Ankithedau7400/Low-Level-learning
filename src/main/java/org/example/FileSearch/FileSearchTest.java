package org.example.FileSearch;

import java.util.List;

public class FileSearchTest {
//    @Test
    public void testFileSearch() {
        final File root = new File(true, 0, "adam", "root");
        final File a = new File(false, 2000, "adam", "a");
        final File b = new File(false, 3000, "george", "b");
        // Add files to the root directory
        root.addEntry(a);
        root.addEntry(b);

        // Search criteria: Find non-directory files owned by users matching "ge.*"

        final FileSearchCriteria criteria =
                new FileSearchCriteria(
                        new AndPredicate(
                                List.of(
                                        new SimplePredicate<>(
                                                FileAttribute.IS_DIRECTORY,
                                                new EqualsOperator<>(),
                                                false),
                                        new SimplePredicate<>(
                                                FileAttribute.OWNER,
                                                new RegexMatchOperator<>(),
                                                "ge.*"))));

        final FileSearch fileSearch = new FileSearch();
        final List<File> result = fileSearch.search(root, criteria);

//        // Verify that only one file matches the criteria
//        assertEquals(1, result.size());
//        // Verify that the matching file is "b"
//        assertEquals("b", result.get(0).getFilename());




    }
}
