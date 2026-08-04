class MyCircularQueue {
    
    int[] circularQueue;
    int front;
    int rear;
    int size;
    int cqSize;
    public MyCircularQueue(int k) {
        
        circularQueue = new int[k];
        front = -1;
        rear = -1;
        size = k;
        cqSize = 0;
    }
    
    public boolean enQueue(int value) {
        if(cqSize == size) return false;

        rear = (rear + 1)%size;
        circularQueue[rear] = value;
        cqSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(cqSize == 0) return false;

        front = (front + 1)%size;
        circularQueue[front] = -1;
        cqSize--;
        return true;
    }
    
    public int Front() {
        if(cqSize == 0) return -1;

        return circularQueue[(front + 1) % size];
    }
    
    public int Rear() {
        if(cqSize == 0) return -1;

        return circularQueue[rear];
    }
    
    public boolean isEmpty() {
        return cqSize == 0;
    }
    
    public boolean isFull() {
        return cqSize == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */