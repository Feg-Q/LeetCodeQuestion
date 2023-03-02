package com.feg.huaweiod;

import java.util.Scanner;
import java.util.*;

class LargestSingleEntryRegion {
    public static int[] entrances = new int[2];
    public static int count = 0;
 
	public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        // 行数
        int m = in.nextInt();
        // 列数
        int n = in.nextInt();

        String[][] matrix = new String[m][n];
        in.nextLine();
        // 二维矩阵
        for(int i=0;i<m;i++){
            String[] strs = in.nextLine().split(" ");
            for(int j=0;j<n;j++){
                matrix[i][j] = strs[j];
            }
        }
        // 最大的区域大小
        int result = 0;
        List<int[]> empty_zones = new ArrayList<>();
        // 遍历每一个元素
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // 元素是0表示是空闲的
                if(matrix[i][j].equals("O")){
                    // 把当前元素淹了，然后递归淹了相邻的空闲区域
                    matrix[i][j] = "X";
                    // 感觉这个集合没必要，也就用来计算了空闲区域的大小
                    List<int[]> coords = new ArrayList<>();    // 空闲区域中的坐标集合
                    coords.add(new int[]{i,j});
                    // 递归淹了
                    find_zone(m,n, i, j, coords, matrix);
                    // 如果演完之后发现是单入口
                    if(count == 1){
                        // 和上一个最大的单入口区域的大小相等
                        if(result == coords.size()){  // 有大小相同的单入口空闲区域，只需要大小，无需坐标
                            empty_zones.clear();
                        }else if(result < coords.size()){ // 比前面符合要求的区域大
                            empty_zones.clear();
                            empty_zones.add(new int[]{entrances[0], entrances[1], coords.size()});
                            result = coords.size();
                        }
                    }
                    // 一个区域结束，重置变量
                    count = 0;  // 重置入口数量
                    entrances = new int[2];  // 重置入口坐标
                }
            }
        }
        // 输出结果，如果记录最大空闲区域的集合不为空，表明确实存在仅一个最大单入口空闲区域
        if(empty_zones.size() == 1){
            int[] res = empty_zones.get(0);
            System.out.println(res[0] + " " + res[1] + " " + res[2]);
        }else if(result != 0){ // 存在多个，返回大小
            System.out.println(result);
        }else { // 不存在
            System.out.println("NULL");
        }
    }
    public static void find_zone(int m, int n, int x,int y,List<int[]> coords, String[][] matrix){
        // 判断当前要淹了的元素是否是边界上的
        if(x==0 || x == m-1 || y ==0 || y == n-1){
            count++;  // 入口的数量计数
            entrances[0] = x;
            entrances[1] = y;
        }
        // 往右或往下遍历
        if(x<m-1){
            if(matrix[x+1][y].equals("O")){
                matrix[x+1][y] = "X"; 
                coords.add(new int[]{x+1,y});
                find_zone(m,n, x+1, y, coords, matrix);
            }
        }
        if(y<n-1){
            if(matrix[x][y+1].equals("O")){
                matrix[x][y+1] = "X"; 
                coords.add(new int[]{x,y+1});
                find_zone(m,n, x, y+1, coords, matrix);
            }
        }
    }
}