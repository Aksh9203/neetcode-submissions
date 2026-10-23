class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids){
            while(!st.isEmpty() && asteroid < 0 && st.peek() > 0){
                int val = st.peek();
                int asteroidVal = asteroid * -1; 

                if(val > asteroidVal) {
                    asteroid = 0;
                }
                else if(val < asteroidVal) {
                    st.pop();
                } else {
                    asteroid = 0;
                    st.pop();
                }
            }
            if(asteroid != 0){
                st.push(asteroid);
            }   
        }

        int[] ans = new int[st.size()];
        
        for(int i = st.size() - 1; i>=0; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}