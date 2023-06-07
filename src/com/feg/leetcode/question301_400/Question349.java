package com.feg.leetcode.question301_400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/27 11:43
 */
public class Question349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = Arrays.stream(nums1).collect(HashSet::new, Set::add, Set::addAll);
        for (int o : hashSet) {
            System.out.println(o);
        }
        return Arrays.stream(nums2).filter(hashSet::contains).distinct().toArray();
    }
}
