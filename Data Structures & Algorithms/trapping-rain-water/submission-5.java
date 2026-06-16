class Solution {
    public int trap(int[] h) {
    
    // int result = 0;

    // for(int i=0; i<h.length-1; i++){
    //     int lmax = h[i];
    //     int rmax = h[i];

    //     for(int j=i+1; j<h.length; j++){
    //         rmax = Math.max(h[j],rmax);
    //         System.out.println("rmax :::::" + rmax);
    //     }

    //     for(int j = 0; j<i; j++){
    //         lmax = Math.max(h[j],lmax);
    //         System.out.println("lmax :::::" + lmax);
    //     }

    //     result += Math.min(lmax,rmax) - h[i];
            
    // }
    // return result;

    int result = 0, lmax = h[0], rmax = h[h.length-1];
    int  l = 1, r = h.length - 2;

    while(l<=r){
        if(lmax<= rmax){
            lmax = Math.max(lmax,h[l]);
            result += lmax - h[l];
            l++;
        }
        else{
            rmax = Math.max(rmax,h[r]);
            result += rmax - h[r];
            r--;
        }
    }
    return result;
    }
}
