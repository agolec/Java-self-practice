package ope.MajorityElement;

import java.util.Arrays;
import java.util.Collections;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
 */
public class MajorityElement {
    public static void main(String[] args){
        int[] array1 = {3,2,3};
        int[] array2 = {2,2,1,1,1,2,2};
        int[] array3 = {3,3,4,2,4,4,2,4,4};
        Solution lol = new Solution();
        System.out.println(lol.majorityElement(array1));
        System.out.println(lol.majorityElement(array2));
        System.out.println(lol.majorityElement(array3));
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        final int MIDDLE_INDEX = nums.length / 2;
        Arrays.sort(nums);
        return nums[MIDDLE_INDEX];
    }
}
