class Solution {

    public String encode(List<String> strs) {
        int n = strs.size();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            sb.append(strs.get(i).length()).append('#').append(strs.get(i));
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        int n = str.length();
        List<String> result = new ArrayList<>();

        
        while(i < n){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + len;
            result.add(str.substring(i, j));
             
            i = j;  
        }
        return result;
    }
}
