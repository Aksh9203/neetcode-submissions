class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.size() == 0){
            return sb.toString();
        }
        // String joinString = String.join("#",strs);
        // sb.append(joinString);
        // sb.append("#");
        // System.out.println("joined String :::::::" + sb.toString());
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        System.out.println("joined String :::::::" + sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ls = new ArrayList<>();
        if(str.isEmpty()){
            return ls;
        }

        for(int i = 0; i<str.length(); i++){
            int j = i;
            while(j<str.length()){
                if(str.charAt(j) == '#'){
                    int length = Integer.parseInt(str.substring(i,j));
                    System.out.println("Split length :::::::" + length);
                    i = j + 1;
                    j = i + length;
                    String split = str.substring(i,j);
                    System.out.println("Split String :::::::" + split);
                    ls.add(split);
                    System.out.println("list :::::::" + ls);
                    i = j;
                }
                j++;
            }
        }  
        return ls;
    }
}
