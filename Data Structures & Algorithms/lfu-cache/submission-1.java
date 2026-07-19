class Node{
    int key;
    int val;
    int freq;
    Node prev;
    Node next;

    Node(int key, int val){
        this.val = val;
        this.key = key;
        this.freq = 1;
        this.prev = null;
        this.next = null;
    }
    
}

class DoublyLL{
    int dSize;
    Node head;
    Node tail;

    DoublyLL(){
        this.dSize = 0;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public void delete(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        dSize--;
    }

    public void insert(Node node){
        Node currentNode = head.next;

        head.next = node;
        node.prev = head;
        node.next = currentNode;
        currentNode.prev = node;

        dSize++;
    }
}

class LFUCache {

    HashMap<Integer,Node> mp;
    HashMap<Integer,DoublyLL> lfu; 
    int size;
    int minFreq;

    public LFUCache(int capacity) {
        mp = new HashMap<>();
        lfu = new HashMap<>();
        size = capacity;
        minFreq = 1;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            update(node);
        }
        else{
            if(mp.size() == size){
                DoublyLL dll = lfu.get(minFreq);
                Node lruNode = dll.tail.prev;
                dll.delete(lruNode);
                mp.remove(lruNode.key);
            }

            minFreq = 1;
            Node newNode = new Node(key,value);
            DoublyLL ls = lfu.getOrDefault(1, new DoublyLL());
            ls.insert(newNode);
            lfu.put(1,ls);
            mp.put(key, newNode);
        }
    }

    public void update(Node node){
        int currFreq = node.freq;
        DoublyLL dll = lfu.get(currFreq);
        dll.delete(node);

        if(currFreq == minFreq && dll.dSize == 0){
            minFreq++;
        }

        node.freq++;
        DoublyLL list = lfu.getOrDefault(node.freq, new DoublyLL());
        list.insert(node);
        lfu.put(node.freq,list);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */