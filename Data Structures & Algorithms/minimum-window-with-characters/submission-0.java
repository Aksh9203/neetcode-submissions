class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }

        HashMap<Character,Integer> mp = new HashMap<>();
        int minLen = Integer.MAX_VALUE; 
        int sIndex = -1;

        for(int k=0; k<t.length(); k++){
            mp.put(t.charAt(k),mp.getOrDefault(t.charAt(k),0)+1);
        }


    //     for(int i = 0; i<s.length(); i++){
    //         int cnt = 0;
    //         for(int k=0; k<t.length(); k++){
    //             mp.put(t.charAt(k),mp.getOrDefault(t.charAt(k),0)+1);
    //         }
    //         for(int j=i; j<s.length(); j++){
    //             if(mp.containsKey(s.charAt(j))){
    //                 if(mp.get(s.charAt(j)) > 0){
    //                     cnt++;
    //                     mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j),0)-1);
    //                 }
    //             }
                    
    //             if(cnt == t.length()){
    //                 if(j-i+1<minLen){
    //                     minLen = j-i+1;
    //                     sIndex = i;
    //                 }
    //                 break;
    //             }
    //         }
    //     }
    // return sIndex == -1 ? "" : s.substring(sIndex,sIndex+minLen);

        int l = 0, r = 0;
        int cnt = 0;

        while(r<s.length()){
            
            if(mp.containsKey(s.charAt(r))){
                if(mp.get(s.charAt(r))>0){
                    cnt++;
                }
                mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)-1);
            }

            while(cnt == t.length()){
                if(r-l+1<minLen){
                    minLen = r-l+1;
                    sIndex = l;
                }
                if(mp.containsKey(s.charAt(l))){
                    mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0)+1);
                    System.out.println(mp);
                    if(mp.get(s.charAt(l))>0){
                        cnt--;
                    }
                }
                l++;
            }
            r++;
        }
    return sIndex == -1 ? "" : s.substring(sIndex,sIndex+minLen);
    }
}
