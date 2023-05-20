package leetcode.question501_600;

/**
 * @author Feg
 * @version 1.0
 */
public class Question557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new Question557().reverseWords(s));
    }
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            int left = 0;
            int right = chars.length-1;
            while (left<right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            //System.out.println(new String(chars));
            stringBuffer.append(new StringBuffer(new String(chars))+" ");
        }
        return stringBuffer.substring(0,1);
    }
}
