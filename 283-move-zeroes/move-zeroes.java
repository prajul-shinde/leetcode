class Solution {
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length <= 1)
            return;

        int write = 0;
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                if (read != write) {
                    int temp = nums[write];
                    nums[write] = nums[read];
                    nums[read] = temp;
                }
                write++;
            }
        }

    }
}