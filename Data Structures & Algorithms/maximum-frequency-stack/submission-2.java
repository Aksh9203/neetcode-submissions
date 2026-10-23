class FreqStack {

    HashMap<Integer,Integer> mp = new HashMap<>();
    HashMap<Integer,Stack<Integer>> occur = new HashMap<>();
    int max;
    public FreqStack() {
        mp = new HashMap<>();
        occur = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        mp.put(val,mp.getOrDefault(val,0) + 1);

        int valCnt = mp.get(val);

        if(max < valCnt){
            max = valCnt;
        }

        occur.computeIfAbsent(valCnt, k -> new Stack<>()).push(val);
    }
    
    public int pop() {
        Stack<Integer> st = occur.get(max);
        int val = st.pop();

        mp.put(val,mp.getOrDefault(val,0) - 1);

        if(st.isEmpty()){
            max--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */