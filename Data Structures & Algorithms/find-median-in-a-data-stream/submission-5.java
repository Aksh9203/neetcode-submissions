class MedianFinder {

    PriorityQueue<Integer> maxP;
    PriorityQueue<Integer> minP;
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

        if(minP.size() > maxP.size()){
            maxP.add(minP.poll());
        }
        else if(maxP.size() > minP.size() + 1){
            minP.add(maxP.poll());
        }
    }
    
    public double findMedian() {
        if(maxP.size() == minP.size()){
            int top1 = maxP.peek();
            int top2 = minP.peek();
            return (double)(top1 + top2)/2.0;
        }
        else{
            int top = maxP.peek();
            return (double)top;
        }
    }
}
