package com.feg.huaweiod;

import java.util.*;

/**
 * 异常的打卡记录
 * @author Feg
 * @version 1.0
 */
public class RecordException {
    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[][] clock_records = new String[n][];
        for (int i = 0; i < n; i++) {
            clock_records[i] = in.nextLine().split(",");
        }

        // 存放每位员工的打卡记录
        HashMap<String, ArrayList<String[]>> record_map = new HashMap<>();
        TreeSet<Integer> result = new TreeSet<>();

        // 初始化map时实现异常规则1
        for (int i = 0; i < clock_records.length; i++) {
            // 题目要求按输入顺序输出，加一个索引 i
            String[] single_record = Arrays.copyOf(clock_records[i], clock_records[i].length + 1);
            single_record[single_record.length - 1] = i + "";

            if (!single_record[3].equals(single_record[4])) {
                result.add(i);
            } else {
                if (record_map.containsKey(single_record[0])) {
                    record_map.get(single_record[0]).add(single_record);
                } else {
                    record_map.put(single_record[0], new ArrayList<>());
                    record_map.get(single_record[0]).add(single_record);
                }
            }
        }

        // 异常规则2
        for (String id : record_map.keySet()) {
            ArrayList<String[]> records = record_map.get(id);

            // 用打卡时间来排序，以加速后续的双层循环。
            records.sort((a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));

            for (int i = 0; i < records.size(); i++) {
                int time1 = Integer.parseInt(records.get(i)[1]);
                int dist1 = Integer.parseInt(records.get(i)[2]);

                for (int j = i + 1; j < records.size(); j++) {
                    int time2 = Integer.parseInt(records.get(j)[1]);
                    int dist2 = Integer.parseInt(records.get(j)[2]);

                    // 如果当前的两次打卡时间超过60分, 那么后面的肯定也超过60分钟了
                    if (time2 - time1 >= 60) {
                        break;
                    } else {
                        if (Math.abs(dist2 - dist1) > 5) {
                            result.add(Integer.parseInt(records.get(i)[5]));
                            result.add(Integer.parseInt(records.get(j)[5]));
                        }
                    }
                }
            }
        }

        // 输出
        if (result.size() == 0) {
            System.out.println("null");
        } else {
            String res_str = "";
            for (int index : result) {
                res_str += join(clock_records[index]) + ":";
            }
            System.out.println(res_str.substring(0, res_str.length() - 1));
        }

    }

    // join输出
    public static String join(String[] strs) {
        String s = "";
        for (String str : strs) {
            s += str + ",";
        }
        return s.substring(0, s.length() - 1);
    }
}
