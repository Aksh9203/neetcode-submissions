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
        int n = str.length();
        int i = 0;

        List<String> result = new ArrayList<>();

        while(i < n){
            int j = i + 1;

            while(str.charAt(j)  != '#'){
               j++; 
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;
            result.add(str.substring(i,j));
            
            i = j;
        }
        return result;
    }
}
