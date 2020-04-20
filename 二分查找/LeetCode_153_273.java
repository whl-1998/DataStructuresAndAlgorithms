//153. 寻找旋转排序数组中的最小值

/**
 * 1. 二分查找
 * 思路：
 * 当nums[mid] < nums[right], 说明最小值在[left ~ mid], right = mid
 * 当nums[mid] >= nums[right], 说明最小值在[mid + 1 ~ right], left = mid + 1;
 * 时间复杂度：O(logN)
 * 空间复杂度：O(1)
 * 执行用时：0ms
 * @param nums
 * @return
 */
public int findMin(int[] nums) {
	int left = 0, right = nums.length - 1;
	while (left < right) {
		int mid = (left + right) >> 1;
		if (nums[mid] < nums[right]) {
			right = mid;
		} else {
			left = mid + 1;
		}
	}
	return left;
}