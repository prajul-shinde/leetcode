class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
        return 0;
        int writer = 1;
        for(var reader = 1; reader < nums.length; reader++) {
            if(nums[reader] != nums[reader-1]) {
                nums[writer] = nums[reader];
                writer++;
            }
        }
        return writer;
    }
}