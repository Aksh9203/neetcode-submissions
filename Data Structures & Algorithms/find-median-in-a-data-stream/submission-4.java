class MedianFinder {

    PriorityQueue<Integer> maxP;
    PriorityQueue<Integer> minP;
    public MedianFinder() {
        maxP = new PriorityQueue<>((a,b) -> b - a);
        minP = new PriorityQueue<>((a,b) -> a - b);
    }
    
    public void addNum(int num) {
        if(maxP.isEmpty() || num <= maxP.peek()){
            maxP.add(num);
        }
        else{
            minP.add(num);
        }

        if(maxP.size() < minP.size()){
            maxP.add(minP.poll());
        }
        else if(minP.size() + 1 < maxP.size()){
            minP.add(maxP.poll());
        }
    }
    
    public double findMedian() {
        if(maxP.size() == minP.size()){
            int max = maxP.peek();
            int min = minP.peek();

            return (double)(max + min)/2;
        }
        else{
            return maxP.peek();
        }
    }
}
