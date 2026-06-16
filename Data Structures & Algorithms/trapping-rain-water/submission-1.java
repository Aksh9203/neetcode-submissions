class Solution {
    public int trap(int[] h) {
    int l = 0, r = h.length - 1;
    int lmax = 0, rmax = 0, ans = 0;

    while (l <= r) {
        if (h[l] <= h[r]) {          // left side is the bottleneck
            lmax = Math.max(lmax, h[l]);
            ans += lmax - h[l];
            l++;
        } else {                     // right side is the bottleneck
            rmax = Math.max(rmax, h[r]);
            ans += rmax - h[r];
            r--;
        }
    }
    return ans;

    }
}
