class Pair {
    Character ch;
    int count;

    Pair(Character ch, int count){
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        HashMap<Character,Integer> mp = new HashMap<>();
        for(char c : s.toCharArray()){
            mp.put(c, mp.getOrDefault(c,0) + 1);
        }

        for(int cnt : mp.values()){
            if(cnt > (n+1)/2) return "";
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.count - a.count);

        for(Map.Entry<Character,Integer> entry : mp.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() >= 2){
            Pair top1 = pq.poll();
            Pair top2 = pq.poll();

            sb.append(top1.ch);
            sb.append(top2.ch);

            top1.count--;
            top2.count--;

            if(top1.count > 0) pq.add(top1);
            
            if(top2.count > 0) pq.add(top2);
        }

        if(!pq.isEmpty()){
            Pair top = pq.poll();
            sb.append(top.ch);
        }

        return sb.toString();
    }
}