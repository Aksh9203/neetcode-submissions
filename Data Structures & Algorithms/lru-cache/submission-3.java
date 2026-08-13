class Node{
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
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
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        deleteFromBack(node);
        insertAtFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            mp.put(key,node);
            deleteFromBack(node);
            insertAtFront(node);
        }else{
            if(mp.size() == size){
                Node backNode = tail.prev;
                deleteFromBack(backNode);
                mp.remove(backNode.key);
            }

            Node newNode = new Node(key,value);
            insertAtFront(newNode);
            mp.put(key,newNode);
        }
    }

    public void deleteFromBack(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insertAtFront(Node node){
        Node nextNode = head.next;

        head.next = node;
        nextNode.prev = node;
        node.prev = head;
        node.next = nextNode;
    }
}
