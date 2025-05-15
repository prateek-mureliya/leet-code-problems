package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
}
