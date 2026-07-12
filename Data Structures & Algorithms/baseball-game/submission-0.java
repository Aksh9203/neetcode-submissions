class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            if(operations[i].equals("+")){
                int value1 = st.pop();
                int value2 = st.pop();

                int sum = value1 + value2;
                st.push(value2);
                st.push(value1);
                st.push(sum);
            }
            else if(operations[i].equals("C")) st.pop();
            else if(operations[i].equals("D")){
                int value1 = st.pop();

                int mul = value1 * 2;
                st.push(value1);
                st.push(mul);
            }
            else st.push(Integer.parseInt(operations[i]));   
        }

        int sum = 0;

        while(st.size() > 0){
            sum += st.pop();
        }

        return sum;
    }
}