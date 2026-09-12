class Solution {
    public int leastInterval(char[] tasks, int n) {
        int n1 = tasks.length;

        HashMap<Character,Integer> mp = new HashMap<>();

        for(int i=0; i<n1; i++){
            mp.put(tasks[i], mp.getOrDefault(tasks[i],0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        pq.addAll(mp.values());

        int count = 0;

        while(!pq.isEmpty()){
            List<Integer> ls = new ArrayList<>();

            for(int i=0; i<n+1; i++){
                if(!pq.isEmpty()){
                    int top = pq.poll();
                    top--;
                    ls.add(top);
                }
            }

            for(int i=0; i<ls.size(); i++){
                if(ls.get(i) != 0){
                    pq.add(ls.get(i));
                }   
            }

            if(pq.size() > 0){
                count += n + 1;
            }else{
                count += ls.size();
            }
        }
        return count;
    }
}
