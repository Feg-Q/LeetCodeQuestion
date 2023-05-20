package leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 */
public class Question13 {
    //没写完
    public int romanToInt(String s) {
        int result = 0;
        char temp = ' ';
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            temp = charArray[i];
            if ('I'==temp){
                result+=1;
            }else if ('V'==temp){
                result+=5;
            }else if ('X'==temp){
                result+=10;
            }else if ('L'==temp){
                result+=50;
            }else if ('C'==temp){
                result+=100;
            }else if ('D'==temp){
                result+=500;
            }else if ('M'==temp){
                result+=1000;
            }
        }
        return 0;
    }
}
