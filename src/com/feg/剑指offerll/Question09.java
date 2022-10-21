package com.feg.剑指offerll;

import java.util.LinkedList;

/**
 * @author Feg
 * @version 1.0
 * 用
 */
public class Question09 {
    class CQueue {
        LinkedList<Integer> stock;
        public CQueue() {
            stock = new LinkedList<>();
        }

        public void appendTail(int value) {
            stock.push(value);
        }

        public int deleteHead() {
            if (stock.isEmpty()){
                return -1;
            }
            return stock.removeLast();
        }
    }
}
