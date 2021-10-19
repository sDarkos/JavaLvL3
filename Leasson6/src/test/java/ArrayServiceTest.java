import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayServiceTest {

    private static Stream<Arguments> valuesForSuccessfulReturnValuesAfterLastFour (){
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{5, 6, 7, 8, 9}),
                Arguments.of(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{1, 4, 5, 5, 4, 1}, new int[]{1}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }

    private static Stream<Arguments> valuesForSuccessfulCheckArraysForOneAndFour (){
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, true),
                Arguments.of(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, true),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 7, 8, 9}, false),
                Arguments.of(new int[]{1, 4, 5, 5, 4, -1}, true),
                Arguments.of(new int[]{}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("valuesForSuccessfulReturnValuesAfterLastFour")
    void shouldReturnValuesAfterLastFour_ValidDataReturns(int[] sourceArray, int[] expectedArray){
        Assertions.assertArrayEquals(expectedArray, ArrayService.getValueAfterLastNumberFour(sourceArray));
    }

    @ParameterizedTest
    @MethodSource("valuesForSuccessfulCheckArraysForOneAndFour")
    void shouldCheckArrayForOneAndFour_ValidBooleanDataReturns(int[] sourceArray, boolean itsTrue){
        Assertions.assertEquals(itsTrue, ArrayService.checkArrayForOneAndFour(sourceArray));
    }

}
