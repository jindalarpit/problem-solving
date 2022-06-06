package com.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 */
public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);
        for (int[] ints : result) {
            System.out.println(ints[0] + "," + ints[1]);
        }
    }

    private static int[][] merge(int[][] intervals) {
        if(intervals==null)
            return new int[][]{};
        if(intervals.length==1){
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] current = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int currEnd = current[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if(currEnd >= nextStart){
                current[1] = Math.max(nextEnd,currEnd);
            } else {
                result.add(current);
                current = intervals[i];
            }
            if(i==intervals.length-1){
                result.add(current);
            }

        }
        return result.toArray(new int[result.size()][2]);
    }
}
