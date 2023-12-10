// import java.util.*;

// public class p137 {
//     public static int uniquePaths_With_obstcle_Grid(int[][] obstacle_Grid) {
//         int m = obstacle_Grid.length;
//         if (m <= 0) {
//             return 0;
//         }
        
//         int n = obstacle_Grid[0].length;
//         if (n <= 0) {
//             return 0;
//         }

//         int[][] dp = new int[m][n];
//         if (obstacle_Grid[m-1][n-1] == 0) {
//             dp[m-1][n-1] = 1;
//         }

//         for (int i = m - 1; i >= 0; --i) {
//             for (int j = n - 1; j >= 0; --j){
//                 if (obstacle_Grid[i][j] == 0) {
//                     if (i + 1 < m) {
//                         dp[i][j] += dp[i + 1][j];
//                     }
//                     if (j + 1 < n) {
//                         dp[i][j] += dp[i][j + 1];
//                     }
//                 }
//             }
//         }
//         return dp[0][0];
//     }
//     public static void main(String[] args) {
//         int[][] obstacle_Grid = {
//             {0, 0, 0}, 
//             {0, 1, 0}, 
//             {0, 0, 0}, 
//         };
//         System.out.println("Unique paths from top-left corner to bottom-right corner of the said grid ( considerring some obstacle ): " + uniquePaths_With_obstcle_Grid(obstacle_Grid));
//     }
// }
