package com.feg.leetcode.question601_700;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Feg
 * @createDate 2024/11/24 09:54
 * @description
 */
public class Question632 {

    public static void main(String[] args) {
        int[] input1 = {4,10,15,24,26};
        int[] input2 = {0,9,12,20};
        int[] input3 = {5,18,22,30};
        ArrayList<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.stream(input1).boxed().collect(Collectors.toList()));
        input.add(Arrays.stream(input2).boxed().collect(Collectors.toList()));
        input.add(Arrays.stream(input3).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.toString(new Question632().smallestRange(input)));
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        TreeMap<int[], Integer> treeMap = new TreeMap<>((o1, o2) -> {
            // 这里有个关键，默认情况下如果两个元素的比较值为0，TreeMap会丢弃新的元素，因此这里需要改返回值让其可以添加
            return o1[0] - o2[0] == 0 ? 1 : o1[0] - o2[0];
        });
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> numIndex = nums.get(i);
            for (Integer index : numIndex) {
                treeMap.put(new int[]{index, i}, i);
            }
        }
        List<Integer> values = new ArrayList<>(treeMap.values());
        List<int[]> keyList = new ArrayList<>(treeMap.keySet());
        int[] result = new int[]{-1, 100000};
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < values.size()) {
            Integer rightValue = values.get(right);
            // 如果这个数字是第一次出现，则直接添加
            map.put(rightValue, map.get(rightValue) == null ? 1 : map.get(rightValue) + 1);
            // 添加完之后，判断当前是否已经满足所有的元素都出现过
            if (map.keySet().size() == nums.size()) {
                // 如果都出现过，则·
                Integer leftValue = values.get(left);
                while (map.get(leftValue) > 1) {
                    left++;
                    map.put(leftValue, map.get(leftValue) - 1);
                    leftValue = values.get(left);
                }
                // 这个时候一定是符合要求的区间，因为上面循环没有进去，所以要再次计算
                int[] rightInt = keyList.get(right);
                int[] leftInt = keyList.get(left);
                if (rightInt[0] - leftInt[0] < result[1] - result[0]) {
                    result[0] = leftInt[0];
                    result[1] = rightInt[0];
                }
            }
            right++;
        }
        return result;
    }
}
