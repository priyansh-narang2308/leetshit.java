// Median of Two Sorted Arrays

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = n1;

        while (left <= right) {
            final int part1 = (left + right) / 2;
            final int part2 = (n1 + n2 + 1) / 2 - part1;
            final int maxLeft1 = part1 == 0 ? Integer.MIN_VALUE : nums1[part1 - 1];
            final int maxLeft2 = part2 == 0 ? Integer.MIN_VALUE : nums2[part2 - 1];
            final int minRigh1 = part1 == n1 ? Integer.MAX_VALUE : nums1[part1];
            final int minRight2 = part2 == n2 ? Integer.MAX_VALUE : nums2[part2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRigh1) {
                // Avergae for median
                return (n1 + n2) % 2 == 0
                        ? (Math.max(maxLeft1, maxLeft2) + Math.min(minRigh1, minRight2)) * 0.5
                        : Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft2 > minRight2) {
                right = part1 - 1; //move right pointer to left
            } else {
                left = part1 + 1; //move left pointer right
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {2, 7, 11, 15};
        double median = new Solution().findMedianSortedArrays(nums1, nums2);
        System.out.println("Median:" + median);
    }
}
