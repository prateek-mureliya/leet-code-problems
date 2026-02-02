package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/// `Hash Table` `String` `Sliding Window`
///
/// LeetCode Problem 3: Longest Substring Without Repeating Characters
///
/// Given a string `s`, find the length of the longest `substring` without duplicate characters.
/// **Constraints:** `s` consists of English letters, digits, symbols and spaces.
///
/// **Example 1:**
/// ```
/// Input: s = "abcabcbb"
/// Output: 3
/// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
/// ```
/// **Example 2:**
/// ```
/// Input: s = "bbbbb"
/// Output: 1
/// Explanation: The answer is "b", with the length of 1.
/// ```
/// **Example 3:**
/// ```
/// Input: s = "pwwkew"
/// Output: 3
/// Explanation: The answer is "wke", with the length of 3.
/// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
/// ```
///
/// @author Prateek Kumar
/// @Created: 14-May, 2025

public class LC3_LongestSubstringWithoutRepeatingCharacters_M {
    private static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of(" ", 1),
                Arguments.of("     ", 1),
                Arguments.of("a", 1),
                Arguments.of("au", 2),
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("IUSKJSDNMRXWYUQONM562762109SANBSAHGFBNGSERFSAKMJfdgah", 13)
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    @DisplayName("Approach 1: Brute Force")
    public void test_approach_1(String s, int expected) {
        int actual = approach_1_brute_force(s);
        Assertions.assertEquals(expected, actual);
    }
    public int approach_1_brute_force(String s) {
        int length = 0;
        char[] charArray = s.toCharArray();
        for(int i=0; i<=charArray.length-1; i++){
            Set<Character> characters = new HashSet<>();
            characters.add(charArray[i]);

            for(int j=i+1; j<charArray.length; j++){
                if(characters.contains(charArray[j])) break;
                else characters.add(charArray[j]);
            }

            length= Math.max(characters.size(), length);
        }
        return length;
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    @DisplayName("Approach 1: Using Hash Map")
    public void test_approach_2(String s, int expected) {
        int actual = approach_2_hashMapCache(s);
        Assertions.assertEquals(expected, actual);
    }
    public int approach_2_hashMapCache(String s) {
        char[] arr = s.toCharArray();
        int length=0;
        Map<Character, Integer> cache = new HashMap<>();
        for (int start=0, end=0; end< arr.length; end++){
            char chr = s.charAt(end);
            start = (cache.containsKey(chr)) ? Math.max(start, cache.get(chr)) : start;
            cache.put(chr, end + 1);
            length = Math.max(length, end - start + 1);
        }
        return length;
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    @DisplayName("Approach 1: Using int[256] array")
    public void test_approach_3(String s, int expected) {
        int actual = approach_3_arrayCache(s);
        Assertions.assertEquals(expected, actual);
    }
    public int approach_3_arrayCache(String s) {
        char[] arr = s.toCharArray();
        int length=0;
        int[] cache = new int[256];
        for (int start=0, end=0; end< arr.length; end++){
            char chr = s.charAt(end);
            start = (cache[chr] > 0) ? Math.max(start, cache[chr]) : start;
            cache[chr] = end + 1;
            length = Math.max(length, end - start + 1);
        }
        return length;
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("test_cases")
    @DisplayName("Practice")
    public void test_practice(String s, int expected) {
        int actual = practice(s);
        Assertions.assertEquals(expected, actual);
    }
    public int practice(String s) {
        return 0;
    }
}
