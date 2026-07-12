class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> st = new Stack<>();

        for(int rock : asteroids){
            while(!st.isEmpty() && st.peek() > 0 && rock < 0){
                int posVal = st.pop();
                int negVal = Math.abs(rock);

                if(posVal < negVal) {
                    continue;
                }
                else if(posVal > negVal) {
                    st.push(posVal);
                    rock = 0;
                }
                else{
                    rock = 0;
                }
            }
            if(rock != 0){
                st.push(rock);
            }
        }

        int[] rocks = new int[st.size()];

        for(int i = st.size() - 1; i>=0; i--){
            rocks[i] = st.pop();
        }

        return rocks;
    }
}