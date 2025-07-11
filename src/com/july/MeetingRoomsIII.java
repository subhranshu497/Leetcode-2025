package com.july;

import java.util.*;

public class MeetingRoomsIII {
    public static void main(String[] args) {
        int n = 2;
        //int [][] meetings = {{0,10},{1,5},{2,7},{3,4}};
        int [][] meetings = {{0,10},{1,2},{12,14},{13,15}};
        int roomMostMeetingHeld = mostBooked(n, meetings);
        System.out.println(roomMostMeetingHeld);
    }

    public static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        //take a minheap and push all rooms to it originally
        PriorityQueue<Integer> roomsHeap = new PriorityQueue<>();
        PriorityQueue<long[]> timeAndRoom = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]); // Primary: sort by a[0]
            } else {
                return Integer.compare((int)a[1],(int) b[1]); // Secondary: sort by a[1]
            }
        });
        for(int i=0;i<n;i++)
            roomsHeap.offer(i);
        //now start allocating meetings to available rooms
        //to keep track of room and its count , take a hashmap
        Map<Integer, Integer> meetingCountPerRoom = new TreeMap<>();
        for(int [] meeting:meetings){
            int currentStartTime = meeting[0];
            int currentEndTime = meeting[1];
            int duration = currentEndTime-currentStartTime;
            //keep on polling the time and room heap till its peek reaches a value > currentstarttime
            while(!timeAndRoom.isEmpty() && timeAndRoom.peek()[0]<=currentStartTime){
                int roomNo = (int)timeAndRoom.peek()[1];
                timeAndRoom.poll();
                roomsHeap.offer(roomNo);
            }
            if(!roomsHeap.isEmpty()){
                int currentRoomUsed = roomsHeap.poll();
                timeAndRoom.offer(new long[]{currentStartTime+duration, currentRoomUsed});
                meetingCountPerRoom.put(currentRoomUsed, meetingCountPerRoom.getOrDefault(currentRoomUsed,0)+1);
            }else{

                long[] roominfo = timeAndRoom.poll();
                long time =roominfo[0];
                int currentRoom =(int) roominfo[1];
                meetingCountPerRoom.put(currentRoom, meetingCountPerRoom.getOrDefault(currentRoom,0)+1);
                timeAndRoom.offer(new long[]{time+duration, currentRoom});
            }
        }
        System.out.println(meetingCountPerRoom);
        //now iterate the map
        int prevVal = Integer.MIN_VALUE;
        int res = 0;
        for(Map.Entry<Integer, Integer> e:meetingCountPerRoom.entrySet()){
            int key =e.getKey();
            int val = e.getValue();
            if(val>prevVal){
                res = key;
                prevVal = val;
            }
        }
        return res;
    }
}
