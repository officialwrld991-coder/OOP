package entry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryTest {

    @Test
    public void testConstructor() {
        Entry entry = new Entry(1,"book title", "book content");

        assertEquals(1, entry.getId());
        assertEquals("book title", entry.getTitle());
        assertEquals("book content", entry.getBody());
    }
}
