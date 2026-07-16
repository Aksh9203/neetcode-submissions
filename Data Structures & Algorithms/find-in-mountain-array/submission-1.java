/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int idx = 0;

        if(mountainArr.get(0) > mountainArr.get(1)) idx = 0;
        if(mountainArr.get(n - 1) > mountainArr.get(n - 2)) idx = n - 1;

        int low = 1;
        int high = n - 2;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(mountainArr.get(mid - 1) < mountainArr.get(mid) && mountainArr.get(mid) > mountainArr.get(mid + 1)){
                idx = mid;
                break;
            }
            else if(mountainArr.get(mid) > mountainArr.get(mid + 1)) high = mid - 1;
            else{
                low = mid + 1;
            }
        }

        int low1 = 0;
        int high1 = idx;

        while(low1 <= high1){
            int mid = low1 + (high1 - low1)/2;

            if(mountainArr.get(mid) == target) return mid;
            else if(mountainArr.get(mid) > target) high1 = mid - 1;
            else low1 = mid + 1;
        }

        int low2 = idx + 1;
        int high2 = n - 1;

        while(low2 <= high2){
            int mid = low2 + (high2 - low2)/2;

            if(mountainArr.get(mid) == target) return mid;
            else if(mountainArr.get(mid) > target) low2 = mid + 1;
            else high2 = mid - 1; 
        }

        return -1;

    }
}