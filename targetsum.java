class Solution {
    int res=0;
    int target;
    public int findTargetSumWays(int[] nums, int target) {

        if (nums==null || nums.length==0) return 0;

        this.target=target;
        check(nums, 0, 0);
        return res;
    }
    void check(int []nums, int i, int sum){
        if (i==nums.length){
            if (sum==target) res++;
            return;
        }
        check(nums, i+1, sum+nums[i]);
        check(nums, i+1, sum-nums[i]);

    }
}
