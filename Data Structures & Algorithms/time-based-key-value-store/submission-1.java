class TimeMap {

    HashMap<String, TreeMap<Integer,String>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key)){
            mp.put(key, new TreeMap<>());
        }
        mp.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)) return "";
        
        Map.Entry<Integer,String> entry = mp.get(key).floorEntry(timestamp);
        return entry != null ? entry.getValue() : "";
    }
}
