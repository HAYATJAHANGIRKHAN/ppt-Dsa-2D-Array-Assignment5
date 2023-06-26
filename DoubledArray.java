//An integer array original is transformed into a **doubled** array changed by appending **twice the value** of every element in original, and then randomly **shuffling** the resulting array.
//
//        Given an array changed, return original *if* changed *is a **doubled** array. If* changed *is not a **doubled** array, return an empty array. The elements in* original *may be returned in **any** order*.
//
//        **Example 1:**
//
//        **Input:** changed = [1,3,4,2,6,8]
//
//        **Output:** [1,3,4]
//
//        **Explanation:** One possible original array could be [1,3,4]:
//
//        - Twice the value of 1 is 1 * 2 = 2.
//        - Twice the value of 3 is 3 * 2 = 6.
//        - Twice the value of 4 is 4 * 2 = 8.
//
//        Other original arrays could be [4,3,1] or [3,1,4].


package ppt_assignment5;

import java.util.*;


public class DoubledArray {

    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // If the length is odd, it can't be a doubled array
        }

        int[][] countArray = new int[2][100001]; // Assuming the values in the array are within the range [1, 100000]

        for (int num : changed) {
            countArray[0][num]++; // Increment count for the number
        }

        Arrays.sort(changed); // Sort the changed array

        List<Integer> originalList = new ArrayList<>();
        for (int num : changed) {
            if (countArray[0][num] == 0) {
                continue; // Skip if the number has already been used
            }

            int doubleNum = num * 2;
            if (doubleNum >= countArray[1].length || countArray[0][doubleNum] == 0) {
                return new int[0]; // If the doubled number is not present, it's not a valid doubled array
            }

            originalList.add(num); // Add the original number to the list
            countArray[0][num]--; // Decrement count for original number
            countArray[0][doubleNum]--; // Decrement count for doubled number
        }

        int[] originalArray = new int[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            originalArray[i] = originalList.get(i);
        }

        return originalArray;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = findOriginalArray(changed);
        System.out.println(Arrays.toString(original));
    }
}

