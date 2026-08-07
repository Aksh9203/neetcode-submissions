class Pair{
    String word;
    int count;

    public Pair(String word, int count){
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st = new HashSet<>(wordList);

        if(!st.contains(endWord)) return 0;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(beginWord,1));
        st.remove(beginWord);

        while(!q.isEmpty()){

            Pair top = q.poll();
            String currWord = top.word;
            int currCnt = top.count;

            if(currWord.equals(endWord)) return currCnt;

            char[] letters = currWord.toCharArray();
            for(int i=0; i<letters.length; i++){
                char original = letters[i];
                for(char c = 'a'; c <= 'z'; c++){
                    letters[i] = c;

                    String newWord = new String(letters);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.add(new Pair(newWord, currCnt + 1));
                    }

                }
                letters[i] = original;
            }
        }
        return 0;
    }
}
