class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        int l = 0;
        int r = n - 1;

        while(r - l >= k){

            int leftDistance = Math.abs(arr[l] - x);
            int rightDistance = Math.abs(arr[r] - x);

            if(leftDistance <= rightDistance) r--;
            else l++;
        }

        List<Integer> ls = new ArrayList<>();

        for(int i = l; i<=r; i++){
            ls.add(arr[i]);
        }

        return ls;
    }
}