package leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 * 反思：处理边界问题用了太多时间，时间复杂度有点高了
 */
public class Question63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 起点或终点有障碍物直接返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        // 初始化dp数组
        int[][] dpTable = new int[m][n];
        // 给最左边和最上边赋初始值
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            dpTable[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1){
                break;
            }
            dpTable[0][i] = 1;
        }
        return dp(obstacleGrid,dpTable,m - 1,n - 1);
    }
    public int dp(int[][] obstacleGrid,int[][] dpTable, int m, int n){
        // 有障碍物直接返回0
        if (obstacleGrid[m][n] == 1) {
            return 0;
        }
        // 到达边界，返回初始值
        if (m == 0 || n == 0){
            return dpTable[m][n];
        }
        // 以前计算过，直接返回
        if (dpTable[m][n] != 0){
            return dpTable[m][n];
        }
        // 状态转移
        dpTable[m][n] = dp(obstacleGrid, dpTable, m-1, n) + dp(obstacleGrid, dpTable, m, n - 1);
        return dpTable[m][n];
    }
}
