package com.interviewbit.amazone.arrays;

import java.util.*;

public class MergeIntervals {

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

    public static ArrayList<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> mergedIntervals = new ArrayList<>();

        int intervalPointer = 0;
        while (intervalPointer < intervals.size() && intervals.get(intervalPointer).end < newInterval.start) {
            Interval currentInterval = intervals.get(intervalPointer++);
            mergedIntervals.add(currentInterval);
        }

        while (intervalPointer < intervals.size() && intervals.get(intervalPointer).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(intervalPointer).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(intervalPointer++).end);
        }

        mergedIntervals.add(newInterval);

        while (intervalPointer < intervals.size()) {
            mergedIntervals.add(intervals.get(intervalPointer++));
        }
        return mergedIntervals;
    }


    public static void main(String[] args) {
        System.out.println(insert(Arrays.asList(new Interval(1, 3), new Interval(6, 9)), new Interval(2, 5)));
        System.out.println(insert(Arrays.asList(new Interval(1, 2),
                new Interval(3, 5),
                new Interval(6, 7),
                new Interval(8, 10),
                new Interval(12, 16)
        ), new Interval(4, 9))); // [1,2],[3,10],[12,16].
    }
}
