package com.problems.java;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */

public class ArrayRotation {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        for (int i=0; i<nums.length;i++)
        System.out.print(nums[i] + ", ");
    }

    public static void rotate(int[] nums, int k) {
        if(nums==null || k<0){
            throw new IllegalArgumentException("Incorrect Arguments");
        }
        k = k%nums.length; // when k is greater than nums.length
        int a = nums.length - k;
        System.out.println("a: " + a);
        reverse(nums,0,a-1);
        reverse(nums, a,nums.length-1);
        reverse(nums,0,nums.length-1);

    }
    private static void reverse(int[] nums, int left, int right) {
        System.out.println("left: " + left + " right: " + right);
        if(nums==null || nums.length<=1){
            return;
        }
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
