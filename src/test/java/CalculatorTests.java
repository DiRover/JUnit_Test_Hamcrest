import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculatorTests {

    Calculator calc;

    public static Stream<Arguments> testPlus() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(999, 0, 999)
        );
    }

    public static Stream<Arguments> testDevide() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(16, 2, 8),
                Arguments.of(16, 2, 8),
                Arguments.of(32, 4, 8)
        );
    }

    @BeforeEach
    public void setCalc() {
        System.out.println("calc is set");
        calc = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calc = null;
    }

    @MethodSource
    @ParameterizedTest
    public void testPlus(int a, int b, int expected) {
        // "arrange" not required in parameterized test method

        // act
        int result = calc.plus.apply(a, b);

        // assert
        Assertions.assertEquals(expected, result);

        assertThat(expected, is(result)); //hamcrest

    }

    @MethodSource
    @ParameterizedTest
    public void testDevide(int a, int b, int expected) {
        int result = calc.devide.apply(a, b);

        Assertions.assertEquals(expected, result);

        assertThat(expected, is(result)); //hamcrest

    }

    @Test
    public void testDevideByZero() {
        int a = 2, b = 0;
        ArithmeticException thrown = Assertions.assertThrows(
                ArithmeticException.class,
                () -> calc.devide.apply(a, b)
        );


        assertThat(thrown.getMessage(), is("/ by zero")); //hamcrest


    }
}
