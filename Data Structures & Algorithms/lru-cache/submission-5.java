//Defination of Doubly LINKED LIST
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

    HashMap<Integer, Node> mp;
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

        Node node = mp.get(key);
        delete(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value){
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            mp.put(key,node);
            delete(node);
            insert(node);
        }else{
            if(mp.size() == size){
                Node lastNode = tail.prev;
                delete(lastNode);
                mp.remove(lastNode.key);
            }

            Node newNode = new Node(key,value);
            mp.put(key, newNode);
            insert(newNode);
        }

    }

    public void delete(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insert(Node node){
        Node firstNode = head.next;

        node.next = firstNode;
        node.prev = head;

        head.next = node;
        firstNode.prev = node;
    }
}
