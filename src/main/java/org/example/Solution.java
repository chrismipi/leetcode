package org.example;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int key = target - nums[i];
            int value = nums[i];

            Integer y = indices.get(value);

            if (y != null) {
                if (key + value == target) {
                    return new int[]{y, i};
                }
            }

            indices.put(key, i);
        }

        return new int[] {0, 0};
    }

    public int romanToInt(String s) {
        Map<String, Integer> data = Map.of(
                "I", 1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D", 500,
                "M",1000
        );

        char[] characters = s.toCharArray();
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += data.get(String.valueOf(characters[i]));
        }

        return total;
    }

    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int number = Math.abs(x);
        int results = 0;
        while(number > 0) {
            int digit = number % 10;
            number = number / 10;

            if (results > Integer.MAX_VALUE / 10) {
                return 0;
            }

            if (results < Integer.MIN_VALUE / 10) {
                return 0;
            }

            results = results * 10 + digit;
        }

        return sign * results;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;
        int size = nums1.length + nums2.length;

        int[] numbers = new int[size];
        int i = 0;

        for (; i < nums1.length; i++) {
            numbers[i] = nums1[i];
        }

        for (; i < numbers.length; i++) {
            numbers[i] = nums2[i - nums1.length];
        }

        Arrays.sort(numbers);

        if (size % 2 == 0) {
            int left = (numbers[(size/2) - 1]);
            int right = (numbers[size/2]);

            if (left != 0 && right != 0) {
                median = (left + right) / 2.0;
            }

        } else {
            median = numbers[(size - 1)/2];
        }

        return median;
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);

        Set<Integer> repeatedValues = new HashSet<>();
        int missing = 0;
        int repeated = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (!numbers.contains(grid[i][j])) {
                    missing = grid[i][j];
                }


            }
        }

        return new int[]{missing, repeated};
    }
}
