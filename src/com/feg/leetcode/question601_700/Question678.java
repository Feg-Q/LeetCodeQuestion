package leetcode.question601_700;


/**
 * 括号有效的字符串
 * @author Feg
 * @version 1.0
 * 括号类问题一般用栈解决
 *
 * @10.23 没想出来，还是看了题解才理解，还得再想想
 */
public class Question678 {
    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int m = 0,n = 0;
        for (char aChar : chars) {
            if (aChar == '('){
                m++;
                n++;
            } else if (aChar == ')'){
                n--;
                m--;
            } else {
                m--;
                n++;
            }
            if (m < 0){
                m = 0;
            }
            if (m > n){
                return false;
            }
        }
        return m == 0;
    }
}
