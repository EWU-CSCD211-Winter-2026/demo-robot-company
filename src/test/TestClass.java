
package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    private int baseValue;

    @BeforeEach
    void setUp() {
        // Runs BEFORE each test method
        // Used to reset shared state so tests don't affect each other
        baseValue = 5;
    }

    @Test
    void simpleTest() {
        // A basic unit test using an assertion
        int expected = 5;
        int actual = baseValue;

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 5, 5})
    void parameterizedSingleValueTest(int value) {
        // Runs the same test multiple times with different inputs
        // Here it will run once for each value in ValueSource
        assertEquals(baseValue, value);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "1, 4, 5",
        "0, 4, 5"
    })
    void csvParameterizedTest(int a, int b, int expected) {
        // CSV parameterized test:
        // Each row is one test case with multiple arguments
        int actual = a + b;
        assertEquals(expected, actual);
    }
}
