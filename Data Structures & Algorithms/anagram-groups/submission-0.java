class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        HashMap<String,List<String>> mp = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            
            int[] HashArr = new int[26];
            char[] charArray = strs[i].toCharArray();
            // System.out.println("CharArray :::::" + Arrays.toString(charArray));
            
            for(int j=0; j<charArray.length; j++){
                HashArr[charArray[j] - 'a']++;
            }
            // System.out.println("HashArr :::::" + Arrays.toString(HashArr));

            String str1 = String.valueOf(Arrays.toString(HashArr));
            // System.out.println("Str1 :::::" + str1);

            if(!mp.containsKey(str1)){
                mp.put(str1,new ArrayList<>());
            }      
            mp.get(str1).add(strs[i]);
            // System.out.println("mp ::::::::::" + mp);
        }
    // Return them as a new ArrayList.
    return new ArrayList<>(mp.values());    
    }
}
