class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
        max = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || max.peek() > num){
            max.add(num);
        } else {
            min.add(num);
        }

        if(max.size() < min.size()){
            max.add(min.poll());
        }

        else if(max.size() > min.size() + 1){
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()){
            return (max.peek() + min.peek())/2.0;
        } else{
            return max.peek();
        }
    }
}
