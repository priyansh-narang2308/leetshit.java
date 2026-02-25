
import java.util.Arrays;

// 3 Sum Closest
class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int closest_sum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int low = i + 1;
            int high = n - 1;

            while (low < high) {
                int currentSumm = nums[i] + nums[high] + nums[low];

                if (Math.abs(currentSumm - target) < Math.abs(closest_sum - target)) {
                    closest_sum = currentSumm;
                }

                if (currentSumm == target) {
                    return currentSumm;
                } else if (currentSumm < target) {
                    low += 1;
                } else if (currentSumm > target) {
                    high -= 1;
                }
            }
        }

        return closest_sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {-1, 2, 1, -4};
        int target = 3;

        System.out.println(solution.threeSumClosest(nums1, target));
    }
}
