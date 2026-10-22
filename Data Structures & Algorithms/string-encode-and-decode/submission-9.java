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
        List<String> ls = new ArrayList<>();

        int n = str.length();

        int i = 0, j = 0;

        while(i < n){
            if(str.charAt(j) == '#'){
                int len = Integer.parseInt(str.substring(i,j));
                i = j + 1;
                j = i + len;
                ls.add(str.substring(i,j));
                i = j;
            }
            j++;
        }
        return ls;
    }
}
