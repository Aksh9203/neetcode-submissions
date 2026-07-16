class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int  i = 0, j = 0;
        int[] ans = new int[m+n];

        int idx = 0;

        while(i < m || j < n){
            if((j >= n || nums1[i] <= nums2[j]) && i < m){
                ans[idx] = nums1[i];
                i++;
                idx++;
            }
            else if(j < n){
                ans[idx] = nums2[j];
                j++;
                idx++;
            }
        }

        for(int k=0; k<ans.length; k++){
            nums1[k] = ans[k];
        }
    }
}