package org.example;

import java.util.HashMap;
import java.util.Map;

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
}
