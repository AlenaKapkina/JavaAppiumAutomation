import lib.CoreTestCase;
import org.junit.Test;

public class MainClassTest extends CoreTestCase {

    MainClass main = new MainClass();

    @Test
    public void testGetLocalNumber() {
        int expected = 14;

        int actual = main.getLocalNumber();

        assertEquals("The numbers are not equal", expected, actual);
    }

    @Test
    public void testGetClassNumber() {
        int mustBeLessThanActual = 45;

        int actual = main.getClassNumber();

        assertTrue(main.getClassNumber() + " is less than " + mustBeLessThanActual, actual > mustBeLessThanActual);
    }

    @Test
    public void testGetClassString() {
        String[] strings = main.getClassString().split(",");

        String actual = "hello";

        assertEquals("There's no " + actual, strings[0].toLowerCase(), actual);
    }
}
