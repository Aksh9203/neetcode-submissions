class MyCircularQueue {

    int[] arr;
    int front;
    int rear;
    int arrSize;
    int cap;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
        arrSize = 0;
        cap = k;
    }
    
    public boolean enQueue(int value) {
        if(arrSize == cap) return false;

        rear = (rear + 1)%cap;
        arr[rear] = value;
        arrSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(arrSize == 0) return false;

        front = (front + 1)%cap;
        arr[front] = 0;
        arrSize--;
        return true;
    }
    
    public int Front() {
        if(arrSize == 0) return -1;

        return arr[(front + 1)%cap];
    }
    
    public int Rear() {
        if(arrSize == 0) return -1;

        return arr[rear];
    }
    
    public boolean isEmpty() {
        // if(arrSize == 0) return true;
        return arrSize == 0;
    }
    
    public boolean isFull() {
        // if(arrSize == cap) return true;
        return arrSize == cap;
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