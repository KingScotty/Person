import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

class SafeInputObjTest {

    @Test
    void testGetNonZeroLenString() {
        SafeInputObj safeInput = new SafeInputObj(new Scanner("TestInput\n"));
        String result = safeInput.getNonZeroLenString("Enter a non-zero length string: ");
        assertEquals("TestInput", result);
    }

    @Test
    void testGetDouble() {
        SafeInputObj safeInput = new SafeInputObj(new Scanner("42.5\n"));
        double result = safeInput.getDouble("Enter a double value: ");
        assertEquals(42.5, result);
    }

    @Test
    void testGetRangedInt() {
        SafeInputObj safeInput = new SafeInputObj(new Scanner("15\n"));
        int result = safeInput.getRangedInt("Enter an int between 10 and 20: ", 10, 20);
        assertEquals(15, result);
    }

    @Test
    void testGetYNConfirm() {
        SafeInputObj safeInput = new SafeInputObj(new Scanner("Y\n"));
        boolean result = safeInput.getYNConfirm("Confirm (Y/N): ");
        assertTrue(result);
    }

    @Test
    void testGetRegExString() {
        SafeInputObj safeInput = new SafeInputObj(new Scanner("abc123\n"));
        String result = safeInput.getRegExString("Enter a string matching 'abc\\d{3}': ", "abc\\d{3}");
        assertEquals("abc123", result);
    }




}