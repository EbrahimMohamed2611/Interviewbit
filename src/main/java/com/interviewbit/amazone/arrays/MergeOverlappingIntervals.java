package com.interviewbit.amazone.arrays;

import java.util.*;

public class MergeOverlappingIntervals {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + ']';
        }
    }
/*
There are 4 cases for overlapping intervals
(1)             (2)             (3)                     (4)
-------            --------         -------                 ------
    -------          ----                    -------        ------------
 */
    // Time: O(N * LogN)
    public static ArrayList<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (interval1, interval2) -> interval1.start - interval2.start);
        ArrayList<Interval> mergedInterval = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (end >= current.start) { // this condition to handle 3 cases when happen any overlapping
                end = Math.max(end, current.end);
            } else {
                mergedInterval.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }
        mergedInterval.add(new Interval(start, end));
        return mergedInterval;
    }

    public static void main(String[] args) {
//return [1,6],[8,10],[15,18].
        List<Interval> intervals = Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18));
        System.out.println(merge(intervals));
        System.out.println(merge(Arrays.asList(new Interval(1, 2),
                new Interval(3, 5),
                new Interval(6, 7),
                new Interval(8, 10),
                new Interval(12, 16)
                , new Interval(4, 9)))); // [1,2],[3,10],[12,16].
    }
}
