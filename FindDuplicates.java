//Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears **once** or **twice**, return *an array of all the integers that appears **twice***.
//
//        You must write an algorithm that runs in O(n) time and uses only constant extra space.
//
//        **Example 1:**
//
//        **Input:** nums = [4,3,2,7,8,2,3,1]
//
//        **Output:**
//
//        [2,3]


package ppt_assignment5;

import java.util.*;


public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[][] count = new int[nums.length][2];

        for (int num : nums) {
            count[num - 1][0]++;
            if (count[num - 1][0] == 2) {
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);
    }
}

