//Given two **0-indexed** integer arrays nums1 and nums2, return *a list* answer *of size* 2 *where:*
//
//        - answer[0] *is a list of all **distinct** integers in* nums1 *which are **not** present in* nums2*.*
//        - answer[1] *is a list of all **distinct** integers in* nums2 *which are **not** present in* nums1.
//
//        **Note** that the integers in the lists may be returned in **any** order.
//
//        **Example 1:**
//
//        **Input:** nums1 = [1,2,3], nums2 = [2,4,6]
//
//        **Output:** [[1,3],[4,6]]
//
//        **Explanation:**
//
//        For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
//
//        For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].


package ppt_assignment5;
import java.util.HashSet;
import java.util.Set;
public class DistinctIntegers {

        public static int[][] findDisjointArrays(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for (int num : nums1) {
                set1.add(num);
            }

            for (int num : nums2) {
                set2.add(num);
            }

            int[][] answer = new int[2][];
            answer[0] = getDistinctArray(nums1, set2);
            answer[1] = getDistinctArray(nums2, set1);

            return answer;
        }

        public static int[] getDistinctArray(int[] nums, Set<Integer> set) {
            int count = 0;
            for (int num : nums) {
                if (!set.contains(num)) {
                    count++;
                }
            }

            int[] distinctArray = new int[count];
            int index = 0;
            for (int num : nums) {
                if (!set.contains(num)) {
                    distinctArray[index] = num;
                    index++;
                }
            }

            return distinctArray;
        }

        public static void main(String[] args) {
            int[] nums1 = {1, 2, 3};
            int[] nums2 = {2, 4, 6};
            int[][] result = findDisjointArrays(nums1, nums2);

            for (int[] arr : result) {
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }



