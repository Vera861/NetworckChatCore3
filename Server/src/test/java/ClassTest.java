import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ClassTest {

    MainApp classTest;

    @BeforeEach
    void setUp() {
        classTest = new MainApp();
    }

    private static Stream<Arguments> dataForTestOk() {
        List<Arguments> enterArr = new ArrayList<>();
        enterArr.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}));
        enterArr.add(Arguments.arguments(new int[]{1, 2, 4, 5, 2, 4, 9, 5, 3}, new int[]{9, 5, 3}));
        enterArr.add(Arguments.arguments(new int[]{1, 2, 3, 5, 2, 3, 2, 4, 7}, new int[]{7}));
        enterArr.add(Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 4, 7, 8}, new int[]{7, 8}));
        return enterArr.stream();
    }

    private static Stream<Arguments> dataForTestNotOk() {
        List<Arguments> enterArr = new ArrayList<>();
        enterArr.add(Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{3, 4}));
        enterArr.add(Arguments.arguments(new int[]{1, 1, 3}, new int[]{5, 3, 2}));
        return enterArr.stream();
    }

    private static Stream<Arguments> argForCounterOneFour() {
        List<Arguments> enterArr = new ArrayList<>();
        enterArr.add(Arguments.arguments(new int[]{1, 4, 4, 4, 1}, true));
        enterArr.add(Arguments.arguments(new int[]{1, 1, 1, 1}, false));
        enterArr.add(Arguments.arguments(new int[]{1, 2, 3, 5, 2, 3, 2, 4, 7}, false));
        enterArr.add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
        enterArr.add(Arguments.arguments(new int[]{4, 4, 1, 4}, false));
        return enterArr.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForTestOk")
    void copyArrTrue(int[] array, int[] result) {
        Assertions.assertArrayEquals(result, classTest.copyArray(array));
    }

    @ParameterizedTest
    @MethodSource("dataForTestNotOk")
    void copyArrFalse(int[] array, int[] result) {
        Assertions.assertThrows(RuntimeException.class, () -> classTest.copyArray(array));
    }

    @ParameterizedTest
    @MethodSource("argForCounterOneFour")
    void countOneFour(int[] array, boolean result) {
        Assertions.assertEquals(result, classTest.counterOneFour(array));
    }
}
