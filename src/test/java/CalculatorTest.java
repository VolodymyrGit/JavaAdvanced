import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CalculatorTest {
    private Calculator calculator = new Calculator();
    @BeforeEach
    void setUp() {
        Calculator.counter = 0;
    }

    @Test
    void sum() {
        System.out.println(Calculator.counter);
        int actualResult = calculator.sum(1, 1);
        int expectedResult = 2;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void div() {
        System.out.println(Calculator.counter);
        try {
            double actual = calculator.div(10, 5);
            assertEquals(2, actual);
            assertNotEquals(3, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void divZero() {
        System.out.println(Calculator.counter);
        try {
            calculator.div(1, 0);
        } catch (Exception e) {
            return;
        }
        fail();
    }
}