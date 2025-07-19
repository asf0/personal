import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberEvenTest {
    @Test
    public void testIsNumberEven() {
        assertTrue(NumberUtils.isNumberEven(4));
        assertFalse(NumberUtils.isNumberEven(5));
    }
}
