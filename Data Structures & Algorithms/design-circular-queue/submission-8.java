class MyCircularQueue {

    int[] arr;
    int front;
    int rear;
    int arrsize;
    int size;
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1; 
        rear = -1;
        arrsize = 0;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if(arrsize == size) return false;

        arr[(rear + 1)% size] = value;
        rear = (rear + 1) % size;
        arrsize++;
        return true;
    }
    
    public boolean deQueue() {
        if(arrsize == 0) return false;

        arr[(front + 1) % size] = -1;
        front = (front + 1) % size;
        arrsize--;
        return true;
    }
    
    public int Front() {
        if(arrsize == 0) return -1;

        return arr[(front + 1) % size];
    }
    
    public int Rear() {
        if(arrsize == 0) return -1;

        return arr[rear];
    }
    
    public boolean isEmpty() {
        return arrsize == 0;
    }
    
    public boolean isFull() {
        return arrsize == size;
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