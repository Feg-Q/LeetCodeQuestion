package com.feg.huaweiod;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Feg
 * @version 1.0
 */
public class CommunicationErrorDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer[]> hashMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            Integer[] integers = hashMap.get(nums[i]);
            if (integers == null){
                integers = new Integer[3];
                integers[0] = 1;
                integers[1] = i;
            } else {
                integers[0] = integers[0] + 1;
                integers[2] = i;
            }
            hashMap.put(nums[i],integers);
        }
        Set<Map.Entry<Integer, Integer[]>> entries = hashMap.entrySet();
        List<Map.Entry<Integer, Integer[]>> collect = entries.stream().sorted((o1, o2) -> {
            Integer[] value1 = o1.getValue();
            Integer[] value2 = o2.getValue();
            if (!Objects.equals(value1[0], value2[0])) {
                return value2[0] - value1[0];
            } else {
                if (value1[2] - value1[1] < value2[2] - value2[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }).collect(Collectors.toList());
        System.out.println(collect.get(0).getValue()[2] - collect.get(0).getValue()[1] + 1);
    }
}
