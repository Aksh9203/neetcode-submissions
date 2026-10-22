class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        for(int num : nums){
            int curr = num;
            int cnt = 1;

            if(!set.contains(curr - 1)){
                while(set.contains(curr + 1)){
                    cnt++;
                    curr = curr + 1;
                }
            }

            longest = Math.max(longest,cnt);
        }

        return longest;
    }
}
