package com.feg.newcoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Feg
 * @version 1.0
 */
public class HJ60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = (n/2);
        for(;i>1;i--){
            if(isSu(i) && isSu(n - i)){
                break;
            }
        }
        System.out.println(i);
        System.out.println(n-i);
    }
    public static boolean isSu(int num){
        if(num == 2){
            return true;
        }
        if(num % 2 == 0){
            return false;
        }
        for(int i=(int)Math.sqrt(num);i>1;i--){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
