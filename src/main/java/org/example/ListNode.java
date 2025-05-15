package org.example;

import java.util.ArrayList;
import java.util.Arrays;

/// @author Prateek Kumar
/// @Created: 14-May, 2025

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int ...num) {
        val = num[0];
        ListNode ptr = this;
        for(int i=1; i<num.length; i++){
            ptr.next = new ListNode(num[i]);
            ptr = ptr.next;
        }
    }

    public int[] asArray() {
        ListNode li = this;
        ArrayList<Integer> arr = new ArrayList<>();
        while(li.next!=null){
            arr.add(li.val);
            li = li.next;
        }

        arr.add(li.val);
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public String toString() {
        return Arrays.toString(asArray());
    }
}
