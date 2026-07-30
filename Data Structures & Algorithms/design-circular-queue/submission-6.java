class MyCircularQueue {
    int[] arr;
    int front;
    int rear;
    int capacity;
    int arrSize;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1; 
        rear = -1;
        capacity = k;
        arrSize = 0;
    }
    
    public boolean enQueue(int value) {
        if(arrSize == capacity) return false;

        rear = (rear + 1)%capacity;
        arr[rear] = value;
        arrSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(arrSize == 0) return false;

        front = (front + 1)%capacity;
        arr[front] = -1;
        arrSize--;
        return true;
    }
    
    public int Front() {
        if(arrSize == 0) return -1;
        return arr[(front + 1)%capacity];
    }
    
    public int Rear() {
        if(arrSize == 0) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return arrSize == 0;
    }
    
    public boolean isFull() {
        return arrSize == capacity;
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