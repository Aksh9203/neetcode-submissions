class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int i = 0, j = 0;
        int idx = 0;

        int[] ans = new int[m+n];

        while(i < n || j < m){
            if(i < n && (j >= m || nums1[i] <= nums2[j])){
                ans[idx] = nums1[i];
                idx++;
                i++;
            }
            else if(j < m && (i >= n || nums1[i] > nums2[j])){
                ans[idx] = nums2[j];
                idx++;
                j++;
            }
        }

        int k = ans.length;

        if(k % 2 != 0){
            return ans[k/2];
        }
        else{
            return (ans[(k-1)/2] + ans[k/2])/2.0;
        }
    }
}
