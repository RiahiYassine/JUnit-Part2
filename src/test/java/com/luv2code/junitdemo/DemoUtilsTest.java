package com.luv2code.junitdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;


/*
  Specifies the strategy used to determine the execution order of test methods in this class.
  Available MethodOrderer options include:
    - MethodOrderer.Random: Useful for detecting unintended dependencies between tests.
    - MethodOrderer.DisplayName: Executes tests in alphabetical order based on their @DisplayName values.
    - MethodOrderer.MethodName: Executes tests in alphabetical order based on method names.
    - MethodOrderer.OrderAnnotation: Executes tests based on the @Order annotation value.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
class DemoUtilsTest {


    // Declaration of the demoUtils variable of type DemoUtils. This variable will hold the instance of DemoUtils that is used in tests
    DemoUtils demoUtils;

    @BeforeEach
    void setUpBeforeEach(){
        // Create a new DemoUtils instance for each test to ensure a clean state and prevent cross-test side effects
        demoUtils = new DemoUtils();
    }

    @DisplayName("Multiply")
    @Test
    void testMultiply() {
        assertEquals(12, demoUtils.multiply(4, 3), "4*3 must be 12");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    @Order(1)
    void testEqualsAndNotEquals() {
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    @Order(0)
    void testNullAndNotNull() {
        String str2 = "Not Null";
        assertNull(demoUtils.checkNull(null), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @DisplayName("Same and Not Same")
    @Test
    void testSameAndNotSame() {
        String str = "bye";
        assertSame(demoUtils.getGreeting(), demoUtils.getGreetingDuplicated(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getGreeting(), "Objects should not refer to same object");
    }

    @DisplayName("True and False")
    @Test
    @Order(30)
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;
        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @DisplayName("Array Equals")
    @Test
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
    }

    @DisplayName("Iterable equals")
    @Test
    void testIterableEquals() {
        List<String> theList = List.of("eat", "sleep", "code","repeat");
        assertIterableEquals(theList, demoUtils.getWordsInQuote(), "Expected list should be same as actual list");
    }

    @DisplayName("Lines match")
    @Test
    @Order(50)
    void testLinesMatch() {
        List<String> theList = List.of("eat", "sleep", "code","repeat");
        assertLinesMatch(theList, demoUtils.getWordsInQuote(), "Lines should match");
    }

    @DisplayName("Throws and Does Not Throw")
    @Test
    void testThrowsAndDoesNotThrow() {
        assertThrows(IllegalArgumentException.class, () -> demoUtils.throwException(-1), "Should throw exception");
        assertDoesNotThrow(() -> demoUtils.throwException(5), "Should not throw exception");
    }

    @DisplayName("Timeout")
    @Test
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout(), "Method should execute in 3 seconds");
    }

    @DisplayName("Test isEven")
    @ParameterizedTest(name = "isEven({0})")
    @ValueSource(ints = {2,4,6,16,0,-48})
    void testEven(int a){
        assertTrue(demoUtils.isEven(a),
                () -> String.format("Expected isEven(%d) to return true", a) );
    }

}