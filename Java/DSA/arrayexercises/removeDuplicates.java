    /**
     * Remove Duplicates from Sorted Array - LeetCode 26
    * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length. Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
    * Example:
    * Input: nums = [1, 1, 2] 
    * Output: 2
    */
public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        removeDuplicates rd = new removeDuplicates();
        int[] nums = {1, 1, 2};
        System.out.println(rd.removeDuplicates(nums));
        
    }
}
