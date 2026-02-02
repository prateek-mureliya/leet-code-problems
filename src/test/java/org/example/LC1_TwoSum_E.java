package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

/// `Array` `Hash Table`
///
/// LeetCode Problem 1: Two Sum
///
/// Given an array of integers `nums` and an integer `target`,
/// return indices of the two numbers such that they add up to `target`.
///
/// You may assume that each input would have exactly one solution, and you may not use the same element twice.
/// You can return the answer in any order.
///
/// **Follow-up:** Can you come up with an algorithm that is less than O(n<sup>2</sup>) time complexity?
///
/// **Example 1:**
/// ```
/// Input: nums = [2,7,11,15], target = 9
/// Output: [0,1]
/// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
/// ```
/// **Example 2:**
/// ```
/// Input: nums = [3,2,4], target = 6
/// Output: [1,2]
/// Explanation: Because nums[1] + nums[2] == 6, we return [1, 2].
/// ```
/// **Example 3:**
/// ```
/// Input: nums = [3,3], target = 6
/// Output: [0,1]
/// Explanation: Because nums[0] + nums[1] == 6, we return [0, 1].
/// ```
///
/// @author Prateek Kumar
/// @Created: 13-May, 2025

class LC1_TwoSum_E {
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

    @ParameterizedTest
    @MethodSource("test_cases")
    @DisplayName("Approach 2: Hash Table")
    public void test_approach_2(int[] nums, int target, int[] expected) {
        int[] actual = approach_2_hash_table(nums, target);
        Assertions.assertArrayEquals(expected, actual);
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

    @Disabled
    @ParameterizedTest
    @MethodSource("test_cases")
    @DisplayName("Practice")
    public void test_practice(int[] nums, int target, int[] expected) {
        int[] actual = practice(nums, target);
        Assertions.assertArrayEquals(expected, actual);
    }
    public int[] practice(int[] nums, int target) {
        return null;
    }
}