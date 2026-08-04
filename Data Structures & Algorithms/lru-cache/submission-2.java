class Node{
    int val;
    int key;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
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

        Node node = mp.get(key);
        delete(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            delete(node);
            insert(node);
            mp.put(key,node);
        }
        else{
            if(mp.size() == size){
                Node node = tail.prev;
                delete(node);
                mp.remove(node.key);
            }

            Node newNode = new Node(key,value);
            insert(newNode);
            mp.put(key,newNode);
        }
    }

    public void insert(Node node){
        Node nextNode = head.next;

        head.next = node;
        nextNode.prev = node;
        node.prev = head;
        node.next = nextNode;
    }

    public void delete(Node node){

        Node prevNode = node.prev;
        Node afterNode = node.next;

        prevNode.next = afterNode;
        afterNode.prev = prevNode;

    }
}
