package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/// `Linked List` `Math` `Recursion`
///
/// LeetCode Problem 2: Add Two Numbers
///
/// You are given two **non-empty** linked lists representing two non-negative integers.
/// The digits are stored in **reverse order**, and each of their nodes contains a single digit.
/// Add the two numbers and return the sum as a linked list.
///
/// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
/// **Example 1:**
/// ```
/// Input: l1 = [2,4,3], l2 = [5,6,4]
/// Output: [7,0,8]
/// Explanation: 342 + 465 = 807
/// ```
/// **Example 2:**
/// ```
/// Input: l1 = l1 = [0], l2 = [0]
/// Output: [0]
/// Explanation: 0 + 0 = 0
/// ```
/// **Example 3:**
/// ```
/// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
/// Output: [8,9,9,9,0,0,0,1]
/// Explanation: 9999999 + 9999 = 10009998
/// ```
///
/// @author Prateek Kumar
/// @Created: 14-May, 2025

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *     ListNode(int ...num) {...}
 * }
 */
public class LC2_AddTwoNumbers_M {
    private static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of(new ListNode(0), new ListNode(0), new ListNode(0)),
                Arguments.of(new ListNode(3), new ListNode(2), new ListNode(5)),
                Arguments.of(new ListNode(7), new ListNode(5), new ListNode(2,1)),
                Arguments.of(new ListNode(5,9), new ListNode(8), new ListNode(3,0,1)),
                Arguments.of(new ListNode(9), new ListNode(8,9), new ListNode(7,0,1)),
                Arguments.of(new ListNode(9,9,9,9), new ListNode(9,9), new ListNode(8,9,0,0,1))
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    @DisplayName("Approach 1: Brute Force")
    public void test_approach_1(ListNode l1, ListNode l2, ListNode expected) {
        ListNode actual = approach_1_brute_force(l1, l2);
        Assertions.assertArrayEquals(expected.asArray(), actual.asArray());
    }
    public ListNode approach_1_brute_force(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode ptr = result;
        int carry = 0;
        while(l1!=null || l2!=null || carry>0){
            int addition = carry;
            if(l1!=null) {
                addition+=l1.val;
                l1 = l1.next;
            }

            if(l2!=null) {
                addition+=l2.val;
                l2 = l2.next;
            }
            carry = addition/10;
            ptr.next = new ListNode(addition%10);
            ptr = ptr.next;
        }
        return result.next;
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("test_cases")
    @DisplayName("Practice")
    public void test_practice(ListNode l1, ListNode l2, ListNode expected) {
        ListNode actual = practice(l1, l2);
        Assertions.assertArrayEquals(expected.asArray(), actual.asArray());
    }
    public ListNode practice(ListNode l1, ListNode l2) {
        return null;
    }
}
