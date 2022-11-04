package com.feg.newcoder;

import java.util.ArrayList;

/**
 * @author Feg
 * @version 1.0
 */
public class NC37 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size() == 1){
            return intervals;
        }
        intervals.sort((i,j)->i.start - j.start);
        int num = 0;
        while(true){
            if(num >= intervals.size() - 1){
                break;
            }
            Interval i1 = intervals.get(num);
            Interval i2 = intervals.get(num +1);
            if(i1.end >= i2.start){
                intervals.remove(i2);
                i1.end = i1.end < i2.end ? i2.end : i1.end;
            } else{
                num++;
            }
        }
        return intervals;
    }
}
