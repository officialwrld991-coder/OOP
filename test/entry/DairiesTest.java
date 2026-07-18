package entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DairiesTest {

    Dairies dairies;

    @BeforeEach
    public void setUp() {dairies = new Dairies();}

    @Test
    public void DairiesIsEmpty () {
       assertTrue(dairies.isEmpty());
    }

    @Test
    public void iAddADairyIntoDairies () {
       dairies.addDairy("username", "password");

        assertFalse(dairies.isEmpty());
    }

    @Test
    public void iAdd3ADairyIntoDairies_IReturnOne () {
        dairies.addDairy("first", "password");
        dairies.addDairy("second", "password");
        dairies.addDairy("third", "password");
        Dairy foundDairy = dairies.findDairy("second");

        assertEquals("second", foundDairy.getUsername());
    }
    @Test
    public void iAdd3ADairyIntoDairies_findFour_ThrowsException () {
        dairies.addDairy("first", "password");
        dairies.addDairy("second", "password");
        dairies.addDairy("third", "password");

        assertThrows(IllegalArgumentException.class, () -> dairies.findDairy("fifth"));
    }

    @Test
    public void iAdd3ADairyIntoDairies_AddAnotherExistingUsername_ThrowsException () {
        dairies.addDairy("first", "password");
        dairies.addDairy("second", "password");
        dairies.addDairy("third", "password");

        assertThrows(IllegalArgumentException.class, () -> dairies.addDairy("first", "password"));
    }
    @Test
    public void iAdd3DairyIntoDairies_iDelete1 () {
        dairies.addDairy("first", "password");
        dairies.addDairy("second", "password");
        dairies.addDairy("third", "password");
        dairies.deleteDairy("second", "password");

        assertThrows(IllegalArgumentException.class, () -> dairies.findDairy("second"));
    }
}
