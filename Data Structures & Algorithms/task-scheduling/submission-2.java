class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        HashMap<Character,Integer> mp = new HashMap<>();

        for(char task : tasks){
            mp.put(task,mp.getOrDefault(task,0) + 1);
        }

        for(Map.Entry<Character,Integer> entry : mp.entrySet()){
            pq.add(entry.getValue());
        }

        int time = 0;
        

        while(!pq.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            int taskCount = 0;

            for(int i = 0; i<n+1; i++){
                if(!pq.isEmpty()){
                    int topFreq = pq.poll();
                    topFreq--;
                    ls.add(topFreq);
                    taskCount++;
                }
            }

            for(int freq : ls){
                if(freq>0){
                    pq.add(freq);
                }
            }

            if(pq.isEmpty()){
                time += taskCount;
            }
            else{
                time += n + 1;
            }   
        }
        return time;
    }
}
