class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}

class LRUCache {

    HashMap<Integer,Node> mp;
    Node head;
    Node tail;
    int size;
    public LRUCache(int capacity) {
        mp = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        size = capacity;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;

        Node currNode = mp.get(key);
        delete(currNode);
        insert(currNode);
        return currNode.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node currNode = mp.get(key);
            currNode.val = value;
            mp.put(key,currNode);
            delete(currNode);
            insert(currNode);
        } else {
            if(mp.size() == size){
                Node lastNode = tail.prev;
                delete(lastNode);
                mp.remove(lastNode.key);
            }

            Node node = new Node(key,value);
            insert(node);
            mp.put(key,node);
        }
    }

    public void insert(Node node){
        Node firstNode = head.next;

        node.next = firstNode;
        node.prev = head;

        head.next = node;
        firstNode.prev = node;
    }

    public void delete(Node node){
        Node prevNode = node.prev;
        Node afterNode = node.next;

        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }
}
