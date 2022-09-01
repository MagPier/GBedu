package Part3.Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static Part3.Lesson6.Main.method1;
import static Part3.Lesson6.Main.method2;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {




    @Test
    void test1Method1() {
        Assertions.assertEquals(Arrays.toString(new int[]{1, 5}), Arrays.toString(method1(new int[]{1, 5, 6, 3, 4, 1, 5})));
    }



    @Test
    void testMethod1exception() {
        Assertions.assertThrows(RuntimeException.class,()  -> method1(new int[] {1,2,3,5,6,7}));
    }

    @ParameterizedTest
    @MethodSource("data")
    void paramTestMethod1( int[] expected, int[] input){
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(method1(input)));
    }
    static Stream<Arguments> data(){
        return Stream.of(Arguments.arguments(new int[]{1, 5},new int[]{1, 5, 6, 3, 4, 1, 5}),
                Arguments.arguments(new int[]{2,3},new int[]{1, 5, 6, 3, 4, 2,3}),
                Arguments.arguments(null,new int[]{1, 5, 6, 3, 4, 1, 4}));
    }

    @ParameterizedTest
    @MethodSource("data1")
    void paramTestMethod2( boolean expected, int[] input){
        Assertions.assertEquals(expected, method2(input));
    }
    static Stream<Arguments> data1(){
        return Stream.of(Arguments.arguments(false,new int[]{4, 4, 4, 4, 4, 4, 4}),
                Arguments.arguments(false,new int[]{1, 1, 1, 1, 1, 1,1}),
                Arguments.arguments(true,new int[]{1, 1, 4, 1, 1, 1, 1}));
    }

}