class MedianFinder {

    PriorityQueue<Integer> maxP;
    PriorityQueue<Integer> minP;
    int count = 0;
    public MedianFinder() {
        maxP = new PriorityQueue<>((a,b) -> b - a);
        minP = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxP.isEmpty() || num <= maxP.peek()){
            maxP.add(num);
        }
        else{
            minP.add(num);
        }
        count++;

        if(maxP.size() < minP.size()){
            maxP.add(minP.poll());
        }else if(minP.size() + 1 < maxP.size()){
            minP.add(maxP.poll());
        }
    }
    
    public double findMedian() {
        if(count % 2 == 0){
            int top1 = minP.peek();
            int top2 = maxP.peek();

            return (double)(top1 + top2)/2;
        }
        else{
            return (double)(maxP.peek());
        }
    }
}
