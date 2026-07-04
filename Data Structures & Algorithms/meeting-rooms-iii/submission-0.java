class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;

        Arrays.sort(meetings,(a,b) -> Integer.compare(a[0],b[0]));

        int[] roomAvailability = new int[n];
        int[] roomUserCnt = new int[n];

        for(int[] meet : meetings){
            int start = meet[0];
            int end = meet[1];
            int duration = end - start;
            boolean roomFound = false;

            int earliestRoomAvailable = 0;
            int earliestTime= Integer.MAX_VALUE;

            for(int room = 0; room<n; room++){
                if(roomAvailability[room] <= start){
                    roomAvailability[room] = end;
                    roomUserCnt[room]++;
                    roomFound = true;
                    break;
                }

                if(roomAvailability[room] < earliestTime){
                    earliestTime = roomAvailability[room];
                    earliestRoomAvailable = room;
                }
            }

            if(!roomFound){
                roomAvailability[earliestRoomAvailable] += duration;
                 roomUserCnt[earliestRoomAvailable]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int result = 0;

        for(int i=0; i<n; i++){
            if(roomUserCnt[i] > max){
                max = Math.max(max,roomUserCnt[i]);
                result = i;
            }
            
        }

        return result;
    }
}