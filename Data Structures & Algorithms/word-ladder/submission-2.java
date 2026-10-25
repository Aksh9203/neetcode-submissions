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
        HashSet<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair top = q.poll();
            String currWord = top.word;
            int level = top.count;

            if(currWord.equals(endWord)) return level;

            char[] letters = currWord.toCharArray();
            for(int i=0; i<letters.length; i++){
                Character original = letters[i];
                for(char ch ='a'; ch <= 'z'; ch++){
                    letters[i] = ch;

                    String newWord = new String(letters);
                    if(newWord.equals(endWord)) return level + 1;
                    else if(set.contains(newWord)) {
                        q.add(new Pair(newWord,level + 1));
                        set.remove(newWord);
                    }
                }
                letters[i] = original;
            }
        }

        return 0;
    }
}
