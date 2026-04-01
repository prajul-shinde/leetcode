class Solution {
    public int removeElement(int[] nums, int val) {
        var writer = 0;
        for(var reader =0 ; reader < nums.length; reader++) {
            if(nums[reader] != val) {
                nums[writer] = nums[reader];
                writer++;
            }
        }
        return writer;
        
    }
}