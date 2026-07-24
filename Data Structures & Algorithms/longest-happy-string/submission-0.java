class Pair {
    Character ch;
    int count;

    Pair(Character ch, int count){
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.count - x.count);

        if(a > 0) pq.add(new Pair('a',a));
        if(b > 0) pq.add(new Pair('b',b));
        if(c > 0) pq.add(new Pair('c',c));

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Pair top1 = pq.poll();
            top1.count--;

            int n = sb.length();
            if(n >= 2 && sb.charAt(n-1) == top1.ch && sb.charAt(n-2) == top1.ch){
                if(pq.isEmpty()) break;
                
                Pair top2 = pq.poll();
                top2.count--;
                sb.append(top2.ch);

                if(top2.count > 0){
                    pq.add(top2);
                }
            }

            sb.append(top1.ch);

            if(top1.count > 0){
                pq.add(top1);
            }
        }

        return sb.toString();
    }
}