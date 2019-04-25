package middle.动态规划;

/**
 * @author caoyixiong
 * @Date: 2019/4/24
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 */
public class 最小路径和 {
    public int minPathSum(int[][] grid) {
        int[] a = grid[0];
        int b = grid.length;
        int c = a.length;
        int dp[][] = new int[b][c];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < b; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < c; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < b; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[b - 1][c - 1];
    }
}
