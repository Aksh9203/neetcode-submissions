class Solution {
    public int maxArea(int[] heights) {

     int l = 0, r= heights.length - 1;
     int max = Integer.MIN_VALUE;

     while(l<r){
        int minH = Math.min(heights[l],heights[r]);
        System.out.println("minH :::::" + minH);
        int area = minH * (r-l);
        System.out.println("area :::::" + area);
        max = Math.max(max,area);
        System.out.println("Max area :::::" + max);

        if(heights[l]<heights[r]){
            l++;
        }
        else{
            r--;
        }
     }
     return max;
    }
}
