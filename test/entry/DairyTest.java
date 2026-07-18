package entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DairyTest {

    Dairy dairy;

    @BeforeEach
    public void setUp() {
        dairy = new Dairy("Death Note", "password");
    }

    @Test
    public void nonsenseTest() {
        assertTrue(dairy.isDairyLocked("password"));

        dairy.unlockDairy("password");

        assertFalse(dairy.isDairyLocked("password"));
    }

    @Test
    public void unlockDairyWithWrongPasswordThrowsExceptionTest() {
        assertTrue(dairy.isDairyLocked("password"));

        assertThrows(IllegalArgumentException.class, () -> dairy.unlockDairy("wrong password"));
    }

    @Test
    public void lockDairyAfterBeingUnlocked() {
        assertTrue(dairy.isDairyLocked("password"));
        dairy.unlockDairy("password");
        dairy.lockDairy();
        assertTrue(dairy.isDairyLocked("password"));
    }

    @Test
    public void createNewEntry() {
        int newEntry = dairy.createEntry("Consequences", "In nature there are neither rewards nor punishments, there are consequences");
        assertEquals(1, newEntry);
    }
    @Test
    public void FindAnEntry() {
        dairy.unlockDairy("password");
        int newEntry = dairy.createEntry("Consequences", "In nature there are neither rewards nor punishments, there are consequences");
        int secondEntry = dairy.createEntry("Peace", "That State of Mind where you are happy");
        int thirdEntry = dairy.createEntry("Palmpay", "dem wan collect money wey no their own");

        Entry foundEntry= dairy.findEntry(thirdEntry);

        assertEquals(3, foundEntry.getEntryId());
    }

    @Test
    public void deleteAnEntry () {
        dairy.unlockDairy("password");
        int newEntry = dairy.createEntry("Consequences", "In nature there are neither rewards nor punishments, there are consequences");
        int secondEntry = dairy.createEntry("Peace", "That State of Mind where you are happy");
        int thirdEntry = dairy.createEntry("Palmpay", "dem wan collect money wey no their own");
        dairy.deleteEntry(secondEntry, "password");

        assertThrows(IllegalArgumentException.class, () -> dairy.findEntry(secondEntry));
    }

    @Test
    public void editAnEntry () {
        dairy.unlockDairy("password");
        int newEntry = dairy.createEntry("Consequences", "In nature there are neither rewards nor punishments, there are consequences");
        int secondEntry = dairy.createEntry("Peace", "That State of Mind where you are happy");
        int thirdEntry = dairy.createEntry("Palmpay", "dem wan collect money wey no their own");

        dairy.updateEntry(2, "Gravity", "i no sabi am sef");
        Entry updated =dairy.findEntry(2);

        assertEquals("Gravity", updated.getTitle());
        assertEquals("i no sabi am sef", updated.getBody());


    }
}
