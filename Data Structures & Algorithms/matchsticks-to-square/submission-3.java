class Solution {
    public boolean makesquare(int[] matchsticks) {
        // Arrays.sort(matchsticks);

        int n = matchsticks.length;

        int total = 0;
        for(int stick : matchsticks){
            total += stick;
        }

        // To make sure each side of equal length is possible.
        if(total % 4 != 0) return false;

        // total/4 is length of each side.
        return dfs(matchsticks, n, total/4, total/4, total/4, total/4);
    }

    private boolean dfs(int[] nums, int n, int side1, int side2, int side3, int side4){

        //If value of any side become -ve then return false.
        if(side1 < 0 || side2 < 0 || side3 < 0 || side4 < 0) return false;

        //After using all matchsticks and still any of the side is not equal to length then return false.
        if(n == 0 && (side1 != 0 || side2 != 0 || side3 != 0 || side4 != 0)) return false;

        if(n == 0 && (side1 == 0 && side2 == 0 && side3 == 0 && side4 == 0)) return true;

        //If size of matchstick is greater than all side return false.
        if(nums[n-1] > side1 && nums[n-1] > side2 && nums[n-1] > side3 && nums[n-1] > side4) return false;

        return dfs(nums, n-1, side1 - nums[n-1], side2, side3, side4) ||
               dfs(nums, n-1, side1, side2 - nums[n-1], side3, side4) ||
               dfs(nums, n-1, side1, side2, side3 - nums[n-1], side4) ||
               dfs(nums, n-1, side1, side2, side3, side4 - nums[n-1]); 
    }
}