package com.interviewbit.amazone.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        Integer[][] intervals;
        intervals = A.stream().map(x -> x.toArray(new Integer[x.size()])).toArray(Integer[][]::new);

        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, ((interval1, interval2) -> interval1[0] - interval2[0]));
        Queue<Integer[]> meetingQueue = new PriorityQueue<>((interval1, interval2) -> interval1[1] - interval2[1]);

        meetingQueue.add(intervals[0]);
        int minRooms = 1;
        for (int i = 1; i < intervals.length; i++) {
            while (!meetingQueue.isEmpty() && meetingQueue.peek()[1] <= intervals[i][0])
                meetingQueue.poll();

            meetingQueue.add(intervals[i]);
            minRooms = Math.max(minRooms, meetingQueue.size());
        }

        return minRooms;
    }
}
