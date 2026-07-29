class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;

        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0; i<m; i++){
            mp.put(tasks[i], mp.getOrDefault(tasks[i],0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        pq.addAll(mp.values());
        int count = 0;

        while(!pq.isEmpty()){
            List<Integer> ls = new ArrayList<>();

            for(int i=0; i<=n; i++){
                if(!pq.isEmpty()){
                    int top = pq.poll();
                    top--;
                    ls.add(top);
                }
            }

            for(int i=0; i<ls.size(); i++){
                if(ls.get(i) > 0){
                    pq.add(ls.get(i));
                }
            }

            if(pq.isEmpty()){
                count += ls.size();
            }
            else{
                count += n + 1;
            }
        }
        return count;
    }
}
