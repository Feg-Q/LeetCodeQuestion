package com.feg.other;

import java.util.*;
// 定义一个类，表示端口组

class Group {
    // 定义一个集合，存储端口组中的元素
    private Set<Integer> ports;
    // 定义一个构造方法，接收一个整数数组作为参数，并将其转换为集合
    public Group(int[] array) {
        ports = new HashSet<>();
        for (int x : array) {
            ports.add(x);
        }
    }
    // 定义一个方法，判断两个端口组是否互相关联，即是否有2个及以上不同端口相同
    public boolean isRelated(Group other) {
        // 定义一个计数器，记录相同端口的个数
        int count = 0;
        // 遍历本端口组中的每个元素
        for (int x : ports) {
            // 如果该元素也在另一个端口组中，说明有相同的端口
            if (other.ports.contains(x)) {
                // 计数器加一
                count++;
                // 如果计数器达到2，说明两个端口组互相关联，返回true
                if (count == 2) {
                    return true;
                }
            }
        }
        // 如果遍历完后计数器没有达到2，说明两个端口组不互相关联，返回false
        return false;
    }
    // 定义一个方法，合并两个互相关联的端口组，并去除重复元素和排序
    public void merge(Group other) {
        // 将另一个端口组中的所有元素添加到本端口组中（集合会自动去除重复元素）
        ports.addAll(other.ports);
    }
    // 定义一个方法，将本端口组转换为升序排列的整数数组，并返回结果
    public int[] toArray() {
        // 创建一个整数数组，长度等于本端口组中元素的个数
        int[] array = new int[ports.size()];
        // 创建一个迭代器对象，用于遍历本端口组中的每个元素（集合无法通过索引访问）
        Iterator<Integer> it = ports.iterator();
        // 遍历本端口组中的每个元素，并将其赋值给数组中对应位置（从0开始）
        for (int i = 0; i < array.length; i++) {
            array[i] = it.next();
        }
        // 对数组进行升序排序（使用Arrays类提供的静态方法）
        Arrays.sort(array);
        return array;
    }
}
// 主类和主方法（程序入口）
public class Combine {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       List<Group> groups = new ArrayList<>();
       int M = sc.nextInt();
       for(int i=0;i<M;i++){
           String line=sc.next();
           String[] arr=line.split(",");
           int[] nums=new int[arr.length];
           for(int j=0;j<arr.length;j++){
               nums[j]=Integer.parseInt(arr[j]);
           }
           groups.add(new Group(nums));
       }

       boolean flag=false;

       while(true){
           for(int i=0;i<groups.size();i++){
               for(int j=i+1;j<groups.size();j++){
                   if(groups.get(i).isRelated(groups.get(j))){
                       groups.get(i).merge(groups.get(j));
                       groups.remove(j);
                       flag=true;
                       break;
                   }
               }
               if(flag){
                   break;
               }
           }
           if(!flag){
               break;
           }else{
               flag=false;
           }
       }
       System.out.print("[");
       for(Group group:groups){
          System.out.print(Arrays.toString(group.toArray()));
          System.out.print(",");
      }
      System.out.print("]");
   } 
}