class MedianFinder {

    PriorityQueue<Integer> maxP;
    PriorityQueue<Integer> minP;
    public MedianFinder() {
        maxP = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        minP = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
    }
    
    public void addNum(int num) {
        if(maxP.isEmpty() || maxP.peek() >= num){
            maxP.add(num);
        }else{
            minP.add(num);
        }

        if(maxP.size() < minP.size()){
            maxP.add(minP.poll());
        } else if(maxP.size() > minP.size() + 1){
            minP.add(maxP.poll());
        }

    }
    
    public double findMedian() {
        if(maxP.size() == minP.size()){
            return (maxP.peek() + minP.peek())/2.0;
        }else{
            return maxP.peek();
        }
    }
}
