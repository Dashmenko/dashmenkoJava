import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void fillNumbersTest() {
        String expression = "32+11*12+1";
        assertEquals(
                "[32, 11, 12, 1]",
                Main.fillNumbers(expression).toString()
        );
    }

    @Test
    void fillSignsTest() {
        String expression = "32+11*12+1";
        assertEquals(
                "[+, *, +]",
                Main.fillSigns(expression).toString()
        );
    }

    @Test
    void operationTest() {
        assertEquals(
                8,
                Main.operation(2, 4, '*')
        );
        assertEquals(
                -2,
                Main.operation(2, -4, '+')
        );
    }

    @Test
    void checkExpressionTest() {
        String expression = "3+2*43";
        Main.checkExpression(expression);
    }
}