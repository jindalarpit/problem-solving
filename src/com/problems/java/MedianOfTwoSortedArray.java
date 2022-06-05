package com.problems.java;
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthN1 = nums1.length;
        int lengthN2 = nums2.length;
        int[] tempArray = new int[lengthN1+lengthN2];
        int i=0;
        int j=0;
        int k=0;
        while(i<lengthN1 && j<lengthN2){
            if (nums1[i]<nums2[j]){
                tempArray[k] = nums1[i];
                i++;
                k++;
            } else {
                tempArray[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(i<lengthN1){
            tempArray[k] = nums1[i];
            i++;
            k++;
        }
        while(j<lengthN2){
            tempArray[k] = nums2[j];
            j++;
            k++;
        }
        if((lengthN1+lengthN2)%2==0){

            int x=(lengthN1+lengthN2)/2;
            double result = ((tempArray[x] + tempArray[x-1])/2.0) ;
            return result;
        } else {
            return tempArray[(lengthN1+lengthN2-1)/2];
        }
    }

}
