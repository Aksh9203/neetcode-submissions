class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids){
            while(!st.isEmpty() && st.peek() >  0 && asteroid < 0){
                int negVal = Math.abs(asteroid);
                int posVal = st.peek();

                if(posVal > negVal) asteroid = 0;
                else if(posVal < negVal) st.pop();
                else{
                    st.pop();
                    asteroid = 0;
                    // continue;
                }
            }
            if(asteroid != 0){
                st.push(asteroid);
            }   
        }

        int[] ans = new int[st.size()];
        for(int i=st.size() - 1; i>=0; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}