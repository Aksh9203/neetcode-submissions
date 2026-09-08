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

class LRUCache{

    HashMap<Integer,Node> mp;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity){
        mp = new HashMap<>();
        size = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(!mp.containsKey(key)) return -1;

        Node currNode = mp.get(key);
        delete(currNode);
        insert(currNode);
        return currNode.val;
    }

    public void put(int key, int value){
        if(mp.containsKey(key)){
            Node currNode = mp.get(key);
            currNode.val = value;
            delete(currNode);
            insert(currNode);
            mp.put(key,currNode);
        }
        else{
            if(mp.size() == size){
                Node leastFreqUsedNode = tail.prev;
                delete(leastFreqUsedNode);
                mp.remove(leastFreqUsedNode.key);
            }

            Node newNode = new Node(key,value);
            insert(newNode);
            mp.put(key,newNode);
        }
    }

    public void delete(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insert(Node node){
        Node nextNode = head.next;

        nextNode.prev = node;
        head.next = node;

        node.next = nextNode;
        node.prev = head;    
    }
}
