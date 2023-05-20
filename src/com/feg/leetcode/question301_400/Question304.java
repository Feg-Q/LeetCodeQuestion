package leetcode.question301_400;

/**
 * @author Feg
 * @version 1.0
 * 二维数组的子矩阵和
 */
public class Question304 {
}
class NumMatrix {
    private int[][] preSum;
    public NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length+1][matrix[0].length+1];
        preSum[0][0] = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                preSum[i][j] = preSum[i][j-1] + preSum[i-1][j] + matrix[i-1][j-1] - preSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
    }
}
