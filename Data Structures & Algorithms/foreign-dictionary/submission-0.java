class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<26; i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[26];

        for(int i=0; i<n-1; i++){
            String s1 = words[i];
            String s2 = words[i+1];

            if(s1.length() > s2.length() && s1.startsWith(s2)) return "";

            int min = Math.min(s1.length(), s2.length());

            for(int j=0; j<min; j++){
                char l1 = s1.charAt(j);
                char l2 = s2.charAt(j);

                if(l1 != l2){
                    int u = l1 - 'a';
                    int v = l2 - 'a';

                    adj.get(u).add(v);
                    inDegree[v]++;
                    break;
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> st = new HashSet<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                if(c >= 'a' && c <= 'z'){
                    st.add(c - 'a');
                }
            }
        }

        for(int i=0; i<26; i++){
            if(inDegree[i] == 0 && st.contains(i)){
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            int top = q.poll();
            char letter = (char)(top + 'a');
            sb.append(letter);

            for(int j : adj.get(top)){
                inDegree[j]--;
                if(inDegree[j] == 0){
                    q.add(j);
                }
            }
        }

        return sb.length() != st.size() ? "" : sb.toString(); 
    }
}
