package com.feg.huaweiod;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Feg
 * @version 1.0
 */
public class StringResort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : inputArray) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String valueOf = String.valueOf(chars);
            if (hashMap.containsKey(valueOf)){
                hashMap.put(valueOf,hashMap.get(valueOf) + 1);
            }else {
                hashMap.put(valueOf,1);
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        List<Map.Entry<String, Integer>> entryList = entrySet.stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (!o1.getValue().equals(o2.getValue())) {
                    return o2.getValue() - o1.getValue();
                } else if (o1.getKey().length() != o2.getKey().length()) {
                    return o2.getKey().length() - o1.getKey().length();
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        }).collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> stringIntegerEntry : entryList) {
            Integer value = stringIntegerEntry.getValue();
            String key = stringIntegerEntry.getKey();
            for (int i = 0; i < value; i++) {
                stringBuilder.append(key).append(" ");
            }
        }
        System.out.println(stringBuilder.toString().substring(0,stringBuilder.length()-1));
    }
}
