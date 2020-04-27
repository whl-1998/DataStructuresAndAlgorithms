//88. 合并有序数组

/**
 * 1. 三指针
 * 思路：指针i指向nums1末尾元素, j指向nums2末尾元素, k指向nums[i]和nums[j]比较大小之后应当存放元素的位置
 * 这个算法也是归并排序merge时所采用的
 * 时间复杂度O(n + m)
 * 空间复杂度O(1)
 * 执行用时：0ms
 * @param nums1
 * @param m
 * @param nums2
 * @param n
 */
public void merge(int[] nums1, int m, int[] nums2, int n) {
	int i = m - 1; int j = n - 1; int k = nums1.length - 1;
	while (i >= 0 && j >= 0) {
		nums1[k--] = (nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]);
	}
	// while (i >= 0) nums1[k--] = nums1[i--];
	// while (j >= 0) nums1[k--] = nums2[j--];
	System.arraycopy(nums2, 0, nums1, 0, j + 1);
}