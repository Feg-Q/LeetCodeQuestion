package leetcode.question401_500;


/**
 * 分割等和子集（背包问题）
 * @author Feg
 * @version 1.0
 */
public class Question416 {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] dpTable = new boolean[length + 1][sum + 1];
        // 初始化dp数组，第一列都是true
        for (int i = 0; i < length; i++) {
            dpTable[i][0] = true;
        }
        // 这里注意i从1开始，1就表示第一行，为什么从1开始，因为有i-1存在，防止越界
        //所以取数组的值的时候要取nums[i-1]
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                // 第i个数比总和j都大，说明这个数必定放不进去，所以和上面一个一样
                if (j - nums[i-1] < 0){
                    dpTable[i][j] = dpTable[i-1][j];
                } else {
                    dpTable[i][j] = dpTable[i-1][j] || dpTable[i-1][j - nums[i-1]];
                }
            }
        }
        return dpTable[length][sum/2];
    }
    public boolean canPartition2(int[] nums) {
        // 仅讨论将dp数组压缩成一维数组
        int length = 4;
        int sum = 22;
        int mid = sum / 2;
        boolean[] dpTable = new boolean[mid + 1];
        dpTable[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = mid; j >= 0; j--) {
                if (j - nums[i] >= 0){
                    // 原本此位置的||符号两边的数组值的层都是i-1，即上一层，且不大于当前列，换句话说，都是在左上角，
                    //则得到的值可以直接赋给上一行的这一列（上一行的这一列往后的列都不会再用到），
                    //反过来就是把上一行的值都复制到这一行，因此一直共用一行数组，这时j要从最右边开始遍历。
                    dpTable[j] = dpTable[j] || dpTable[j - nums[i]];
                }
            }
        }
        return dpTable[mid];
    }
}
