class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;

        HashMap<Character,Integer> mp = new HashMap<>();
        for(char task : tasks){
            mp.put(task, mp.getOrDefault(task,0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        pq.addAll(mp.values());
        int count = 0;

        while(!pq.isEmpty()){
            List<Integer> result = new ArrayList<>();

            for(int i=0; i<=n; i++){
                if(!pq.isEmpty()){
                    int top = pq.poll();
                    top--;
                    result.add(top);
                }
            }

            for(int i=0; i<result.size(); i++){
                if(result.get(i) > 0){
                    pq.add(result.get(i));
                }
            }

            if(pq.size() > 0){
                count += n + 1;
            }
            else{
                count += result.size();
            }
        }
        return count;
    }
}
