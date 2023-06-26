//Given an integer array nums sorted in **non-decreasing** order, return *an array of **the squares of each number** sorted in non-decreasing order*.
//
//        **Example 1:**
//
//        **Input:** nums = [-4,-1,0,3,10]
//
//        **Output:** [0,1,9,16,100]
//
//        **Explanation:** After squaring, the array becomes [16,1,0,9,100].
//
//        After sorting, it becomes [0,1,9,16,100].


package ppt_assignment5;
import java.util.Arrays;
public class SquaringNonDecreasingArray {

        public static void main(String[] args) {
            int[] nums = {-4, -1, 0, 3, 10};
            int[] result = sortedSquares(nums);
            System.out.println(Arrays.toString(result));
        }

        public static int[] sortedSquares(int[] nums) {
            int[] squares = new int[nums.length];
            int left = 0;
            int right = nums.length - 1;
            int index = nums.length - 1;

            while (left <= right) {
                int leftSquare = nums[left] * nums[left];
                int rightSquare = nums[right] * nums[right];

                if (leftSquare > rightSquare) {
                    squares[index] = leftSquare;
                    left++;
                } else {
                    squares[index] = rightSquare;
                    right--;
                }
                index--;
            }

            return squares;
        }
    }


