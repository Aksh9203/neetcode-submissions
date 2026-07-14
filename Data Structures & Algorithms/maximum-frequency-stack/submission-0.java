class FreqStack {

    HashMap<Integer,Integer> mp;
    HashMap<Integer, Stack<Integer>> cnt;
    int max;
    public FreqStack() {
        mp = new HashMap<>();
        cnt = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        mp.put(val, mp.getOrDefault(val,0) + 1);

        int maxCnt = mp.get(val);

        if(maxCnt > max){
            max = maxCnt;
        }

        if(!cnt.containsKey(maxCnt)){
            cnt.put(maxCnt, new Stack<>());
        }
        cnt.get(maxCnt).push(val);
    }
    
    public int pop() {
        int res = cnt.get(max).pop();
        mp.put(res, mp.getOrDefault(res,0) - 1);

        if(cnt.get(max).isEmpty()){
            max--;
        }

        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */