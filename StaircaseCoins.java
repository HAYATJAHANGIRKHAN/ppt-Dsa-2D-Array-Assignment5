//You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase **may be** incomplete.
//
//        Given the integer n, return *the number of **complete rows** of the staircase you will build*.
//        **Input:** n = 5
//
//        **Output:** 2
//
//        **Explanation:** Because the 3rd row is incomplete, we return 2.



package ppt_assignment5;

public class StaircaseCoins {
    public static int countCompleteRows(int n) {
        int completeRows = 0;
        int coinsUsed = 0;

        while (coinsUsed <= n) {
            completeRows++;
            coinsUsed += completeRows;
        }

        // If the last row is incomplete, decrement the count
        if (coinsUsed > n) {
            completeRows--;
        }

        return completeRows;
    }

    public static void main(String[] args) {
        int n = 5;
        int result = countCompleteRows(n);
        System.out.println("Number of complete rows: " + result);
    }
}
