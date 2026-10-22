class Solution {
    public int firstMissingPositive(int[] nums) {
        int max = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(num > 0) set.add(num);

            max = Math.max(num,max);
        }

        for(int i=1; i<=max ; i++){
            if(!set.contains(i)) return i;
        }

        return max + 1;
    }
}