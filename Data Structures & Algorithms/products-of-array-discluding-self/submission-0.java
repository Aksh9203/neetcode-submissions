class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];
        int prefix = 1;
        int postfix = 1;
        Arrays.fill(result,1);

        for(int i=0; i<nums.length; i++){
            result[i] = prefix;
            System.out.println("result[] ::::::" + Arrays.toString(result));
            prefix = result[i]*nums[i];
            System.out.println("Prefix ::::::" + prefix);
            
        }

        for(int i=nums.length-1; i>=0; i--){
            result[i] = result[i]*postfix;
            System.out.println("result[] ::::::" + Arrays.toString(result));
            postfix = postfix*nums[i];
            System.out.println("Postfix ::::::" + postfix);
            
        }
        // int[] arr = new int[nums.length];
        

        // for(int i=0; i<nums.length; i++){
        //     int product = 1;
        //     for(int j=0; j<nums.length; j++){
        //         if(nums[i] == nums[j]){
        //             continue;
        //         }
        //             // System.out.println("Product ::::::" + product);
        //         product = product*nums[j];
        //         System.out.println("Prod ::::::" + product);
             
        //     }
        //     arr[i] = product;
        // }
        return result;
    }
}  
