class Node{
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    HashMap<Integer,Node> mp;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        mp = new HashMap<>();
        size = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;

        Node node = mp.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
        }
        else{
            if(mp.size()== size){
                Node node = tail.prev;
                mp.remove(node.key);
                deleteNode(node);
            }
            Node newNode = new Node(key,value);
            mp.put(key, newNode);
            insertAfterHead(newNode);
        }
    }

    public void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        nextNode.prev = prevNode;
        prevNode.next = nextNode; 
    }

    public void insertAfterHead(Node node){
        Node currentNode = head.next;

        head.next = node;
        node.next = currentNode;
        node.prev = head;
        currentNode.prev = node;
    }
}
