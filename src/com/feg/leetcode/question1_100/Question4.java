package leetcode.question1_100;

import java.util.Arrays;

/**
 * @author Feg
 * @version 1.0
 */
public class Question4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] arr = new int[length1+length2];
        int i=0;
        int j=0;
        int k=0;
        while(i<length1&&j<length2){
            if(nums1[i]<nums2[j]){
                arr[k] = nums1[i];
                i++;
            }else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        //System.out.println(i+" "+j);
        if(i<length1&&j==length2){
            for(;i<length1;i++,k++){
                arr[k] = nums1[i];
            }
        }
        if(j<length2&&i==length1){
            for(;i<length1;j++,k++){
                arr[k] = nums2[j];
            }
        }
        //System.out.println(Arrays.toString(arr));
        int count = length1+length2;
        if(count%2==0){
            return (arr[count/2]+arr[count/2+1])/2;
        }else{
            return arr[count/2];
        }
    }
}
