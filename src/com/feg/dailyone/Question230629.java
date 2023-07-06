package com.feg.dailyone;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/29 10:46
 */
public class Question230629 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        return null;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));
        poolExecutor.execute(() -> System.out.println("这是第一个线程执行结果"));
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            poolExecutor.execute(() -> System.out.println("循环第" + finalI + "个结果"));
        }
    }
}
