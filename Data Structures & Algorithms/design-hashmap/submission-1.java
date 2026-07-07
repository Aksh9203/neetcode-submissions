class MyHashMap {

    Integer[] count;
    public MyHashMap() {
        count = new Integer[1000001];
    }
    
    public void put(int key, int value) {
        count[key] = value;
    }
    
    public int get(int key) {
        return count[key] != null ? count[key] : -1;
    }
    
    public void remove(int key) {
        count[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */