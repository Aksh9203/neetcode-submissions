class TimeMap {

    HashMap<String, TreeMap<Integer,String>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)) return "";

        TreeMap<Integer, String> treeMp = mp.get(key);
        Map.Entry<Integer,String> entry = treeMp.floorEntry(timestamp);

        return entry == null ? "" : entry.getValue(); 
    }
}
