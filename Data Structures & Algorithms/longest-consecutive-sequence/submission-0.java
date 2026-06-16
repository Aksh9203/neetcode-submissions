class Solution {
    public int longestConsecutive(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int cnt = 0;
        int longest = 0;

        HashSet<Integer> st = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            st.add(nums[i]);
            System.out.println("st ::" + st);
        }

        for(int j=0; j<nums.length; j++){
            
            if(!st.contains(nums[j]-1)){
                cnt = 1; 
                while(st.contains(nums[j]+1)){
                    cnt++;
                    nums[j]++;
                }  
            }
            longest = Math.max(cnt,longest);
            System.out.println("longest :::::" + longest);

        }    
    return longest;
    }
}
