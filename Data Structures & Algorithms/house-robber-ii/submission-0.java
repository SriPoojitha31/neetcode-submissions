class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);

        return Math.max(robLinear(nums, 0, nums.length-2), robLinear(nums, 1, nums.length-1));
    }
    private int robLinear(int[] nums, int start, int end){
        int prev2=nums[start];
        int prev1=Math.max(nums[start], nums[start+1]);

        for(int i=start+2; i<= end;i++){
            int curr=Math.max(prev1, prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
