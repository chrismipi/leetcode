package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    final Solution solution;

    public SolutionTest() {
        solution = new Solution();
    }

    @Nested
    class testTwoSum {
        @Test
        public void simple() {
            int[] nums = {2,7,11,15};
            int target = 9;

            int[] result = solution.twoSum(nums, target);

            int[] expected = {0,1};
            assertEquals(expected[0], result[0]);
            assertEquals(expected[1], result[1]);
        }
    }

    @Nested
    class testsRomanToInt {

        @Test
        public void simple() {
            int result = solution.romanToInt("III");

            assertEquals(3, result);
        }

        @Test
        public void medium() {
            int result = solution.romanToInt("MCMXCIV");

            assertEquals(1994, result);
        }
    }

    @Nested
    class testsReverse {
        @Test
        public void simple() {
            int result = solution.reverse(123);

            assertEquals(321, result);
        }

        @Test
        public void medium() {
            int result = solution.reverse(-123);

            assertEquals(-321, result);
        }

        @Test
        public void hard() {
            int result = solution.reverse(120);

            assertEquals(21, result);
        }

        @Test
        public void extraHard() {
            int result = solution.reverse(1463847412);

            assertEquals(2147483641, result);
        }

        @ParameterizedTest
        @ValueSource(ints = {Integer.MAX_VALUE, Integer.MIN_VALUE})
        void testEdges(int x) {
            int result = solution.reverse(x);

            assertEquals(0, result);
        }
    }

}