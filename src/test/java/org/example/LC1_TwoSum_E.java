package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

/// @author Prateek Kumar
/// @Created: 13-May, 2025

class LC1_TwoSum_E {
    public int[] approach_1_brute_force(int[] nums, int target) {
        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] approach_2_hash_table(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    private static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of(new int[]{2,7,11,15}, 9, new int[]{0,1}),
                Arguments.of(new int[]{3,2,4}, 6, new int[]{1,2}),
                Arguments.of(new int[]{3,3}, 6, new int[]{0,1})
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    @DisplayName("Approach 1: Brute Force")
    public void test_approach_1(int[] nums, int target, int[] expected) {
        int[] actual = approach_1_brute_force(nums, target);
        Assertions.assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    @DisplayName("Approach 2: Hash Table")
    public void test_approach_2(int[] nums, int target, int[] expected) {
        int[] actual = approach_2_hash_table(nums, target);
        Assertions.assertArrayEquals(expected, actual);
    }
}